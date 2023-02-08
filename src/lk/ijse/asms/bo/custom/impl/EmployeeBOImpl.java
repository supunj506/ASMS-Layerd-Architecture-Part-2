package lk.ijse.asms.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.asms.bo.custom.EmployeeBO;
import lk.ijse.asms.dao.util.DAOFactory;
import lk.ijse.asms.dao.custom.EmployeeDAO;
import lk.ijse.asms.dto.EmployeeDTO;
import lk.ijse.asms.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {
    private final EmployeeDAO employeeDAO;

    public EmployeeBOImpl() {
        employeeDAO=DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    }

    public String getNextEmployeeId() throws SQLException, ClassNotFoundException {
        return employeeDAO.getNextEmployeeId();
    }

    public boolean saveEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return employeeDAO.saveEmployee(convertToEntity(employeeDTO));
    }

    public ObservableList<String> getAllEmployee() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> allEmployeeNics = employeeDAO.getAllEmployee();
        ObservableList<String> allEmployeeNic= FXCollections.observableArrayList();
        for (Employee employee : allEmployeeNics) {
            allEmployeeNic.add(employee.getEmployee_nic());
        }
        return allEmployeeNic;
    }

    public boolean updateEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(convertToEntity(employeeDTO));
    }

    public EmployeeDTO getEmployeeByNic(String employeeNic) throws SQLException, ClassNotFoundException {
         return convertToDTO(employeeDAO.getEmployeeByNic(employeeNic));
    }

    public Employee convertToEntity(EmployeeDTO employeeDTO){
        return new Employee(
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

    public EmployeeDTO convertToDTO(Employee employee){
        return new EmployeeDTO(
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
}
