package lk.ijse.asms.bo.custom;

import lk.ijse.asms.dto.CustomerDTO;
import lk.ijse.asms.dto.JobDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AddJobBO {
    String getNextJobId() throws SQLException, ClassNotFoundException;
    CustomerDTO getCustomerByName(String customerName) throws SQLException, ClassNotFoundException;
    boolean addJob(JobDTO jobDTO) throws SQLException, ClassNotFoundException;
    ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
}
