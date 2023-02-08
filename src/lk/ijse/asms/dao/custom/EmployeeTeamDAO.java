package lk.ijse.asms.dao.custom;

import lk.ijse.asms.dao.util.CrudDAO;
import lk.ijse.asms.entity.EmployeeTeam;

import java.sql.SQLException;

public interface EmployeeTeamDAO extends CrudDAO<EmployeeTeam,String> {
    boolean saveEmpTeam(EmployeeTeam employeeTeam) throws SQLException, ClassNotFoundException;
}
