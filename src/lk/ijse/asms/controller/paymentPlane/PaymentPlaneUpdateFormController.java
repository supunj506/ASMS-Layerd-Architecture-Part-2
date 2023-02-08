package lk.ijse.asms.controller.paymentPlane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.asms.bo.BOFactory;
import lk.ijse.asms.bo.custom.PaymentPlaneBO;
import lk.ijse.asms.bo.custom.impl.PaymentPlaneBOImpl;
import lk.ijse.asms.dao.custom.PaymentPlaneDAO;
import lk.ijse.asms.dao.custom.impl.PaymentPlaneDAOImpl;
import lk.ijse.asms.dao.util.PaymentPlaneType;
import lk.ijse.asms.dto.PaymentPlaneDTO;
import lk.ijse.asms.util.Navigation;
import lk.ijse.asms.util.Routes;
import lk.ijse.asms.util.ValidateUtil;
import lk.ijse.asms.view.tm.PaymentPlaneTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class PaymentPlaneUpdateFormController {
    private final PaymentPlaneBO paymentPlaneBO=(PaymentPlaneBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PAYMENTPLANE);

    public AnchorPane paymentPlaneUpdatePane;
    public JFXTextField txtDescription;
    public JFXTextField txtUnitPrice;
    public JFXComboBox<String> cmbPointType;
    public JFXButton btnUpdate;
    public TableView <PaymentPlaneTM> tableView;
    public TableColumn tmType;
    public TableColumn tmDescription;
    public TableColumn tmPrice;
    LinkedHashMap<JFXTextField,Pattern> map=new LinkedHashMap<>();

    public void initialize(){
        loadPoint();
        Pattern description=Pattern.compile("^[A-z 0-9/]{4,40}$");
        Pattern unitePrice=Pattern.compile("^[1-9][0-9]{3}[.][0-9]$");
        map.put(txtDescription,description);
        map.put(txtUnitPrice,unitePrice);
        btnUpdate.setDisable(true);
        tableView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("type"));
        tableView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tableView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("price"));

    }

    private void loadPoint() {
        try {
            cmbPointType.setItems(paymentPlaneBO.getAllPointName());
            tableView.setItems(paymentPlaneBO.getAllPointDetails());
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.CONFIRMATION,""+e).show();

            e.printStackTrace();
        }
    }

    public void updatePPPlaneOnAction(ActionEvent actionEvent) {
        try {
            boolean isUpdate= paymentPlaneBO.updatePointPaymentPlane(new PaymentPlaneDTO(String.valueOf(cmbPointType.getValue()),txtDescription.getText(), Double.parseDouble(txtUnitPrice.getText())));
            if(isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION,"Update Plane Successfully !!!").show();
                clean();

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void clean() {
        cmbPointType.setItems(null);
        loadPoint();
        txtUnitPrice.clear();
        txtDescription.clear();
    }

    public void keyReleasedOnAction(KeyEvent keyEvent) {
        ValidateUtil.validate(map,btnUpdate);

        if(keyEvent.getCode()== KeyCode.ENTER){
            Object response=ValidateUtil.validate(map,btnUpdate);
            if(response instanceof JFXTextField){
                JFXTextField txt=(JFXTextField)response;
                txt.requestFocus();
            }
        }
    }

    public void cmbOnAction(ActionEvent actionEvent) {
       setDescription();

    }

    private void setDescription() {

        try {
            PaymentPlaneDTO pointDetails = paymentPlaneBO.getPointDetailsByType(setCmbPointType());
            txtDescription.setText(pointDetails.getDescription());
            txtUnitPrice.setText(String.valueOf(pointDetails.getUnitPrice()));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private PaymentPlaneType setCmbPointType(){
        PaymentPlaneType pointType=null;
        if(cmbPointType.getValue().equals("DATA")){
            pointType=PaymentPlaneType.DATA;
        }else if(cmbPointType.getValue().equals("POWER")){
            pointType=PaymentPlaneType.POWER;
        }else {
            pointType=PaymentPlaneType.CAMERA;
        }
        return pointType;
    }

    public void backManagerFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MANAGER_DASHBOARD,paymentPlaneUpdatePane);
    }
}
