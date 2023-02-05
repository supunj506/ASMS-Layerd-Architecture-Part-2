package lk.ijse.asms.dao.custom;

import lk.ijse.asms.dao.CrudDAO;
import lk.ijse.asms.dto.EmpTeamDTO;

import java.sql.SQLException;

public interface EmpTeamDAO extends CrudDAO<EmpTeamDTO> {
    boolean saveEmpTeam(EmpTeamDTO empTeam) throws SQLException, ClassNotFoundException;
}
