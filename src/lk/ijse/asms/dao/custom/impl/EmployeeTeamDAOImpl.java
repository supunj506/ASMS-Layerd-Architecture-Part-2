package lk.ijse.asms.dao.custom.impl;

import lk.ijse.asms.dao.util.SQLUtil;
import lk.ijse.asms.dao.custom.EmployeeTeamDAO;
import lk.ijse.asms.entity.EmployeeTeam;

import java.sql.SQLException;

public class EmployeeTeamDAOImpl implements EmployeeTeamDAO {
    @Override
    public boolean saveEmpTeam(EmployeeTeam employeeTeam) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("insert into EmployeeTeam values (?,?)", employeeTeam.getTeam_id(), employeeTeam.getEmployee_id());
    }
}
