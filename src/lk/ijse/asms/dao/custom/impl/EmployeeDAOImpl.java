package lk.ijse.asms.dao.custom.impl;

import lk.ijse.asms.dao.custom.EmployeeDAO;
import lk.ijse.asms.dto.EmployeeDTO;
import lk.ijse.asms.dao.SQLUtil;
import lk.ijse.asms.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public String getNextEmployeeId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM employee ORDER BY id DESC LIMIT 1");
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
        return SQLUtil.execute("INSERT INTO employee VALUES  (?,?,?,?,?,?,?,?,?,?,?)",
                employee.getId(),
                employee.getNic(),
                employee.getName(),
                employee.getGender(),
                employee.getDob(),
                employee.getAddress(),
                employee.getEmail(),
                employee.getContact(),
                employee.getEmpType(),
                employee.getDivision(),
                employee.getJoinDate());

    }

    @Override
    public boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("Update employee set nic=?,name=?,address=?,email=?,contact=?,e_type=?,division_id=? where id=?",
                employee.getNic(),
                employee.getName(),
                employee.getAddress(),
                employee.getEmail(),
                employee.getContact(),
                employee.getEmpType(),
                employee.getDivision(),
                employee.getId());
    }

    @Override
    public boolean delete(String text) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("Delete from employee where id =?",text);
    }

    @Override
    public ArrayList<Employee> getAllEmployee() throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT * FROM employee ");
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
        ResultSet rst= SQLUtil.execute("SELECT * FROM employee WHERE nic=?",nic);
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
