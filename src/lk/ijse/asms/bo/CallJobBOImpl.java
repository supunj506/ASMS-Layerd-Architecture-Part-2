package lk.ijse.asms.bo;
import javafx.collections.ObservableList;
import lk.ijse.asms.dao.custom.*;
import lk.ijse.asms.dao.custom.impl.*;
import lk.ijse.asms.db.DBConnection;
import lk.ijse.asms.dto.CustomDTO;
import lk.ijse.asms.dto.EmpTeamDTO;
import lk.ijse.asms.dto.JobDTO;
import lk.ijse.asms.view.tm.TeamTM;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CallJobBOImpl {
    VehicleDAO vehicleDAO=new VehicleDAOImpl();
    JobDAO jobDAO=new JobDAOImpl();
    TeamDAO teamDAO=new TeamDAOImpl();
    EmpTeamDAO empTeamDAO=new EmpTeamDAOImpl();
    QueryDAO queryDAO=new QueryDAOImpl();

    public boolean callJob(JobDTO jobDTO, ObservableList<TeamTM>list) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        boolean allAdd;
            boolean isCallJobSave = jobDAO.callJob(jobDTO);
            if(isCallJobSave){
                allAdd=true;
                connection.commit();
                String teamId = teamDAO.getNextTeamId();
                boolean isTeamSave = teamDAO.saveTeam(teamId, jobDTO.getId());
                if(isTeamSave){
                    connection.commit();
                    for(TeamTM teamTM:list){
                        boolean isEmpTeamSave = empTeamDAO.saveEmpTeam(new EmpTeamDTO(teamId, teamTM.getId()));
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
