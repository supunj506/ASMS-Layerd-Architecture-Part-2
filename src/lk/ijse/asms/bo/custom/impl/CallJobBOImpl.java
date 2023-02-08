package lk.ijse.asms.bo.custom.impl;
import javafx.collections.ObservableList;
import lk.ijse.asms.bo.custom.CallJobBO;
import lk.ijse.asms.dao.DAOFactory;
import lk.ijse.asms.dao.custom.*;
import lk.ijse.asms.dao.custom.impl.*;
import lk.ijse.asms.db.DBConnection;
import lk.ijse.asms.dto.CustomDTO;
import lk.ijse.asms.dto.EmpTeamDTO;
import lk.ijse.asms.dto.JobDTO;
import lk.ijse.asms.entity.EmpTeam;
import lk.ijse.asms.entity.Job;
import lk.ijse.asms.entity.Team;
import lk.ijse.asms.view.tm.TeamTM;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CallJobBOImpl implements CallJobBO {

    private final VehicleDAO vehicleDAO=(VehicleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.VEHICLE);
    private final JobDAO jobDAO=(JobDAO)DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.JOB);
    private final TeamDAO teamDAO=(TeamDAO)DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TEAM);
    private final EmpTeamDAO empTeamDAO=(EmpTeamDAO)DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPTEAM);
    private final QueryDAO queryDAO=(QueryDAO)DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);

    public boolean callJob(JobDTO jobDTO, ObservableList<TeamTM>list) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        boolean allAdd;
            boolean isCallJobSave = jobDAO.callJob(new Job(jobDTO.getId(),jobDTO.getVehicleId(),jobDTO.getStartDate(),jobDTO.getJobStatus(),jobDTO.getDoneBy()));
            if(isCallJobSave){
                allAdd=true;
                connection.commit();
                String teamId = teamDAO.getNextTeamId();
                boolean isTeamSave = teamDAO.saveTeam(new Team(teamId, jobDTO.getId()));
                if(isTeamSave){
                    connection.commit();
                    for(TeamTM teamTM:list){
                        boolean isEmpTeamSave = empTeamDAO.saveEmpTeam(new EmpTeam(teamId, teamTM.getId()));
                        if(isEmpTeamSave){
                            allAdd=true;
                            connection.commit();
                        }else {
                            allAdd=false;
                            connection.rollback();
                        }
                    }
                }else {
                    allAdd=false;
                    connection.rollback();
                }
            }else{
                allAdd=false;
                connection.rollback();
            }
            connection.setAutoCommit(true);
            return allAdd;
    }

    public ObservableList<String> lordVehicleDetails() throws SQLException, ClassNotFoundException {
       return vehicleDAO.getAllVehicle();
    }

    public ArrayList<String> getJobDetails(String jobStatus) throws SQLException, ClassNotFoundException {
        return queryDAO.getJobDetails(jobStatus);
    }

    public ObservableList<CustomDTO> getEmployeeDetails(String jobType) throws SQLException, ClassNotFoundException {
        return queryDAO.getEmployeeDetails(jobType);
    }
}
