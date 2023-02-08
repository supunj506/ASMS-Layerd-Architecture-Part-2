package lk.ijse.asms.dao.custom.impl;

import lk.ijse.asms.dao.custom.EmployeeDAO;
import lk.ijse.asms.dao.util.SQLUtil;
import lk.ijse.asms.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public String getNextEmployeeId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT employee_id  FROM Employee ORDER BY employee_id  DESC LIMIT 1");
        if(rst.next()){
            String empId=rst.getString(1);
            String []ids= empId.split("E0");
            int id=Integer.parseInt(ids[1]);
            id+=1;
            return "E0"+id;
        }
        return "E01";
    }

    @Override
    public boolean saveEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Employee VALUES  (?,?,?,?,?,?,?,?,?,?,?)",
                employee.getEmployee_id(),
                employee.getEmployee_nic(),
                employee.getEmployee_name(),
                employee.getEmployee_gender(),
                employee.getEmployee_dob(),
                employee.getEmployee_address(),
                employee.getEmployee_email(),
                employee.getEmployee_contact(),
                employee.getEmployee_type(),
                employee.getEmployee_division(),
                employee.getEmployee_joinDate());

    }

    @Override
    public boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("Update Employee set employee_nic =?,employee_name =?,employee_address =?,employee_email =?,employee_contact =?,employee_type =?,employee_division =? where employee_id =?",
                employee.getEmployee_nic(),
                employee.getEmployee_name(),
                employee.getEmployee_address(),
                employee.getEmployee_email(),
                employee.getEmployee_contact(),
                employee.getEmployee_type(),
                employee.getEmployee_division(),
                employee.getEmployee_id());
    }

    @Override
    public boolean delete(String text) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("Delete from Employee where employee_id  =?",text);
    }

    @Override
    public ArrayList<Employee> getAllEmployee() throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT * FROM Employee ");
        ArrayList<Employee> allEmployeeEntity =new ArrayList<>();
        while (rst.next()){
            allEmployeeEntity.add(new Employee(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    LocalDate.parse(String.valueOf(rst.getString(5))),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    LocalDate.parse(String.valueOf(rst.getString(11)))

            ));
        }
        return allEmployeeEntity;
    }

    @Override
    public Employee getEmployeeByNic(String nic) throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT * FROM Employee WHERE employee_nic =?",nic);
        if(rst.next()){
           return new Employee(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    LocalDate.parse(String.valueOf(rst.getString(5))),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    LocalDate.parse(String.valueOf(rst.getString(11)))

            );
        }
        return null;
    }

}
