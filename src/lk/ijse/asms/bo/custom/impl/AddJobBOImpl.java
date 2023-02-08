package lk.ijse.asms.bo.custom.impl;

import lk.ijse.asms.bo.custom.AddJobBO;
import lk.ijse.asms.dao.util.DAOFactory;
import lk.ijse.asms.dao.custom.CustomerDAO;
import lk.ijse.asms.dao.custom.JobDAO;
import lk.ijse.asms.dto.CustomerDTO;
import lk.ijse.asms.dto.JobDTO;
import lk.ijse.asms.entity.Customer;
import lk.ijse.asms.entity.Job;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddJobBOImpl implements AddJobBO {
    private final CustomerDAO customerDAO= (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private final JobDAO jobDAO=(JobDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.JOB);

    public String getNextJobId() throws SQLException, ClassNotFoundException {
        return jobDAO.getNextJobId();
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

    public boolean addJob(JobDTO jobDTO) throws SQLException, ClassNotFoundException {
        return jobDAO.addJob(new Job(jobDTO.getId(),jobDTO.getType(),jobDTO.getCusId(),jobDTO.getDudeDate(),jobDTO.getTableCount(),jobDTO.getLocation(),jobDTO.getJobStatus()));
    }

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> allCustomer = customerDAO.getAllCustomer();
        ArrayList<CustomerDTO> allCustomerDTO=new ArrayList<>();
            for (Customer customer : allCustomer) {
                allCustomerDTO.add(new CustomerDTO(
                        customer.getCustomer_id(),
                        customer.getCustomer_name(),
                        customer.getCustomer_address(),
                        customer.getCustomer_email(),
                        customer.getCustomer_contact(),
                        customer.getCustomer_it_manager_name(),
                        customer.getCustomer_it_manager_contact()));
            }
        return allCustomerDTO;
    }
}
