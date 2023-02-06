package lk.ijse.asms.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.asms.bo.custom.EmployeeBO;
import lk.ijse.asms.dao.custom.EmployeeDAO;
import lk.ijse.asms.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.asms.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO=new EmployeeDAOImpl();

    public String getNextEmployeeId() throws SQLException, ClassNotFoundException {
        return employeeDAO.getNextEmployeeId();
    }

    public boolean saveEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return employeeDAO.saveEmployee(employeeDTO);
    }

    public ObservableList<String> getAllEmployee() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeDTO> allEmployee = employeeDAO.getAllEmployee();
        ObservableList<String> allEmployeeNic= FXCollections.observableArrayList();
        for (EmployeeDTO employeeDTO : allEmployee) {
            allEmployeeNic.add(employeeDTO.getNic());
        }
        return allEmployeeNic;
    }

    public boolean updateEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(employeeDTO);
    }

    public EmployeeDTO getEmployeeByNic(String employeeNic) throws SQLException, ClassNotFoundException {
        return employeeDAO.getEmployeeByNic(employeeNic);
    }
}
