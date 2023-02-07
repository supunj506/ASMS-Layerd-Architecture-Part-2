package lk.ijse.asms.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.asms.bo.SuperBO;
import lk.ijse.asms.dao.util.PaymentPlaneType;
import lk.ijse.asms.dto.PaymentPlaneDTO;
import lk.ijse.asms.view.tm.PaymentPlaneTM;
import java.sql.SQLException;


public interface PaymentPlaneBO extends SuperBO {

    ObservableList<PaymentPlaneTM> getAllPointDetails() throws SQLException, ClassNotFoundException ;

    ObservableList<String> getAllPointName() throws SQLException, ClassNotFoundException ;

    boolean updatePointPaymentPlane(PaymentPlaneDTO paymentPlaneDTO) throws SQLException, ClassNotFoundException ;

    PaymentPlaneDTO getPointDetailsByType(PaymentPlaneType setCmbPointType) throws SQLException, ClassNotFoundException ;
}
