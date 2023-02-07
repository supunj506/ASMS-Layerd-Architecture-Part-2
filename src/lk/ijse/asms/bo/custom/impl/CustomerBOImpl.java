package lk.ijse.asms.bo.custom.impl;

import lk.ijse.asms.bo.custom.CustomerBO;
import lk.ijse.asms.dao.DAOFactory;
import lk.ijse.asms.dao.custom.CustomerDAO;
import lk.ijse.asms.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.asms.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO=(CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    public String getNextCustomerId() throws SQLException, ClassNotFoundException {
        return customerDAO.getNextCustomerId();
    }

    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.saveCustomer(customerDTO);
    }

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.getAllCustomer();
    }

    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.update(customerDTO);
    }

    public CustomerDTO getCustomerById(String customerId) throws SQLException, ClassNotFoundException {
        return customerDAO.getCustomerById(customerId);
    }
}
