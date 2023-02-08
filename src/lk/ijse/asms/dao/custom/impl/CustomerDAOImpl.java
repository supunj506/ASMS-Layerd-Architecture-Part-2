package lk.ijse.asms.dao.custom.impl;

import lk.ijse.asms.dao.custom.CustomerDAO;
import lk.ijse.asms.dao.util.SQLUtil;
import lk.ijse.asms.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public String getNextCustomerId() throws SQLException, ClassNotFoundException {
        ResultSet result = SQLUtil.execute("select customer_id from Customer ORDER BY customer_id DESC limit 1");
        if(result.next()) {
            String currentOrderId = result.getString(1);
            String[] ids = currentOrderId.split("C0");
            int id = Integer.parseInt(ids[1]);
            id += 1;
            return "C0" + id;
        }
        return "C01";
    }

    @Override
    public boolean saveCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Customer VALUES (?,?,?,?,?,?,?)", customer.getCustomer_id(), customer.getCustomer_name(), customer.getCustomer_address(), customer.getCustomer_email(), customer.getCustomer_contact(), customer.getCustomer_it_manager_name(), customer.getCustomer_it_manager_contact());
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Customer SET customer_name =?,customer_address =?,customer_email =?,customer_contact =?,customer_it_manager_name =?,customer_it_manager_contact =? WHERE customer_id =?", customer.getCustomer_name(), customer.getCustomer_address(), customer.getCustomer_email(), customer.getCustomer_contact(), customer.getCustomer_it_manager_name(), customer.getCustomer_it_manager_contact(), customer.getCustomer_id());
    }

    @Override
    public ArrayList<Customer> getAllCustomer() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");
        ArrayList<Customer> allCustomerEntity =new ArrayList<>();

        while (rst.next()){
            allCustomerEntity.add(new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)));
        }
        return allCustomerEntity;
    }

    @Override
    public Customer getCustomerById(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT * FROM Customer where customer_id =?",id) ;
        return createCustomerObject(rst);
    }

    @Override
    public Customer getCustomerByName(String name) throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT * FROM Customer where customer_name =?",name) ;
        return createCustomerObject(rst);

    }

    private Customer createCustomerObject(ResultSet rst) throws SQLException {

        if (rst.next()){
            return new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)
            );
        }
        return null;

    }


}
