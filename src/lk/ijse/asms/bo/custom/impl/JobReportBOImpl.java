package lk.ijse.asms.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.asms.bo.custom.JobReportBO;
import lk.ijse.asms.dao.DAOFactory;
import lk.ijse.asms.dao.custom.CustomerDAO;
import lk.ijse.asms.dao.custom.JobDAO;
import lk.ijse.asms.dao.custom.QueryDAO;
import lk.ijse.asms.dto.CustomerDTO;
import lk.ijse.asms.dto.JobDTO;
import lk.ijse.asms.entity.Customer;
import lk.ijse.asms.entity.Job;

import java.sql.SQLException;

public class JobReportBOImpl implements JobReportBO {
    private final CustomerDAO customerDAO=(CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private final JobDAO jobDAO=(JobDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.JOB);
    private final QueryDAO queryDAO=(QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);

    public ObservableList<String> getFinishJobList(String status) throws SQLException, ClassNotFoundException {
        return queryDAO.getFinishJob(status);
    }

    public CustomerDTO getCustomerByName(String customerName) throws SQLException, ClassNotFoundException {
        Customer customerByName = customerDAO.getCustomerByName(customerName);
        return new CustomerDTO(
                customerByName.getId(),
                customerByName.getName(),
                customerByName.getAddress(),
                customerByName.getEmail(),
                customerByName.getContact(),
                customerByName.getIt_manager_name(),
                customerByName.getIt_manager_contact());
    }

    public JobDTO getJobById(String jobId) throws SQLException, ClassNotFoundException {
        Job jobEntity = jobDAO.getJobById(jobId);
        return new JobDTO(
                jobEntity.getId(),
                jobEntity.getType(),
                jobEntity.getCusId(),
                jobEntity.getDudeDate(),
                jobEntity.getTableCount(),
                jobEntity.getVehicleId(),
                jobEntity.getStartDate(),
                jobEntity.getEndDate(),
                jobEntity.getLocation(),
                jobEntity.getJobStatus(),
                jobEntity.getPowerPoint(),
                jobEntity.getDataPoint(),
                jobEntity.getCameraPoint(),
                jobEntity.getDoneBy());
    }
}
