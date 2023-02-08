package lk.ijse.asms.bo.custom.impl;

import com.sun.org.apache.bcel.internal.generic.FADD;
import javafx.collections.ObservableList;
import jdk.nashorn.internal.scripts.JO;
import lk.ijse.asms.bo.custom.FinishJobBO;
import lk.ijse.asms.dao.DAOFactory;
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
import lk.ijse.asms.entity.Job;
import lk.ijse.asms.entity.PaymentPlane;
import lk.ijse.asms.entity.SubPayment;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class FinishJobBOImpl implements FinishJobBO {
    private final SubcPaymentDAO paymentDAO=(SubcPaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUBCPAYMENT);
    private final JobDAO jobDAO=(JobDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.JOB);
    private final QueryDAO queryDAO=(QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);
    private final PaymentPlaneDAO paymentPlaneDAO=(PaymentPlaneDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENTPLANE);

    public ObservableList<String> getFinishJob(String jobStatus) throws SQLException, ClassNotFoundException {
        return queryDAO.getFinishJob(jobStatus);
    }

    public boolean finishJob(String jobId, SubPaymentDTO subPaymentDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        boolean finishJob=false;

        PaymentPlane power = paymentPlaneDAO.getPointDetails(PaymentPlaneType.POWER);
        PaymentPlane data = paymentPlaneDAO.getPointDetails(PaymentPlaneType.DATA);
        PaymentPlane camera = paymentPlaneDAO.getPointDetails(PaymentPlaneType.CAMERA);

        double total = subPaymentDTO.getPower_point() * power.getUnitPrice() + subPaymentDTO.getData_point()* data.getUnitPrice() + subPaymentDTO.getCamera_point()* camera.getUnitPrice();

        Job jobEntity =new Job(
                jobId,
                LocalDate.now(),
                "DONE",
                subPaymentDTO.getPower_point(),
                subPaymentDTO.getData_point(),
                subPaymentDTO.getCamera_point()
        );

        connection.setAutoCommit(false);
        boolean isFinishJob = jobDAO.finishJob(jobEntity);
        if(isFinishJob){
            finishJob=true;
            connection.commit();
            Job jobEntity1 = jobDAO.getJobById(jobId);
                if (jobEntity1.getDoneBy().equals("SUB CONTRACT")) {
                    String payId = paymentDAO.getNextId();
                    CustomDTO customDTO = queryDAO.getDetailForSubcPayment(jobId);
                    SubPayment subPaymentEntity1 = new SubPayment(
                            payId,
                            customDTO.getEmployeeId(),
                            jobId,
                            customDTO.getDataPoint(),
                            customDTO.getPowerPoint(),
                            customDTO.getCameraPoint(),
                            total,
                            "REMINNING"
                    );
                    boolean isSaveSubPayment = paymentDAO.saveSubCPayment(subPaymentEntity1);
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
