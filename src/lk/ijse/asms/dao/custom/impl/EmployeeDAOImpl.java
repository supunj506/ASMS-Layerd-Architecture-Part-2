package lk.ijse.asms.dao.custom.impl;

import lk.ijse.asms.dao.custom.EmployeeDAO;
import lk.ijse.asms.dto.EmployeeDTO;
import lk.ijse.asms.dao.util.SQLUtil;

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
    public boolean saveEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO employee VALUES  (?,?,?,?,?,?,?,?,?,?,?)",
                employeeDTO.getId(),
                employeeDTO.getNic(),
                employeeDTO.getName(),
                employeeDTO.getGender(),
                employeeDTO.getDob(),
                employeeDTO.getAddress(),
                employeeDTO.getEmail(),
                employeeDTO.getContact(),
                employeeDTO.getEmpType(),
                employeeDTO.getDivision(),
                employeeDTO.getJoinDate());

    }
    @Override
    public boolean update(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("Update employee set nic=?,name=?,address=?,email=?,contact=?,e_type=?,division_id=? where id=?",
                employeeDTO.getNic(),
                employeeDTO.getName(),
                employeeDTO.getAddress(),
                employeeDTO.getEmail(),
                employeeDTO.getContact(),
                employeeDTO.getEmpType(),
                employeeDTO.getDivision(),
                employeeDTO.getId());
    }
    @Override
    public boolean delete(String text) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("Delete from employee where id =?",text);
    }

    @Override
    public ArrayList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT * FROM employee ");
        ArrayList<EmployeeDTO> allEmployeeDTO =new ArrayList<>();
        while (rst.next()){
            allEmployeeDTO.add(new EmployeeDTO(
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
        return allEmployeeDTO;
    }
    @Override
    public EmployeeDTO getEmployee(String nic) throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT * FROM employee WHERE nic=?",nic);
        if(rst.next()){
           return new EmployeeDTO(
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
