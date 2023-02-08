package lk.ijse.asms.dao.custom;

import lk.ijse.asms.dao.CrudDAO;
import lk.ijse.asms.dao.SuperDAO;
import lk.ijse.asms.dto.TeamDTO;
import lk.ijse.asms.entity.Team;

import java.sql.SQLException;

public interface TeamDAO extends CrudDAO<Team,String>{
    boolean saveTeam(Team team) throws SQLException, ClassNotFoundException;
    String getNextTeamId() throws SQLException, ClassNotFoundException;

}
