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
import lk.ijse.asms.entity.Customer;

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
                customerByName.getId(),
                customerByName.getName(),
                customerByName.getAddress(),
                customerByName.getEmail(),
                customerByName.getContact(),
                customerByName.getItManagerName(),
                customerByName.getItManagerContact());
    }

    public boolean addJob(JobDTO jobDTO) throws SQLException, ClassNotFoundException {
        return jobDAO.addJob(jobDTO);
    }

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> allCustomer = customerDAO.getAllCustomer();
        ArrayList<CustomerDTO> allCustomerDTO=new ArrayList<>();
        for(int i= allCustomer.size();i>0;i--) {
            for (Customer customer : allCustomer) {
                allCustomerDTO.add(new CustomerDTO(
                        customer.getId(),
                        customer.getName(),
                        customer.getAddress(),
                        customer.getEmail(),
                        customer.getContact(),
                        customer.getItManagerName(),
                        customer.getItManagerContact()));
            }
        }
        return allCustomerDTO;
    }
}
