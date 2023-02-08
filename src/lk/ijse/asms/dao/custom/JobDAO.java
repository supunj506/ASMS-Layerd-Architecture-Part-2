package lk.ijse.asms.dao.custom;

import lk.ijse.asms.dao.CrudDAO;
import lk.ijse.asms.dao.SuperDAO;
import lk.ijse.asms.dto.JobDTO;
import lk.ijse.asms.entity.Job;

import java.sql.SQLException;

public interface JobDAO extends CrudDAO<Job,String> {
    String getNextJobId() throws SQLException, ClassNotFoundException;
    boolean addJob(Job job) throws SQLException, ClassNotFoundException;
    boolean callJob(Job job) throws SQLException, ClassNotFoundException;
    boolean finishJob(Job job) throws SQLException, ClassNotFoundException;
    Job getJobById(String id) throws SQLException, ClassNotFoundException;



}
