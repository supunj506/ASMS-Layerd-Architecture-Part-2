package lk.ijse.asms.dao.custom.impl;

import lk.ijse.asms.dao.util.SQLUtil;
import lk.ijse.asms.dao.custom.TeamDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamDAOImpl implements TeamDAO {
    @Override
    public boolean saveTeam(String id,String jobId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("Insert into team values (?,?)",id,jobId);
    }
    @Override
    public String getNextTeamId() throws SQLException, ClassNotFoundException {
       ResultSet rst= SQLUtil.execute("select id from team order by id desc limit 1 ");
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
