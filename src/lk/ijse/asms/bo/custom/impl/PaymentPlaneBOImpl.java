package lk.ijse.asms.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.asms.bo.custom.PaymentPlaneBO;
import lk.ijse.asms.dao.DAOFactory;
import lk.ijse.asms.dao.custom.PaymentPlaneDAO;
import lk.ijse.asms.dao.custom.impl.PaymentPlaneDAOImpl;
import lk.ijse.asms.dao.util.PaymentPlaneType;
import lk.ijse.asms.dto.PaymentPlaneDTO;
import lk.ijse.asms.view.tm.PaymentPlaneTM;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentPlaneBOImpl implements PaymentPlaneBO {
    private final PaymentPlaneDAO paymentPlaneDAO=(PaymentPlaneDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENTPLANE);

    public ObservableList<PaymentPlaneTM> getAllPointDetails() throws SQLException, ClassNotFoundException {
        ArrayList<PaymentPlaneDTO> allPoint = paymentPlaneDAO.getAllPoint();
        ObservableList<PaymentPlaneTM> pointDetailList= FXCollections.observableArrayList();
        for(PaymentPlaneDTO temp:allPoint){
            pointDetailList.add(new PaymentPlaneTM(
                    temp.getName(),
                    temp.getDescription(),
                    temp.getUnitPrice()));
        }
        return pointDetailList;
    }

    public ObservableList<String> getAllPointName() throws SQLException, ClassNotFoundException {
        ArrayList<PaymentPlaneDTO> allPoint = paymentPlaneDAO.getAllPoint();
        ObservableList<String>allName=FXCollections.observableArrayList();
        for(PaymentPlaneDTO paymentPlaneDTO:allPoint){
            allName.add(paymentPlaneDTO.getName());

        }
        return allName;
    }

    public boolean updatePointPaymentPlane(PaymentPlaneDTO paymentPlaneDTO) throws SQLException, ClassNotFoundException {
        return paymentPlaneDAO.updatePPPlane(paymentPlaneDTO);
    }

    public PaymentPlaneDTO getPointDetailsByType(PaymentPlaneType setCmbPointType) throws SQLException, ClassNotFoundException {
        return paymentPlaneDAO.getPointDetails(setCmbPointType);
    }
}
