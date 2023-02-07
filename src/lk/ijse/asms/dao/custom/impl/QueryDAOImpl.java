package lk.ijse.asms.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.asms.dao.SQLUtil;
import lk.ijse.asms.dao.custom.QueryDAO;
import lk.ijse.asms.dto.CustomDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ObservableList<CustomDTO> getEmployeeDetails(String employeeType) throws SQLException, ClassNotFoundException {
        ObservableList<CustomDTO>list= FXCollections.observableArrayList();
        ResultSet rst= SQLUtil.execute("select e.id,e.name,d.job from employee e inner join division d on e.division_id=d.id where e.e_type=?",employeeType);
        while (rst.next()){
            list.add(new CustomDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)

            ));
        }
        return list;
    }

    @Override
    public CustomDTO getDetailForSubcPayment(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("select et.emp_id,j.data_point,j.power_pint,j.camera_point from emp_team et inner join team t on t.id=et.team_id inner join job j on j.id=t.job_id where j.id=?",id);
        if (rst.next()){
            return new CustomDTO(rst.getString(1),rst.getInt(2),rst.getInt(3),rst.getInt(4));
        }
        return null;
    }
    @Override
    public ArrayList<String> getContractBaseFinishJob() throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("select sub.id,sub.job_id,e.nic,e.name from subc_payment sub inner join employee e on e.id=sub.emp_id where sub.pay_status='REMINNING'");
        ArrayList<String>list= new ArrayList<>();
        while (rst.next()){
            list.add(rst.getString(1)+" / "+rst.getString(2)+" / "+rst.getString(3)+" / "+rst.getString(4));
        }
        return list;
    }
    @Override
    public ObservableList<String> getFinishJob(String status) throws SQLException, ClassNotFoundException {
        ObservableList<String> list=FXCollections.observableArrayList();
        ResultSet rst= SQLUtil.execute("SELECT j.id,c.name,j.location FROM job j INNER JOIN customer c on j.cus_id = c.id WHERE j.job_status=? order by id;",status);
        while (rst.next()){
            list.add(rst.getString(1)+" / "+rst.getString(2)+" / "+rst.getString(3));
        }
        return list;
    }
    @Override
    public ArrayList<String> getJobDetails(String status) throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT j.id,c.name,j.location FROM job j INNER JOIN customer c ON j.cus_id=c.id WHERE j.job_status=? ",status);
        ArrayList<String >list=new ArrayList<>();
        while (rst.next()){
            list.add(rst.getString(1)+" / "+rst.getString(2)+" / "+rst.getString(3));
        }
        return list;
    }


}
