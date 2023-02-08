package lk.ijse.asms.dao.custom;

import lk.ijse.asms.dao.CrudDAO;
import lk.ijse.asms.dao.SuperDAO;
import lk.ijse.asms.dao.util.PaymentPlaneType;
import lk.ijse.asms.dto.PaymentPlaneDTO;
import lk.ijse.asms.entity.PaymentPlane;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentPlaneDAO extends CrudDAO<PaymentPlane,String>{
    boolean updatePPPlane (PaymentPlane paymentPlane) throws SQLException, ClassNotFoundException;
    ArrayList<PaymentPlane> getAllPoint() throws SQLException, ClassNotFoundException;
    PaymentPlane getPointDetails(PaymentPlaneType type) throws SQLException, ClassNotFoundException;
}
