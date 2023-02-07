package lk.ijse.asms.dao.custom.impl;

import lk.ijse.asms.dao.util.PaymentPlaneType;
import lk.ijse.asms.dao.SQLUtil;
import lk.ijse.asms.dao.custom.PaymentPlaneDAO;
import lk.ijse.asms.dto.PaymentPlaneDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PaymentPlaneDAOImpl implements PaymentPlaneDAO {

    @Override
    public boolean updatePPPlane(PaymentPlaneDTO paymentPlaneDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("Update pp_plane set description=?,unite_price=? where name=?",
                paymentPlaneDTO.getDescription(),
                paymentPlaneDTO.getUnitPrice(),
                paymentPlaneDTO.getName());
    }
    @Override
    public ArrayList<PaymentPlaneDTO> getAllPoint() throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("select * from pp_plane");
        ArrayList<PaymentPlaneDTO> plane=new ArrayList<>();
        while (rst.next()){
            plane.add(new PaymentPlaneDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4)));
        }
        return plane;
    }
    @Override
    public PaymentPlaneDTO getPointDetails(PaymentPlaneType type) throws SQLException, ClassNotFoundException {
        ResultSet rst=null;

        switch (type){
            case DATA:
                rst=SQLUtil.execute("select * from pp_plane where name='DATA'");
                break;
            case POWER:
                rst=SQLUtil.execute("select * from pp_plane where name='POWER'");
                break;
            case CAMERA:
                rst=SQLUtil.execute("select * from pp_plane where name='CAMERA'");
                break;
        }
        if(rst.next()){
            return new PaymentPlaneDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4));
        }
        return null;
    }


}
