package lk.ijse.asms.dao.custom.impl;

import lk.ijse.asms.dao.util.SQLUtil;
import lk.ijse.asms.dao.custom.TeamDAO;
import lk.ijse.asms.entity.Team;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamDAOImpl implements TeamDAO {
    @Override
    public boolean saveTeam(Team teamEntity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("Insert into Team values (?,?)",teamEntity.getTeam_id(),teamEntity.getJob_id());
    }
    @Override
    public String getNextTeamId() throws SQLException, ClassNotFoundException {
       ResultSet rst= SQLUtil.execute("select team_id  from Team order by team_id  desc limit 1 ");
       if(rst.next()){
           String id=(rst.getString(1));
           String []ids=id.split("T");
           int x=Integer.parseInt(ids[1]);
           x+=1;
           if(x>9) {
               return "T" + x;
           }
           return "T0"+x;
       }
        return "T01";
    }



}
