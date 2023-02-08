package lk.ijse.asms.dao.custom.impl;

import lk.ijse.asms.dao.util.SQLUtil;
import lk.ijse.asms.dao.custom.JobDAO;
import lk.ijse.asms.entity.Job;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class JobDAOImpl implements JobDAO {

    @Override
    public String getNextJobId() throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT job_id  FROM Job ORDER BY job_id  DESC LIMIT 1");
        if(rst.next()){
            String jobId=rst.getString(1);
            String[]ids=jobId.split("J");
            int x=Integer.parseInt(ids[1]);
            x+=1;
            if(x>9){
                return "J"+x;
            }
            return "J0"+x;
        }
        return "J01";
    }
    @Override
    public boolean addJob(Job job) throws SQLException, ClassNotFoundException {
        return  SQLUtil.execute("INSERT INTO Job(job_id ,job_type ,customer_id ,job_dude_date ,job_table_count ,job_location ,job_status ) VALUES (?,?,?,?,?,?,?)",
                job.getJob_id(),
                job.getJob_type(),
                job.getCustomer_id(),
                job.getJob_dude_date(),
                job.getJob_table_count(),
                job.getJob_location(),
                job.getJob_status());
    }
    @Override
    public boolean callJob(Job job) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Job SET vehicle_id =?,job_start_date =?,job_status =?,job_done_by =? WHERE job_id =?",
                job.getVehicle_id(),
                job.getJob_start_date(),
                job.getJob_status(),
                job.getJob_done_by(),
                job.getJob_id());
    }
    @Override
    public boolean finishJob(Job job) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Job SET job_end_date =?,job_status =?,job_power_point_count =?,job_data_point_count =?,job_camera_point_count =? WHERE job_id =?",
                job.getJob_end_date(),
                job.getJob_status(),
                job.getJob_power_point_count(),
                job.getJob_data_point_count(),
                job.getJob_camera_point_count(),
                job.getJob_id());
    }
    @Override
    public Job getJobById(String id) throws SQLException, ClassNotFoundException{
        ResultSet rst=SQLUtil.execute("select * from Job where job_id =?",id);
        if(rst.next()){
            return new Job(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    LocalDate.parse(rst.getString(4)),
                    rst.getInt(5),
                    rst.getString(6),
                    LocalDate.parse(rst.getString(7)),
                    LocalDate.parse(rst.getString(8)),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getInt(11),
                    rst.getInt(12),
                    rst.getInt(13),
                    rst.getString(14));

        }
        return null;
    }
}
