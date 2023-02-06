package lk.ijse.asms.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.asms.bo.custom.JobReportBO;
import lk.ijse.asms.dao.custom.CustomerDAO;
import lk.ijse.asms.dao.custom.JobDAO;
import lk.ijse.asms.dao.custom.QueryDAO;
import lk.ijse.asms.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.asms.dao.custom.impl.JobDAOImpl;
import lk.ijse.asms.dao.custom.impl.QueryDAOImpl;
import lk.ijse.asms.dto.CustomerDTO;
import lk.ijse.asms.dto.JobDTO;

import java.sql.SQLException;

public class JobReportBOImpl implements JobReportBO {
    CustomerDAO customerDAO=new CustomerDAOImpl();
    JobDAO jobDAO=new JobDAOImpl();
    QueryDAO queryDAO=new QueryDAOImpl();

    public ObservableList<String> getFinishJobList(String status) throws SQLException, ClassNotFoundException {
        return queryDAO.getFinishJob(status);
    }

    public CustomerDTO getCustomerByName(String customerName) throws SQLException, ClassNotFoundException {
        return customerDAO.getCustomerByName(customerName);
    }

    public JobDTO getJobById(String jobId) throws SQLException, ClassNotFoundException {
        return jobDAO.getJobById(jobId);
    }
}
