package lk.ijse.asms.controller.employee;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.asms.bo.BOFactory;
import lk.ijse.asms.bo.custom.EmployeeBO;
import lk.ijse.asms.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.asms.dao.custom.EmployeeDAO;
import lk.ijse.asms.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.asms.dto.EmployeeDTO;
import lk.ijse.asms.util.Navigation;
import lk.ijse.asms.util.Routes;
import lk.ijse.asms.util.ValidateUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class AddEmployeeFormController {
    EmployeeBO employeeBO=(EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    public JFXTextField txtNic;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtEmail;
    public JFXRadioButton radioMale;
    public ToggleGroup genderType;
    public JFXRadioButton radioFemale;
    public ToggleGroup Division;
    public JFXRadioButton radioHelp;
    public JFXRadioButton radioDrive;
    public JFXRadioButton radioSuper;
    public JFXRadioButton radioManage;
    public JFXRadioButton radioTech;
    public JFXTextField txtContact;
    public JFXRadioButton radioFull;
    public ToggleGroup empType;
    public JFXRadioButton radioContract;
    public JFXDatePicker datePickDob;
    public AnchorPane addEmployeePane;
    public JFXButton btnAddEmployee;
    LinkedHashMap<JFXTextField,Pattern> map=new LinkedHashMap<>();
    public void initialize(){
        Pattern nic=Pattern.compile("^[1-9][0-9]{8}([0-9]{3})?(v|V)?$");
        Pattern name=Pattern.compile("^[A-z ]{3,30}$");
        Pattern address=Pattern.compile("^[A-z0-9/]{4,40}$");
        Pattern email=Pattern.compile("^[a-z0-9]{4,40}@(gmail|yahoo|ymail).com$");
        Pattern contact=Pattern.compile("^(\\+94|0)(70|71|72|75|76|77|78)[0-9]{7}$");

        map.put(txtNic,nic);
        map.put(txtName,name);
        map.put(txtAddress,address);
        map.put(txtEmail,email);
        map.put(txtContact,contact);
        btnAddEmployee.setDisable(true);

    }

boolean getAllData=true;
    public void addEmployeeOnAction(ActionEvent actionEvent) {
        try {
            String id= employeeBO.getNextEmployeeId();
            String gender=getGender();
            String type=getEmpType();
            String division=getDivision();
            if(getAllData) {
                EmployeeDTO employeeDTO = new EmployeeDTO(
                        id,
                        txtNic.getText(),
                        txtName.getText(),
                        gender,
                        datePickDob.getValue(),
                        txtAddress.getText(),
                        txtEmail.getText(),
                        txtContact.getText(),
                        type,
                        division,
                        LocalDate.now()
                );
                boolean save = employeeBO.saveEmployee(employeeDTO);
                if(save){
                    new Alert(Alert.AlertType.CONFIRMATION,"Add Employee Successfully !!!").show();
                    setClear();
                }
            }else {
                new Alert(Alert.AlertType.ERROR,"Missing Data Found !!!").show();
                getAllData=true;

            }



        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private String getEmpType() {
        String empType=null;
        if(radioFull.isSelected()){
            empType="FULL TIME";
        } else if (radioContract.isSelected()) {
            empType="CONTRACT BASE";
        }else {

            getAllData=false;
        }
        return empType;
    }

    private String getDivision() {
        String division=null;
        if(radioTech.isSelected()){
            division="D01";
        } else if (radioHelp.isSelected()) {
            division="D02";
        } else if (radioDrive.isSelected()) {
            division="D03";
        } else if (radioSuper.isSelected()) {
            division="D04";
        } else if (radioManage.isSelected()) {
            division="D05";
        }else {

            getAllData=false;
        }
        return division;
    }

    private String getGender() {
        String gender=null;
        if(radioMale.isSelected()){
            gender="MALE";
        }else if(radioFemale.isSelected()) {
            gender="FEMALE";
        }else{

            getAllData=false;
        }
        return gender;
    }

    private void setClear() {
        txtNic.clear();
        txtName.clear();
        radioMale.setSelected(false);
        radioFemale.setSelected(false);
        datePickDob.setValue(LocalDate.now());
        txtAddress.clear();
        txtEmail.clear();
        txtContact.clear();
        radioFull.setSelected(false);
        radioContract.setSelected(false);
        radioTech.setSelected(false);
        radioHelp.setSelected(false);
        radioDrive.setSelected(false);
        radioSuper.setSelected(false);
        radioManage.setSelected(false);
    }

    public void updateEmployeeFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.UPDATE_EMPLOYEE,addEmployeePane);
    }


    public void backManagerFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MANAGER_DASHBOARD,addEmployeePane);
    }

    public void fullOnAction(ActionEvent actionEvent) {
        setDivision(false);
    }

    private void setDivision(boolean is) {
        radioHelp.setDisable(is);
        radioDrive.setDisable(is);
        radioSuper.setDisable(is);
        radioManage.setDisable(is);
    }

    public void contractOnAction(ActionEvent actionEvent) {
        setDivision(true);
    }

    public void keyReleasedOnAction(KeyEvent keyEvent) {
        ValidateUtil.validate(map,btnAddEmployee);

        if(keyEvent.getCode()== KeyCode.ENTER){
            Object response=ValidateUtil.validate(map,btnAddEmployee);
            if(response instanceof JFXTextField){
                JFXTextField txt=(JFXTextField)response;
                txt.requestFocus();
            }
        }
    }
}
