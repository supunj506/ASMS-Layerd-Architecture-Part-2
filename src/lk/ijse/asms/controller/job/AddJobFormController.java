package lk.ijse.asms.controller.job;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.asms.bo.util.BOFactory;
import lk.ijse.asms.bo.custom.AddJobBO;
import lk.ijse.asms.dto.CustomerDTO;
import lk.ijse.asms.dto.JobDTO;
import lk.ijse.asms.util.Navigation;
import lk.ijse.asms.util.Routes;
import lk.ijse.asms.util.ValidateUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class AddJobFormController {

    public AnchorPane addJobPane;
    public JFXRadioButton radioNew;
    public ToggleGroup jobType;
    public JFXRadioButton radioRe;
    public JFXDatePicker datePickDudeDate;
    public JFXComboBox <String>cmbCustomerName;
    public JFXTextField txtTableCount;
    public JFXTextField txtLocation;
    public JFXButton btnAddJob;
    LinkedHashMap<JFXTextField, Pattern> map=new LinkedHashMap<>();

    private AddJobBO addJobBO;

    public void initialize(){
        addJobBO=BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ADDJOB);
        loadCustomerName();
        Pattern tableCount=Pattern.compile("^[0-9]{1,2}$");
        Pattern location=Pattern.compile("^[A-z]{4,15}$");

        map.put(txtTableCount,tableCount);
        map.put(txtLocation,location);
        btnAddJob.setDisable(true);

    }

boolean allDataSet=false;
    public void addJobOnAction(ActionEvent actionEvent) {

        String jobType=null;
        if(radioNew.isSelected()){
            jobType="NEW WIRING";
            allDataSet=true;
        }else if (radioRe.isSelected()){
            jobType="RE WIRING";
            allDataSet=true;
        }

        allDataSet= cmbCustomerName.getValue() != null || datePickDudeDate.getValue() != null;
        btnAddJob.setDisable(allDataSet);
        try {
            String id= addJobBO.getNextJobId();
            CustomerDTO customerByName = addJobBO.getCustomerByName(String.valueOf(cmbCustomerName.getValue()));
            String customerId=customerByName.getId();
            JobDTO jobDTO =new JobDTO(id, jobType, customerId, datePickDudeDate.getValue(), Integer.parseInt(txtTableCount.getText()), txtLocation.getText(), "TO DO");
            boolean isAdd= addJobBO.addJob(jobDTO);
            if(isAdd){
                new Alert(Alert.AlertType.CONFIRMATION,"Add Successfully !!!").show();
                clean();
            }
        } catch (SQLException | ClassNotFoundException e) {
           new Alert(Alert.AlertType.ERROR,String.valueOf(e)).show();
        }

    }

    private void loadCustomerName(){
        try {
            ArrayList<CustomerDTO> allCustomerDTO = addJobBO.getAllCustomer();
            ObservableList<String>customerNames= FXCollections.observableArrayList();

            if(!allCustomerDTO.isEmpty()){
                for(CustomerDTO customerDTO : allCustomerDTO){
                    customerNames.add(customerDTO.getName());
                }
                cmbCustomerName.setItems(customerNames);
            }else {
                new Alert(Alert.AlertType.WARNING, "There Are No Any Customer In The System !!!").show();
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void keyReleasedOnAction(KeyEvent keyEvent) {
        ValidateUtil.validate(map,btnAddJob);

        if(keyEvent.getCode()== KeyCode.ENTER){
            Object response=ValidateUtil.validate(map,btnAddJob);
            if(response instanceof JFXTextField){
                JFXTextField txt=(JFXTextField)response;
                txt.requestFocus();
            }
        }
    }

    public void callJobOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CALL_JOB,addJobPane);
    }

    public void finishJobOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.FINISH_JOB,addJobPane);
    }

    public void backManagerFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MANAGER_DASHBOARD,addJobPane);
    }

    private void clean() {
        radioNew.setSelected(false);
        radioRe.setSelected(false);
        cmbCustomerName.setItems(null);
        loadCustomerName();
        datePickDudeDate.setValue(null);
        txtTableCount.clear();
        txtLocation.clear();

    }
}
