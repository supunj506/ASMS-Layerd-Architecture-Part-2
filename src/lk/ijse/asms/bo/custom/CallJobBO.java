package lk.ijse.asms.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.asms.dto.CustomDTO;
import lk.ijse.asms.dto.JobDTO;
import lk.ijse.asms.view.tm.TeamTM;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CallJobBO {
    boolean callJob(JobDTO jobDTO, ObservableList<TeamTM> list) throws SQLException, ClassNotFoundException;
    ObservableList<String> lordVehicleDetails() throws SQLException, ClassNotFoundException;
    ArrayList<String> getJobDetails(String jobStatus) throws SQLException, ClassNotFoundException;
    ObservableList<CustomDTO> getEmployeeDetails(String jobType) throws SQLException, ClassNotFoundException;
}
