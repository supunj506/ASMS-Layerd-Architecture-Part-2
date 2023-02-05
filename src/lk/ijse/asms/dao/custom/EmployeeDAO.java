package lk.ijse.asms.dao.custom;

import lk.ijse.asms.dao.CrudDAO;
import lk.ijse.asms.dto.EmployeeDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO extends CrudDAO<EmployeeDTO> {
    String getNextEmployeeId() throws SQLException, ClassNotFoundException;
    boolean saveEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;
    boolean update(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;
    boolean delete(String text) throws SQLException, ClassNotFoundException;
    ArrayList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException;
    EmployeeDTO getEmployee(String nic) throws SQLException, ClassNotFoundException;

}
