package lk.ijse.asms.bo.custom;

import lk.ijse.asms.bo.SuperBO;
import lk.ijse.asms.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    String getNextCustomerId() throws SQLException, ClassNotFoundException;
    boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    CustomerDTO getCustomerById(String customerId) throws SQLException, ClassNotFoundException;
}
