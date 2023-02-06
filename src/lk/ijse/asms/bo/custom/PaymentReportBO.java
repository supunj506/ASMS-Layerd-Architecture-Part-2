package lk.ijse.asms.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.asms.dao.util.PaymentPlaneType;
import lk.ijse.asms.dto.EmployeeDTO;
import lk.ijse.asms.dto.JobDTO;
import lk.ijse.asms.dto.PaymentPlaneDTO;
import lk.ijse.asms.dto.SubPaymentDTO;

import java.sql.SQLException;

public interface PaymentReportBO {
    ObservableList<String> getAllContractBaseFinishJob() throws SQLException, ClassNotFoundException;
    EmployeeDTO getEmployeeByNic(String employeeId) throws SQLException, ClassNotFoundException;
    JobDTO getJobById(String jobId) throws SQLException, ClassNotFoundException;
    SubPaymentDTO getSubPaymentById(String subPayId) throws SQLException, ClassNotFoundException;
    PaymentPlaneDTO getPointDetails(PaymentPlaneType type) throws SQLException, ClassNotFoundException;
}
