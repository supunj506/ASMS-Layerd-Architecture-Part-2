package lk.ijse.asms.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.asms.bo.custom.FinishJobBO;
import lk.ijse.asms.dao.util.DAOFactory;
import lk.ijse.asms.dao.custom.JobDAO;
import lk.ijse.asms.dao.custom.PaymentPlaneDAO;
import lk.ijse.asms.dao.custom.QueryDAO;
import lk.ijse.asms.dao.custom.SubPaymentDAO;
import lk.ijse.asms.dao.util.PaymentPlaneType;
import lk.ijse.asms.db.DBConnection;
import lk.ijse.asms.dto.CustomDTO;
import lk.ijse.asms.dto.SubPaymentDTO;
import lk.ijse.asms.entity.CustomEntity;
import lk.ijse.asms.entity.Job;
import lk.ijse.asms.entity.PaymentPlane;
import lk.ijse.asms.entity.SubPayment;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class FinishJobBOImpl implements FinishJobBO {
    private final SubPaymentDAO paymentDAO;
    private final JobDAO jobDAO;
    private final QueryDAO queryDAO;
    private final PaymentPlaneDAO paymentPlaneDAO;

    public FinishJobBOImpl() {
        paymentDAO=DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUBCPAYMENT);
        jobDAO=DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.JOB);
        queryDAO=DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);
        paymentPlaneDAO=DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENTPLANE);
    }

    public ObservableList<String> getFinishJob(String jobStatus) throws SQLException, ClassNotFoundException {
        return queryDAO.getFinishJob(jobStatus);
    }

    public boolean finishJob(String jobId, SubPaymentDTO subPaymentDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        boolean finishJob=false;

        PaymentPlane power = paymentPlaneDAO.getPointDetails(PaymentPlaneType.POWER);
        PaymentPlane data = paymentPlaneDAO.getPointDetails(PaymentPlaneType.DATA);
        PaymentPlane camera = paymentPlaneDAO.getPointDetails(PaymentPlaneType.CAMERA);

        double total = subPaymentDTO.getPower_point() * power.getPayment_plane_unite_price() + subPaymentDTO.getData_point()* data.getPayment_plane_unite_price() + subPaymentDTO.getCamera_point()* camera.getPayment_plane_unite_price();

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
                if (jobEntity1.getJob_done_by().equals("SUB CONTRACT")) {
                    String payId = paymentDAO.getNextId();
                    CustomEntity detailForSubPayment = queryDAO.getDetailForSubPayment(jobId);
                    SubPayment subPaymentEntity1 = new SubPayment(
                            payId,
                            detailForSubPayment.getEmployee_id(),
                            jobId,
                            detailForSubPayment.getJob_data_point_count(),
                            detailForSubPayment.getJob_power_point_count(),
                            detailForSubPayment.getJob_camera_point_count(),
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
