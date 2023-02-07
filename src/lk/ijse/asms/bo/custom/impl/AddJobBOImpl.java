package lk.ijse.asms.bo.custom.impl;

import lk.ijse.asms.bo.custom.AddJobBO;
import lk.ijse.asms.dao.DAOFactory;
import lk.ijse.asms.dao.SuperDAO;
import lk.ijse.asms.dao.custom.CustomerDAO;
import lk.ijse.asms.dao.custom.JobDAO;
import lk.ijse.asms.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.asms.dao.custom.impl.JobDAOImpl;
import lk.ijse.asms.dto.CustomerDTO;
import lk.ijse.asms.dto.JobDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddJobBOImpl implements AddJobBO {
    CustomerDAO customerDAO= (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    JobDAO jobDAO=(JobDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.JOB);

    public String getNextJobId() throws SQLException, ClassNotFoundException {
        return jobDAO.getNextJobId();
    }

    public CustomerDTO getCustomerByName(String customerName) throws SQLException, ClassNotFoundException {
        return customerDAO.getCustomerByName(customerName);
    }

    public boolean addJob(JobDTO jobDTO) throws SQLException, ClassNotFoundException {
        return jobDAO.addJob(jobDTO);
    }

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.getAllCustomer();
    }
}
