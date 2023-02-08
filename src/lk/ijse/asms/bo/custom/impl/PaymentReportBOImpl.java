package lk.ijse.asms.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.asms.bo.custom.PaymentReportBO;
import lk.ijse.asms.dao.DAOFactory;
import lk.ijse.asms.dao.custom.*;
import lk.ijse.asms.dao.custom.impl.*;
import lk.ijse.asms.dao.util.PaymentPlaneType;
import lk.ijse.asms.dto.*;
import lk.ijse.asms.entity.Employee;
import lk.ijse.asms.entity.Job;
import lk.ijse.asms.entity.PaymentPlane;
import lk.ijse.asms.entity.SubPayment;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentReportBOImpl implements PaymentReportBO {
    private final EmployeeDAO employeeDAO=(EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    private final SubcPaymentDAO paymentDAO=(SubcPaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUBCPAYMENT);
    private final JobDAO jobDAO=(JobDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.JOB);
    private final QueryDAO queryDAO=(QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);
    private final PaymentPlaneDAO paymentPlaneDAO=(PaymentPlaneDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENTPLANE);


    public ObservableList<String> getAllContractBaseFinishJob() throws SQLException, ClassNotFoundException {
        ArrayList<String> jobList= queryDAO.getContractBaseFinishJob();
        ObservableList<String> jobIdLIst= FXCollections.observableArrayList();
        for(String item:jobList){
            jobIdLIst.addAll(item);
        }
        return jobIdLIst;
    }

    public EmployeeDTO getEmployeeByNic(String employeeId) throws SQLException, ClassNotFoundException {
        Employee employee = employeeDAO.getEmployeeByNic(employeeId);
        return new EmployeeDTO(
                employee.getId(),
                employee.getNic(),
                employee.getName(),
                employee.getGender(),
                employee.getDob(),
                employee.getAddress(),
                employee.getEmail(),
                employee.getContact(),
                employee.getEmpType(),
                employee.getDivision(),
                employee.getJoinDate());
    }

    public JobDTO getJobById(String jobId) throws SQLException, ClassNotFoundException {
        Job jobEntity = jobDAO.getJobById(jobId);
        return new JobDTO(
                jobEntity.getId(),
                jobEntity.getType(),
                jobEntity.getCusId(),
                jobEntity.getDudeDate(),
                jobEntity.getTableCount(),
                jobEntity.getVehicleId(),
                jobEntity.getStartDate(),
                jobEntity.getEndDate(),
                jobEntity.getLocation(),
                jobEntity.getJobStatus(),
                jobEntity.getPowerPoint(),
                jobEntity.getDataPoint(),
                jobEntity.getCameraPoint(),
                jobEntity.getDoneBy());

    }

    public SubPaymentDTO getSubPaymentById(String subPayId) throws SQLException, ClassNotFoundException {
        SubPayment subPaymentById = paymentDAO.getSubPaymentById(subPayId);
        return new SubPaymentDTO(
                subPaymentById.getId(),
                subPaymentById.getEmp_id(),
                subPaymentById.getJob_id(),
                subPaymentById.getData_point(),
                subPaymentById.getPower_point(),
                subPaymentById.getCamera_point(),
                subPaymentById.getTotal_amount(),
                subPaymentById.getPay_date(),
                subPaymentById.getPay_status());
    }

    public PaymentPlaneDTO getPointDetails(PaymentPlaneType type) throws SQLException, ClassNotFoundException {
        PaymentPlane pointDetails = paymentPlaneDAO.getPointDetails(type);
        return new PaymentPlaneDTO(pointDetails.getId(),pointDetails.getName(),pointDetails.getDescription(),pointDetails.getUnitPrice());
    }
}
