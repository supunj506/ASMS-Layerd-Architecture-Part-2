package lk.ijse.asms.controller.employee;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.asms.bo.custom.EmployeeBO;
import lk.ijse.asms.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.asms.dto.EmployeeDTO;
import lk.ijse.asms.util.Navigation;
import lk.ijse.asms.util.Routes;
import lk.ijse.asms.util.ValidateUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class UpdateEmployeeFormController {
    EmployeeBO employeeBO=new EmployeeBOImpl();

    public AnchorPane updateEmployeePane;
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtEmail;
    public JFXRadioButton radioMale;
    public ToggleGroup genderType;
    public JFXRadioButton radioFemale;
    public JFXTextField txtContact;
    public JFXRadioButton radioTech;
    public ToggleGroup Division;
    public JFXRadioButton radioHelp;
    public JFXRadioButton radioDrive;
    public JFXRadioButton radioSuper;
    public JFXRadioButton radioManage;
    public JFXRadioButton radioFull;
    public ToggleGroup empType;
    public JFXRadioButton radioContract;
    public JFXDatePicker datePickDob;
    public JFXComboBox<String> cmbNic;
    public JFXTextField txtJoiningDate;
    public JFXButton btnUpdateEmployee;
    LinkedHashMap<JFXTextField, Pattern> map=new LinkedHashMap<>();

    public void initialize(){
        loadAllNic();

        Pattern address=Pattern.compile("^[A-z0-9/]{4,40}$");
        Pattern email=Pattern.compile("^[a-z0-9]{4,40}@(gmail|yahoo|ymail).com$");
        Pattern contact=Pattern.compile("^(\\+94|0)(70|71|72|75|76|77|78)[0-9]{7}$");

        map.put(txtAddress,address);
        map.put(txtEmail,email);
        map.put(txtContact,contact);

    }

    private void loadAllNic() {
        try {
            cmbNic.setItems(employeeBO.getAllEmployee());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addEmployeeFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADD_EMPLOYEE,updateEmployeePane);
    }

    public void backManagerFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MANAGER_DASHBOARD,updateEmployeePane);
    }

boolean getAllData=true;
    public void updateEmployeeOnAction(ActionEvent actionEvent) {
        String empType=getEmpType();
        String division=getDivision();

        try {
        if(getAllData){
        EmployeeDTO employeeDTO =new EmployeeDTO(
                txtId.getText(),
                String.valueOf(cmbNic.getValue()),
                txtName.getText(),
                getGender(),
                datePickDob.getValue(),
                txtAddress.getText(),
                txtEmail.getText(),
                txtContact.getText(),
                empType,
                division,
                LocalDate.parse(txtJoiningDate.getText())
        );

            boolean update = employeeBO.updateEmployee(employeeDTO);
            if (update) {
                new Alert(Alert.AlertType.CONFIRMATION, "Update Employee Successfully !!!").show();
                clean();
            }
        }else{
            new Alert(Alert.AlertType.ERROR, "Missing Data Found !!!").show();
            getAllData=true;
        }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.CONFIRMATION,""+e).show();
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
        if(radioMale.isSelected()){
            return "MALE";
        }
        return "FEMALE";
    }

    public void cmbNicOnAction(ActionEvent actionEvent) {
        try {
            EmployeeDTO employeeDTO = employeeBO.getEmployeeByNic(String.valueOf(cmbNic.getValue()));
            setData(employeeDTO);
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.CONFIRMATION,""+e).show();
            throw new RuntimeException(e);
        }

    }

    private void setData(EmployeeDTO employeeDTO) {
        txtId.setText(employeeDTO.getId());
        txtId.setDisable(true);
        txtName.setText(employeeDTO.getName());
        txtName.setDisable(true);
        if(employeeDTO.getGender().equals("MALE")){
            radioMale.setSelected(true);
            radioMale.setDisable(true);
        }else {
            radioFemale.setSelected(true);
            radioFemale.setSelected(true);
        }
        datePickDob.setValue(employeeDTO.getDob());
        datePickDob.setDisable(true);
        txtAddress.setText(employeeDTO.getAddress());
        txtEmail.setText(employeeDTO.getEmail());
        txtContact.setText(employeeDTO.getContact());
        if(employeeDTO.getEmpType().equals("FULL TIME")){
            radioFull.setSelected(true);
            setDivision(false);
        }else{
            radioContract.setSelected(true);
            setDivision(true);
            radioContract.setSelected(true);
        }
        if(employeeDTO.getDivision().equals("D01")){
            radioTech.setSelected(true);
        }else if(employeeDTO.getDivision().equals("D02")){
            radioHelp.setSelected(true);
        }else if(employeeDTO.getDivision().equals("D03")){
            radioDrive.setSelected(true);
        }else if(employeeDTO.getDivision().equals("D04")){
            radioSuper.setSelected(true);
        }else {
            radioManage.setSelected(true);
        }
        txtJoiningDate.setText(String.valueOf(employeeDTO.getJoinDate()));
        txtJoiningDate.setDisable(true);
    }

    public void fullOnAction(ActionEvent actionEvent) {
        setDivision(false);
    }

    public void contractBaseOnAction(ActionEvent actionEvent) {
        setDivision(true);
    }

    private void clean() {
        txtId.clear();
        txtName.clear();
        radioMale.setSelected(false);
        radioFemale.setSelected(false);
        radioFull.setSelected(false);
        radioContract.setSelected(false);
        radioTech.setSelected(false);
        radioHelp.setSelected(false);
        radioDrive.setSelected(false);
        radioSuper.setSelected(false);
        radioManage.setSelected(false);
        datePickDob.setValue(LocalDate.now());
        txtAddress.clear();
        txtEmail.clear();
        txtContact.clear();
    }

    public void setDivision(boolean is){
        radioHelp.setDisable(is);
        radioDrive.setDisable(is);
        radioSuper.setDisable(is);
        radioManage.setDisable(is);

    }

    public void keyReleasedOnAction(KeyEvent keyEvent) {
        ValidateUtil.validate(map,btnUpdateEmployee);

        if(keyEvent.getCode()== KeyCode.ENTER){
            Object response=ValidateUtil.validate(map,btnUpdateEmployee);
            if(response instanceof JFXTextField){
                JFXTextField txt=(JFXTextField)response;
                txt.requestFocus();
            }
        }
    }
}
