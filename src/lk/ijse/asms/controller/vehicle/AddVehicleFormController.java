package lk.ijse.asms.controller.vehicle;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import lk.ijse.asms.bo.BOFactory;
import lk.ijse.asms.bo.custom.VehicleBO;
import lk.ijse.asms.bo.custom.impl.VehicleBOImpl;
import lk.ijse.asms.dao.custom.VehicleDAO;
import lk.ijse.asms.dao.custom.impl.VehicleDAOImpl;
import lk.ijse.asms.dto.VehicleDTO;
import lk.ijse.asms.util.Navigation;
import lk.ijse.asms.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class AddVehicleFormController {
    VehicleBO vehicleBO=(VehicleBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.VEHICLE);

    public AnchorPane vehicleManagePane;
    public JFXTextField txtRegNo;
    public JFXTextField txtColour;
    public JFXTextField txtBrand;
    public JFXRadioButton radioLorry;
    public ToggleGroup vehicleType;
    public JFXRadioButton radioVan;
    public JFXRadioButton radioDiesel;
    public ToggleGroup fuelType;
    public JFXRadioButton radioPetrol;

    public void backManagerFormOnAction(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.MANAGER_DASHBOARD,vehicleManagePane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void addVehicleOnAction(ActionEvent actionEvent) {
        try {
        String type=null;
        if(radioLorry.isSelected()){
            type="Lorry";
        }else if(radioVan.isSelected()){
            type="Van";
        }else {
            new Alert(Alert.AlertType.ERROR,"Please Select Vehicle Type !!!").show();
        }

        String fuelType=null;
        if(radioDiesel.isSelected()){
            fuelType="Diesel";
        }else if(radioPetrol.isSelected()){
            fuelType="Petrol";
        }else {
            new Alert(Alert.AlertType.ERROR,"please Select Fuel Type !!!").show();
        }
        if(txtRegNo.getText().equals(null)){
            new Alert(Alert.AlertType.ERROR,"please Enter Registration Number !!!").show();
        }else {

            VehicleDTO vehicleDTO = new VehicleDTO(txtRegNo.getText(), type, txtColour.getText(), fuelType, txtBrand.getText());


            boolean isAdd = vehicleBO.saveVehicle(vehicleDTO);
            if (isAdd) {
                new Alert(Alert.AlertType.CONFIRMATION, "Add Vehicle Success !!!").show();
            }
        }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        textFieldClear();
    }

    private void textFieldClear() {
        txtRegNo.clear();
        txtColour.clear();
        txtBrand.clear();
        radioPetrol.setSelected(false);
        radioDiesel.setSelected(false);
        radioVan.setSelected(false);
        radioLorry.setSelected(false);
    }

}
