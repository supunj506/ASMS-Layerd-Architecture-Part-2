package lk.ijse.asms.dao.custom;

import lk.ijse.asms.dao.CrudDAO;
import lk.ijse.asms.dao.SuperDAO;
import lk.ijse.asms.dao.util.PaymentPlaneType;
import lk.ijse.asms.dto.PaymentPlaneDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentPlaneDAO extends CrudDAO<PaymentPlaneDTO>{
    boolean updatePPPlane (PaymentPlaneDTO paymentPlaneDTO) throws SQLException, ClassNotFoundException;
    ArrayList<PaymentPlaneDTO> getAllPoint() throws SQLException, ClassNotFoundException;
    PaymentPlaneDTO getPointDetails(PaymentPlaneType type) throws SQLException, ClassNotFoundException;
}
