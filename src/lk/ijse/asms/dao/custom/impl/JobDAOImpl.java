package lk.ijse.asms.dao.custom.impl;

import lk.ijse.asms.dao.SQLUtil;
import lk.ijse.asms.dao.custom.JobDAO;
import lk.ijse.asms.dto.JobDTO;
import lk.ijse.asms.entity.Job;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class JobDAOImpl implements JobDAO {

    @Override
    public String getNextJobId() throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT id FROM job ORDER BY id DESC LIMIT 1");
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
        return  SQLUtil.execute("INSERT INTO job(id,type,cus_id,dude_date,table_count,location,job_status) VALUES (?,?,?,?,?,?,?)",
                job.getId(),
                job.getType(),
                job.getCusId(),
                job.getDudeDate(),
                job.getTableCount(),
                job.getLocation(),
                job.getJobStatus());
    }
    @Override
    public boolean callJob(Job job) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE job SET vehicle_id=?,start_date=?,job_status=?,done_by=? WHERE id=?",
                job.getVehicleId(),
                job.getStartDate(),
                job.getJobStatus(),
                job.getDoneBy(),
                job.getId());
    }
    @Override
    public boolean finishJob(Job job) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE job SET end_date=?,job_status=?,power_pint=?,data_point=?,camera_point=? WHERE id=?",
                job.getEndDate(),
                job.getJobStatus(),
                job.getPowerPoint(),
                job.getDataPoint(),
                job.getCameraPoint(),
                job.getId());
    }
    @Override
    public Job getJobById(String id) throws SQLException, ClassNotFoundException{
        ResultSet rst=SQLUtil.execute("select * from job where id=?",id);
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
