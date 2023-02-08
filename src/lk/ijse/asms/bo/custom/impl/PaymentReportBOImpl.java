package lk.ijse.asms.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.asms.bo.custom.PaymentReportBO;
import lk.ijse.asms.dao.util.DAOFactory;
import lk.ijse.asms.dao.custom.*;
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
    private final SubPaymentDAO paymentDAO=(SubPaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUBCPAYMENT);
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
                employee.getEmployee_id(),
                employee.getEmployee_nic(),
                employee.getEmployee_name(),
                employee.getEmployee_gender(),
                employee.getEmployee_dob(),
                employee.getEmployee_address(),
                employee.getEmployee_email(),
                employee.getEmployee_contact(),
                employee.getEmployee_type(),
                employee.getEmployee_division(),
                employee.getEmployee_joinDate());
    }

    public JobDTO getJobById(String jobId) throws SQLException, ClassNotFoundException {
        Job jobEntity = jobDAO.getJobById(jobId);
        return new JobDTO(
                jobEntity.getJob_id(),
                jobEntity.getJob_type(),
                jobEntity.getCustomer_id(),
                jobEntity.getJob_dude_date(),
                jobEntity.getJob_table_count(),
                jobEntity.getVehicle_id(),
                jobEntity.getJob_start_date(),
                jobEntity.getJob_end_date(),
                jobEntity.getJob_location(),
                jobEntity.getJob_status(),
                jobEntity.getJob_power_point_count(),
                jobEntity.getJob_data_point_count(),
                jobEntity.getJob_camera_point_count(),
                jobEntity.getJob_done_by());

    }

    public SubPaymentDTO getSubPaymentById(String subPayId) throws SQLException, ClassNotFoundException {
        SubPayment subPaymentById = paymentDAO.getSubPaymentById(subPayId);
        return new SubPaymentDTO(
                subPaymentById.getSub_payment_id(),
                subPaymentById.getEmployee_id(),
                subPaymentById.getJob_id(),
                subPaymentById.getJob_power_point_count(),
                subPaymentById.getJob_data_point_count(),
                subPaymentById.getJob_camera_point_count(),
                subPaymentById.getSub_payment_total_amount(),
                subPaymentById.getSub_payment_pay_date(),
                subPaymentById.getSub_payment_pay_status());
    }

    public PaymentPlaneDTO getPointDetails(PaymentPlaneType type) throws SQLException, ClassNotFoundException {
        PaymentPlane pointDetails = paymentPlaneDAO.getPointDetails(type);
        return new PaymentPlaneDTO(pointDetails.getPayment_plane_id(),pointDetails.getPayment_plane_name(),pointDetails.getPayment_plane_description(),pointDetails.getPayment_plane_unite_price());
    }
}
