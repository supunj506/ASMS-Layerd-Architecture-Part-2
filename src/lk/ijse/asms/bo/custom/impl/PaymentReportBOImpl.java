package lk.ijse.asms.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.asms.bo.custom.PaymentReportBO;
import lk.ijse.asms.dao.custom.*;
import lk.ijse.asms.dao.custom.impl.*;
import lk.ijse.asms.dao.util.PaymentPlaneType;
import lk.ijse.asms.dto.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentReportBOImpl implements PaymentReportBO {
    EmployeeDAO employeeDAO=new EmployeeDAOImpl();
    SubcPaymentDAO paymentDAO=new SubcPaymentDAOImpl();
    JobDAO jobDAO=new JobDAOImpl();
    QueryDAO queryDAO=new QueryDAOImpl();
    PaymentPlaneDAO paymentPlaneDAO=new PaymentPlaneDAOImpl();


    public ObservableList<String> getAllContractBaseFinishJob() throws SQLException, ClassNotFoundException {
        ArrayList<String> jobList= queryDAO.getContractBaseFinishJob();
        ObservableList<String> jobIdLIst= FXCollections.observableArrayList();
        for(String item:jobList){
            jobIdLIst.addAll(item);
        }
        return jobIdLIst;
    }

    public EmployeeDTO getEmployeeByNic(String employeeId) throws SQLException, ClassNotFoundException {
        return employeeDAO.getEmployeeByNic(employeeId);
    }

    public JobDTO getJobById(String jobId) throws SQLException, ClassNotFoundException {
        return jobDAO.getJobById(jobId);
    }

    public SubPaymentDTO getSubPaymentById(String subPayId) throws SQLException, ClassNotFoundException {
        return paymentDAO.getSubPaymentById(subPayId);
    }

    public PaymentPlaneDTO getPointDetails(PaymentPlaneType type) throws SQLException, ClassNotFoundException {
        return paymentPlaneDAO.getPointDetails(type);
    }
}
