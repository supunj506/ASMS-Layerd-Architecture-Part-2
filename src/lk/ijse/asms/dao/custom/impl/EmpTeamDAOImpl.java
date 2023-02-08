package lk.ijse.asms.dao.custom.impl;

import lk.ijse.asms.dao.SQLUtil;
import lk.ijse.asms.dao.custom.EmpTeamDAO;
import lk.ijse.asms.dto.EmpTeamDTO;
import lk.ijse.asms.entity.EmpTeam;

import java.sql.SQLException;

public class EmpTeamDAOImpl implements EmpTeamDAO {
    @Override
    public boolean saveEmpTeam(EmpTeam empTeam) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("insert into emp_team values (?,?)",empTeam.getTeam_it(),empTeam.getEmp_id());
    }
}
