package lk.ijse.asms.bo.custom.impl;

import lk.ijse.asms.bo.custom.CustomerBO;
import lk.ijse.asms.dao.DAOFactory;
import lk.ijse.asms.dao.custom.CustomerDAO;
import lk.ijse.asms.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.asms.dto.CustomerDTO;
import lk.ijse.asms.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    private final CustomerDAO customerDAO=(CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    public String getNextCustomerId() throws SQLException, ClassNotFoundException {
        return customerDAO.getNextCustomerId();
    }

    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.saveCustomer(convertObjectType(customerDTO));
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

    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.update(convertObjectType(customerDTO));
    }

    public CustomerDTO getCustomerById(String customerId) throws SQLException, ClassNotFoundException {
        Customer customerById = customerDAO.getCustomerById(customerId);
        return new CustomerDTO(
                customerById.getId(),
                customerById.getName(),
                customerById.getAddress(),
                customerById.getEmail(),
                customerById.getContact(),
                customerById.getItManagerName(),
                customerById.getItManagerContact());
    }

    private Customer convertObjectType(CustomerDTO customerDTO){
       return new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getEmail(),
                customerDTO.getContact(),
                customerDTO.getItManagerName(),
                customerDTO.getItManagerContact()
                );
    }

}
