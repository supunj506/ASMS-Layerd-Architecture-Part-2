package lk.ijse.asms.dao.custom;

import lk.ijse.asms.dao.util.CrudDAO;
import lk.ijse.asms.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO extends CrudDAO<Employee,String> {
    String getNextEmployeeId() throws SQLException, ClassNotFoundException;
    boolean saveEmployee(Employee employee) throws SQLException, ClassNotFoundException;
    boolean update(Employee employee) throws SQLException, ClassNotFoundException;
    boolean delete(String text) throws SQLException, ClassNotFoundException;
    ArrayList<Employee> getAllEmployee() throws SQLException, ClassNotFoundException;
    Employee getEmployeeByNic(String nic) throws SQLException, ClassNotFoundException;

}
