package lk.ijse.asms.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.asms.dto.CustomerDTO;
import lk.ijse.asms.dto.JobDTO;

import java.sql.SQLException;

public interface JobReportBO {
    ObservableList<String> getFinishJobList(String status) throws SQLException, ClassNotFoundException;
    CustomerDTO getCustomerByName(String customerName) throws SQLException, ClassNotFoundException;
    JobDTO getJobById(String jobId) throws SQLException, ClassNotFoundException;
}
