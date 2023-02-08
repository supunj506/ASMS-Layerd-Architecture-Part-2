package lk.ijse.asms.bo.custom.impl;

import lk.ijse.asms.bo.custom.CustomerBO;
import lk.ijse.asms.dao.util.DAOFactory;
import lk.ijse.asms.dao.custom.CustomerDAO;
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
        ArrayList<CustomerDTO> allCustomerDTO=new ArrayList<>();
            for (Customer customer : customerDAO.getAllCustomer()) {
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

    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.update(convertObjectType(customerDTO));
    }

    public CustomerDTO getCustomerById(String customerId) throws SQLException, ClassNotFoundException {
        Customer customerById = customerDAO.getCustomerById(customerId);
        return new CustomerDTO(
                customerById.getCustomer_id(),
                customerById.getCustomer_name(),
                customerById.getCustomer_address(),
                customerById.getCustomer_email(),
                customerById.getCustomer_contact(),
                customerById.getCustomer_it_manager_name(),
                customerById.getCustomer_it_manager_contact());
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
