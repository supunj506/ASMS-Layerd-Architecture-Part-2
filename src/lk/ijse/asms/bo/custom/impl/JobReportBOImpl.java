package lk.ijse.asms.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.asms.bo.custom.JobReportBO;
import lk.ijse.asms.dao.util.DAOFactory;
import lk.ijse.asms.dao.custom.CustomerDAO;
import lk.ijse.asms.dao.custom.JobDAO;
import lk.ijse.asms.dao.custom.QueryDAO;
import lk.ijse.asms.dto.CustomerDTO;
import lk.ijse.asms.dto.JobDTO;
import lk.ijse.asms.entity.Customer;
import lk.ijse.asms.entity.Job;

import java.sql.SQLException;

public class JobReportBOImpl implements JobReportBO {
    private final CustomerDAO customerDAO;
    private final JobDAO jobDAO;
    private final QueryDAO queryDAO;

    public JobReportBOImpl() {
        customerDAO=DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
        jobDAO=DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.JOB);
        queryDAO=DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);

    }

    public ObservableList<String> getFinishJobList(String status) throws SQLException, ClassNotFoundException {
        return queryDAO.getFinishJob(status);
    }

    public CustomerDTO getCustomerByName(String customerName) throws SQLException, ClassNotFoundException {
        Customer customerByName = customerDAO.getCustomerByName(customerName);
        return new CustomerDTO(
                customerByName.getCustomer_id(),
                customerByName.getCustomer_name(),
                customerByName.getCustomer_address(),
                customerByName.getCustomer_email(),
                customerByName.getCustomer_contact(),
                customerByName.getCustomer_it_manager_name(),
                customerByName.getCustomer_it_manager_contact());
    }

    public JobDTO getJobById(String jobId) throws SQLException, ClassNotFoundException {
        Job jobEntity = jobDAO.getJobById(jobId);
        return new JobDTO(
                jobEntity.getJob_id(),
                jobEntity.getJob_type(),
                jobEntity.getCustomer_id(),
                jobEntity.getJob_dude_date(),
                jobEntity.getJob_table_count(),
                jobEntity.getVehicle_id(),
                jobEntity.getJob_start_date(),
                jobEntity.getJob_end_date(),
                jobEntity.getJob_location(),
                jobEntity.getJob_status(),
                jobEntity.getJob_power_point_count(),
                jobEntity.getJob_data_point_count(),
                jobEntity.getJob_camera_point_count(),
                jobEntity.getJob_done_by());
    }
}
