package lk.ijse.asms.dao.custom;

import lk.ijse.asms.dao.CrudDAO;
import lk.ijse.asms.dao.SuperDAO;
import lk.ijse.asms.dto.EmpTeamDTO;
import lk.ijse.asms.entity.EmpTeam;

import java.sql.SQLException;

public interface EmpTeamDAO extends CrudDAO<EmpTeam,String> {
    boolean saveEmpTeam(EmpTeam empTeam) throws SQLException, ClassNotFoundException;
}
