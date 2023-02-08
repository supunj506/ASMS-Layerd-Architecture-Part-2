package lk.ijse.asms.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.asms.dao.util.SQLUtil;
import lk.ijse.asms.dao.custom.QueryDAO;
import lk.ijse.asms.dto.CustomDTO;
import lk.ijse.asms.entity.CustomEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ObservableList<CustomEntity> getEmployeeDetails(String employeeType) throws SQLException, ClassNotFoundException {
        ObservableList<CustomEntity>list= FXCollections.observableArrayList();
        ResultSet rst= SQLUtil.execute("select employee.employee_id,employee.employee_name,division.division_type  from Employee employee inner join Division division on employee.employee_division =division.division_id where employee.employee_type =?",employeeType);
        while (rst.next()){
            list.add(new CustomEntity(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)

            ));
        }
        return list;
    }
    @Override
    public CustomEntity getDetailForSubPayment(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("select et.employee_id ,j.job_data_point_count ,j.job_power_point_count ,j.job_camera_point_count  from EmployeeTeam et inner join Team t on t.team_id =et.team_id inner join Job j on j.job_id =t.job_id where j.job_id =?",id);
        if (rst.next()){
            return new CustomEntity(rst.getString(1),rst.getInt(2),rst.getInt(3),rst.getInt(4));
        }
        return null;
    }
    @Override
    public ArrayList<String> getContractBaseFinishJob() throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("select sub.sub_payment_id ,sub.job_id,e.employee_nic ,e.employee_name  from SubPayment sub inner join Employee e on e.employee_id =sub.employee_id  where sub.sub_payment_pay_status ='REMINNING'");
        ArrayList<String>list= new ArrayList<>();
        while (rst.next()){
            list.add(rst.getString(1)+" / "+rst.getString(2)+" / "+rst.getString(3)+" / "+rst.getString(4));
        }
        return list;
    }
    @Override
    public ObservableList<String> getFinishJob(String status) throws SQLException, ClassNotFoundException {
        ObservableList<String> list=FXCollections.observableArrayList();
        ResultSet rst= SQLUtil.execute("SELECT j.job_id ,c.customer_name ,j.job_location  FROM Job j INNER JOIN Customer c on j.customer_id  = c.customer_id  WHERE j.job_status =? order by job_id ;",status);
        while (rst.next()){
            list.add(rst.getString(1)+" / "+rst.getString(2)+" / "+rst.getString(3));
        }
        return list;
    }
    @Override
    public ArrayList<String> getJobDetails(String status) throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT j.job_id ,c.customer_name ,j.job_location  FROM Job j INNER JOIN Customer c ON j.customer_id =c.customer_id  WHERE j.job_status =? ",status);
        ArrayList<String >list=new ArrayList<>();
        while (rst.next()){
            list.add(rst.getString(1)+" / "+rst.getString(2)+" / "+rst.getString(3));
        }
        return list;
    }


}
