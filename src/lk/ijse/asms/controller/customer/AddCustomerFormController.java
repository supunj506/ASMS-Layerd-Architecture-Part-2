package lk.ijse.asms.controller.customer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.asms.bo.BOFactory;
import lk.ijse.asms.bo.custom.CustomerBO;
import lk.ijse.asms.bo.custom.impl.CustomerBOImpl;
import lk.ijse.asms.dao.DAOFactory;
import lk.ijse.asms.dto.CustomerDTO;
import lk.ijse.asms.util.Navigation;
import lk.ijse.asms.util.Routes;
import lk.ijse.asms.util.ValidateUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class AddCustomerFormController {
    private final CustomerBO customerBO=(CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    public AnchorPane addCustomerPane;
    public JFXTextField txtCusName;
    public JFXTextField txtCusAddress;
    public JFXTextField txtCusEmail;
    public JFXTextField txtCusContact;
    public JFXTextField txtCusManagerName;
    public JFXTextField txtCusMangerContact;
    public JFXButton btnAddCustomer;
    LinkedHashMap<JFXTextField,Pattern> map=new LinkedHashMap<>();

    public void initialize(){

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

    public void clearAllText(){
        txtCusName.clear();
        txtCusAddress.clear();
        txtCusContact.clear();
        txtCusEmail.clear();
        txtCusManagerName.clear();
        txtCusMangerContact.clear();
        btnAddCustomer.setDisable(true);
    }

    public void addCustomerOnAction(ActionEvent actionEvent) {
        try {
            String id = customerBO.getNextCustomerId();
            CustomerDTO customerDTO=new CustomerDTO(
                    id,
                    txtCusName.getText(),
                    txtCusAddress.getText(),
                    txtCusEmail.getText(),
                    txtCusContact.getText(),
                    txtCusManagerName.getText(),
                    txtCusMangerContact.getText()

            );
            boolean save = customerBO.saveCustomer(customerDTO);
            if(save){
                new Alert(Alert.AlertType.CONFIRMATION,"Save  Customer Successfully !!!").show();
                clearAllText();
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void UpdateCustomerFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.UPDATE_CUSTOMER,addCustomerPane);
    }

    public void backManagerFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MANAGER_DASHBOARD,addCustomerPane);
    }

    public void keyReleasedOnAction(KeyEvent keyEvent) {
        ValidateUtil.validate(map,btnAddCustomer);

        if(keyEvent.getCode()==KeyCode.ENTER){
            Object response=ValidateUtil.validate(map,btnAddCustomer);
            if(response instanceof JFXTextField){
                JFXTextField txt=(JFXTextField)response;
                txt.requestFocus();
            }
        }

    }
}
