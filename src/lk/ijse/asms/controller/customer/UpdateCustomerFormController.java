package lk.ijse.asms.controller.customer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.asms.bo.util.BOFactory;
import lk.ijse.asms.bo.custom.CustomerBO;
import lk.ijse.asms.dto.CustomerDTO;
import lk.ijse.asms.util.Navigation;
import lk.ijse.asms.util.Routes;
import lk.ijse.asms.util.ValidateUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class UpdateCustomerFormController {
    private final CustomerBO customerBO=(CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    public AnchorPane updateCustomerPane;
    public JFXTextField txtCusName;
    public JFXTextField txtCusAddress;
    public JFXTextField txtCusEmail;
    public JFXTextField txtCusContact;
    public JFXTextField txtCusManagerName;
    public JFXTextField txtCusMangerContact;
    public JFXComboBox <String>cmbCusId;
    public JFXButton btnUpdateCustomer;
    LinkedHashMap<JFXTextField,Pattern> map=new LinkedHashMap<>();
    String cusId=null;

    public void initialize(){
        loadAllCustomer();
        btnUpdateCustomer.setDisable(true);
        Pattern cusName=Pattern.compile("^[A-z ]{3,30}$");
        Pattern cusAddress=Pattern.compile("^[A-z0-9/]{4,40}$");
        Pattern cusEmail=Pattern.compile("^[a-z0-9]{4,40}@(gmail|yahoo|ymail).com$");
        Pattern cusContact=Pattern.compile("^(\\+94|0)(70|71|72|75|76|77|78|51|52|66|81|54|63|67|65|26|25|27|32|37|21|23|24|35|45|91|47|41|55|57|36|11|33|31|34|38)[0-9]{7}$");
        Pattern cusManagerName=Pattern.compile("^[A-z ]{3,30}$");
        Pattern cusManagerContact=Pattern.compile("^(\\+94|0)(70|71|72|75|76|77|78)[0-9]{7}$");

        map.put(txtCusName,cusName);
        map.put(txtCusAddress,cusAddress);
        map.put(txtCusEmail,cusEmail);
        map.put(txtCusContact,cusContact);
        map.put(txtCusManagerName,cusManagerName);
        map.put(txtCusMangerContact,cusManagerContact);
    }

    private void loadAllCustomer() {
        try {

            ObservableList<String>obList= FXCollections.observableArrayList();
            for(CustomerDTO customerDTO : customerBO.getAllCustomer()){
                obList.add(customerDTO.getId()+" / "+ customerDTO.getName());
            }
            cmbCusId.setItems(obList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void UpdateCustomerOnAction(ActionEvent actionEvent) {
        CustomerDTO customer =new CustomerDTO(
                cusId,
        txtCusName.getText(),
        txtCusAddress.getText(),
        txtCusEmail.getText(),
        txtCusContact.getText(),
        txtCusManagerName.getText(),
        txtCusMangerContact.getText()
        );
        try {
            boolean isUpdate = customerBO.update(customer);
            if(isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION,"Update Customer Successfully !!!").show();
                clean();

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void cmbCusIdOnAction(ActionEvent actionEvent) {
        String[]id=String.valueOf(cmbCusId.getValue()).split(" / ");
        cusId=id[0];
        try {
            CustomerDTO customerDTO = customerBO.getCustomerById(cusId);
            assert customerDTO != null;
            txtCusName.setText(customerDTO.getName());
            txtCusAddress.setText(customerDTO.getAddress());
            txtCusEmail.setText(customerDTO.getEmail());
            txtCusContact.setText(customerDTO.getContact());
            txtCusManagerName.setText(customerDTO.getItManagerName());
            txtCusMangerContact.setText(customerDTO.getItManagerContact());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void clean() {

        txtCusName.clear();
        txtCusAddress.clear();
        txtCusEmail.clear();
        txtCusContact.clear();
        txtCusManagerName.clear();
        txtCusMangerContact.clear();
        btnUpdateCustomer.setDisable(true);

    }

    public void keyReleasedOnAction(KeyEvent keyEvent) {
        ValidateUtil.validate(map,btnUpdateCustomer);

        if(keyEvent.getCode()== KeyCode.ENTER){
            Object response=ValidateUtil.validate(map,btnUpdateCustomer);
            if(response instanceof JFXTextField){
                JFXTextField txt=(JFXTextField)response;
                txt.requestFocus();
            }
        }
    }

    public void addCustomerFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADD_CUSTOMER,updateCustomerPane);
    }

    public void backManagerFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MANAGER_DASHBOARD,updateCustomerPane);
    }
}
