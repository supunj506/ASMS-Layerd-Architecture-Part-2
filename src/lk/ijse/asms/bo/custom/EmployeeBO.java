package lk.ijse.asms.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.asms.bo.SuperBO;
import lk.ijse.asms.dto.EmployeeDTO;

import java.sql.SQLException;

public interface EmployeeBO extends SuperBO {
    String getNextEmployeeId() throws SQLException, ClassNotFoundException;
    boolean saveEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;
    ObservableList<String> getAllEmployee() throws SQLException, ClassNotFoundException;
    boolean updateEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;
    EmployeeDTO getEmployeeByNic(String employeeNic) throws SQLException, ClassNotFoundException;
}
