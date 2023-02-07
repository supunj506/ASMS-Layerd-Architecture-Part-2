package lk.ijse.asms.dao.custom;

import lk.ijse.asms.dao.CrudDAO;
import lk.ijse.asms.dao.SuperDAO;
import lk.ijse.asms.dto.TeamDTO;

import java.sql.SQLException;

public interface TeamDAO extends CrudDAO<TeamDTO>{
    boolean saveTeam(String id,String jobId) throws SQLException, ClassNotFoundException;
    String getNextTeamId() throws SQLException, ClassNotFoundException;

}
