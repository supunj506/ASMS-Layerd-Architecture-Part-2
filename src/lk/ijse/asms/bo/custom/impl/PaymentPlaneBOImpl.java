package lk.ijse.asms.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.asms.bo.custom.PaymentPlaneBO;
import lk.ijse.asms.dao.util.DAOFactory;
import lk.ijse.asms.dao.custom.PaymentPlaneDAO;
import lk.ijse.asms.dao.util.PaymentPlaneType;
import lk.ijse.asms.dto.PaymentPlaneDTO;
import lk.ijse.asms.entity.PaymentPlane;
import lk.ijse.asms.view.tm.PaymentPlaneTM;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentPlaneBOImpl implements PaymentPlaneBO {
    private final PaymentPlaneDAO paymentPlaneDAO;

    public PaymentPlaneBOImpl() {
        paymentPlaneDAO=DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENTPLANE);
    }

    public ObservableList<PaymentPlaneTM> getAllPointDetails() throws SQLException, ClassNotFoundException {
        ArrayList<PaymentPlane> allPoint = paymentPlaneDAO.getAllPoint();
        ObservableList<PaymentPlaneTM> pointDetailList= FXCollections.observableArrayList();
        for(PaymentPlane temp:allPoint){
            pointDetailList.add(new PaymentPlaneTM(
                    temp.getPayment_plane_name(),
                    temp.getPayment_plane_description(),
                    temp.getPayment_plane_unite_price()));
        }
        return pointDetailList;
    }

    public ObservableList<String> getAllPointName() throws SQLException, ClassNotFoundException {
        ArrayList<PaymentPlane> allPoint = paymentPlaneDAO.getAllPoint();
        ObservableList<String>allName=FXCollections.observableArrayList();
        for(PaymentPlane paymentPlaneDTO:allPoint){
            allName.add(paymentPlaneDTO.getPayment_plane_name());
        }
        return allName;
    }

    public boolean updatePointPaymentPlane(PaymentPlaneDTO paymentPlaneDTO) throws SQLException, ClassNotFoundException {
        return paymentPlaneDAO.updatePPPlane(new PaymentPlane(paymentPlaneDTO.getId(),paymentPlaneDTO.getName(),paymentPlaneDTO.getDescription(),paymentPlaneDTO.getUnitPrice()));
    }

    public PaymentPlaneDTO getPointDetailsByType(PaymentPlaneType PointType) throws SQLException, ClassNotFoundException {
        PaymentPlane pointDetails = paymentPlaneDAO.getPointDetails(PointType);
       return new PaymentPlaneDTO(pointDetails.getPayment_plane_id(),pointDetails.getPayment_plane_name(),pointDetails.getPayment_plane_description(),pointDetails.getPayment_plane_unite_price());
    }
}
