package lk.ijse.asms.dao.custom.impl;

import lk.ijse.asms.dao.custom.CustomerDAO;
import lk.ijse.asms.dto.CustomerDTO;
import lk.ijse.asms.dao.SQLUtil;
import lk.ijse.asms.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public String getNextCustomerId() throws SQLException, ClassNotFoundException {
        ResultSet result = SQLUtil.execute("SELECT id FROM customer  ORDER BY id DESC LIMIT 1");
        if(result.next()) {
            String currentOrderId=result.getString(1);
            String[] ids = currentOrderId.split("C0");
            int id = Integer.parseInt(ids[1]);
            id += 1;
            return "C0" + id;
        }
        return "C01";
    }

    @Override
    public boolean saveCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO customer VALUES (?,?,?,?,?,?,?)", customer.getId(), customer.getName(), customer.getAddress(), customer.getEmail(), customer.getContact(), customer.getItManagerName(), customer.getItManagerContact());
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE customer SET name=?,address=?,email=?,contact=?,it_manager_name=?,it_manager_contact=? WHERE id=?", customer.getName(), customer.getAddress(), customer.getEmail(), customer.getContact(), customer.getItManagerName(), customer.getItManagerContact(), customer.getId());
    }

    @Override
    public ArrayList<Customer> getAllCustomer() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM customer");
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
        ResultSet rst= SQLUtil.execute("SELECT * FROM customer where id=?",id) ;
        return createCustomerObject(rst);
    }

    @Override
    public Customer getCustomerByName(String name) throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT * FROM customer where name=?",name) ;
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
