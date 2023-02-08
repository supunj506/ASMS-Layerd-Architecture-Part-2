package lk.ijse.asms.dao.custom;

import lk.ijse.asms.dao.CrudDAO;
import lk.ijse.asms.dao.SuperDAO;
import lk.ijse.asms.dto.SubPaymentDTO;
import lk.ijse.asms.entity.SubPayment;

import java.sql.SQLException;

public interface SubcPaymentDAO extends CrudDAO<SubPayment,String> {
    boolean saveSubCPayment(SubPayment subPaymentEntity) throws SQLException, ClassNotFoundException;
    String getNextId () throws SQLException, ClassNotFoundException;
    SubPayment getSubPaymentById(String s) throws SQLException, ClassNotFoundException;
}
