package lk.ijse.asms.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.asms.bo.custom.FinishJobBO;
import lk.ijse.asms.dao.custom.JobDAO;
import lk.ijse.asms.dao.custom.PaymentPlaneDAO;
import lk.ijse.asms.dao.custom.QueryDAO;
import lk.ijse.asms.dao.custom.SubcPaymentDAO;
import lk.ijse.asms.dao.custom.impl.JobDAOImpl;
import lk.ijse.asms.dao.custom.impl.PaymentPlaneDAOImpl;
import lk.ijse.asms.dao.custom.impl.QueryDAOImpl;
import lk.ijse.asms.dao.custom.impl.SubcPaymentDAOImpl;
import lk.ijse.asms.dao.util.PaymentPlaneType;
import lk.ijse.asms.db.DBConnection;
import lk.ijse.asms.dto.CustomDTO;
import lk.ijse.asms.dto.JobDTO;
import lk.ijse.asms.dto.PaymentPlaneDTO;
import lk.ijse.asms.dto.SubPaymentDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class FinishJobBOImpl implements FinishJobBO {
    SubcPaymentDAO paymentDAO=new SubcPaymentDAOImpl();
    JobDAO jobDAO=new JobDAOImpl();
    QueryDAO queryDAO=new QueryDAOImpl();
    PaymentPlaneDAO paymentPlaneDAO=new PaymentPlaneDAOImpl();

    public ObservableList<String> getFinishJob(String jobStatus) throws SQLException, ClassNotFoundException {
        return queryDAO.getFinishJob(jobStatus);
    }

    public boolean finishJob(String jobId, SubPaymentDTO subPaymentDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        boolean finishJob=false;

        PaymentPlaneDTO power = paymentPlaneDAO.getPointDetails(PaymentPlaneType.POWER);
        PaymentPlaneDTO data = paymentPlaneDAO.getPointDetails(PaymentPlaneType.DATA);
        PaymentPlaneDTO camera = paymentPlaneDAO.getPointDetails(PaymentPlaneType.CAMERA);

        double total = subPaymentDTO.getPower_point() * power.getUnitPrice() + subPaymentDTO.getData_point()* data.getUnitPrice() + subPaymentDTO.getCamera_point()* camera.getUnitPrice();

        JobDTO jobDTO =new JobDTO(
                jobId,
                LocalDate.now(),
                "DONE",
                subPaymentDTO.getPower_point(),
                subPaymentDTO.getData_point(),
                subPaymentDTO.getCamera_point()
        );

        connection.setAutoCommit(false);
        boolean isFinishJob = jobDAO.finishJob(jobDTO);
        if(isFinishJob){
            finishJob=true;
            connection.commit();
            JobDTO jobDTO1 = jobDAO.getJobById(jobId);
                if (jobDTO1.getDoneBy().equals("SUB CONTRACT")) {
                    String payId = paymentDAO.getNextId();
                    CustomDTO customDTO = queryDAO.getDetailForSubcPayment(jobId);
                    SubPaymentDTO subPaymentDTO1 = new SubPaymentDTO(
                            payId,
                            customDTO.getEmployeeId(),
                            jobId,
                            customDTO.getDataPoint(),
                            customDTO.getPowerPoint(),
                            customDTO.getCameraPoint(),
                            total,
                            "REMINNING"
                    );
                    boolean isSaveSubPayment = paymentDAO.saveSubCPayment(subPaymentDTO1);
                    if (isSaveSubPayment) {
                        connection.commit();
                    } else {
                        connection.rollback();
                        finishJob=false;
                    }
                }
        }else {
            connection.rollback();
        }
        connection.setAutoCommit(true);
        return finishJob;
    }
}
