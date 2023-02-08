package lk.ijse.asms.dao.custom;

import lk.ijse.asms.dao.util.CrudDAO;
import lk.ijse.asms.entity.SubPayment;

import java.sql.SQLException;

public interface SubPaymentDAO extends CrudDAO<SubPayment,String> {
    boolean saveSubCPayment(SubPayment subPaymentEntity) throws SQLException, ClassNotFoundException;
    String getNextId () throws SQLException, ClassNotFoundException;
    SubPayment getSubPaymentById(String s) throws SQLException, ClassNotFoundException;
}
