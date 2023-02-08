package lk.ijse.asms.dao.custom.impl;

import lk.ijse.asms.dao.util.PaymentPlaneType;
import lk.ijse.asms.dao.util.SQLUtil;
import lk.ijse.asms.dao.custom.PaymentPlaneDAO;
import lk.ijse.asms.entity.PaymentPlane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PaymentPlaneDAOImpl implements PaymentPlaneDAO {

    @Override
    public boolean updatePPPlane(PaymentPlane paymentPlane) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("Update PaymentPlane  set payment_plane_description =?,payment_plane_unite_price =? where payment_plane_name =?",
                paymentPlane.getPayment_plane_description(),
                paymentPlane.getPayment_plane_unite_price(),
                paymentPlane.getPayment_plane_name());
    }
    @Override
    public ArrayList<PaymentPlane> getAllPoint() throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("select * from PaymentPlane ");
        ArrayList<PaymentPlane> plane=new ArrayList<>();
        while (rst.next()){
            plane.add(new PaymentPlane(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4)));
        }
        return plane;
    }
    @Override
    public PaymentPlane getPointDetails(PaymentPlaneType type) throws SQLException, ClassNotFoundException {
        ResultSet rst=null;

        switch (type){
            case DATA:
                rst=SQLUtil.execute("select * from PaymentPlane where payment_plane_name ='DATA'");
                break;
            case POWER:
                rst=SQLUtil.execute("select * from PaymentPlane where payment_plane_name ='POWER'");
                break;
            case CAMERA:
                rst=SQLUtil.execute("select * from PaymentPlane where payment_plane_name ='CAMERA'");
                break;
        }
        if(rst.next()){
            return new PaymentPlane(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4));
        }
        return null;
    }


}
