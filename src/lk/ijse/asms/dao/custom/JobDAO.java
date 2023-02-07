package lk.ijse.asms.dao.custom;

import lk.ijse.asms.dao.CrudDAO;
import lk.ijse.asms.dao.SuperDAO;
import lk.ijse.asms.dto.JobDTO;
import java.sql.SQLException;

public interface JobDAO extends CrudDAO<JobDTO> {
    String getNextJobId() throws SQLException, ClassNotFoundException;
    boolean addJob(JobDTO jobDTO) throws SQLException, ClassNotFoundException;
    boolean callJob(JobDTO jobDTO) throws SQLException, ClassNotFoundException;
    boolean finishJob(JobDTO jobDTO) throws SQLException, ClassNotFoundException;
    JobDTO getJobById(String id) throws SQLException, ClassNotFoundException;



}
