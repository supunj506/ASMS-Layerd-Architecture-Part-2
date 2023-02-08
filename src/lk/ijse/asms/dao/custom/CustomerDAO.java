package lk.ijse.asms.dao.custom;
import lk.ijse.asms.dao.util.CrudDAO;
import lk.ijse.asms.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer,String> {
    String getNextCustomerId() throws SQLException, ClassNotFoundException;
    boolean saveCustomer(Customer customer) throws SQLException, ClassNotFoundException;
    boolean update(Customer customer) throws SQLException, ClassNotFoundException;
    ArrayList<Customer> getAllCustomer() throws SQLException, ClassNotFoundException;
    Customer getCustomerById(String id) throws SQLException, ClassNotFoundException;
    Customer getCustomerByName(String name)throws SQLException, ClassNotFoundException;

}
