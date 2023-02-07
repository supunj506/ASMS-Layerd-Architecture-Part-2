package lk.ijse.asms.controller.job;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.asms.bo.BOFactory;
import lk.ijse.asms.bo.custom.FinishJobBO;
import lk.ijse.asms.bo.custom.impl.FinishJobBOImpl;
import lk.ijse.asms.dto.SubPaymentDTO;
import lk.ijse.asms.util.Navigation;
import lk.ijse.asms.util.Routes;
import lk.ijse.asms.util.ValidateUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class FinishJobFormController {
    FinishJobBO finishJobBOImpl =(FinishJobBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.FINISHJOB);

    public AnchorPane finishJobPane;
    public JFXComboBox<String> cmbJob;
    public JFXTextField txtPower;
    public JFXTextField txtData;
    public JFXTextField txtCamera;
    public JFXButton btnFinishJob;
    LinkedHashMap<JFXTextField, Pattern> map = new LinkedHashMap<>();

    public void initialize() {
        loadJob();
        Pattern power = Pattern.compile("^[0-9]{1,2}$");
        map.put(txtPower, power);
        map.put(txtData, power);
        map.put(txtCamera, power);
        btnFinishJob.setDisable(true);
    }

    private void loadJob() {
        try {
            ObservableList<String> jobList = finishJobBOImpl.getFinishJob("DOING");
            cmbJob.setItems(jobList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void cmbJobOnAction(ActionEvent actionEvent) {
        loadJob();
    }

    public void finishJobOnAction(ActionEvent actionEvent) throws SQLException {

        String[] id = String.valueOf(cmbJob.getValue()).split(" / ");
        String jobId = id[0];
           SubPaymentDTO subPaymentDTO=new SubPaymentDTO(
                   Integer.parseInt(txtData.getText()),
                   Integer.parseInt(txtPower.getText()),
                   Integer.parseInt(txtCamera.getText()));

        try {
            boolean isFinishJob= finishJobBOImpl.finishJob(jobId,subPaymentDTO);/* only need to be here */
            if (isFinishJob){
                clean();
                new Alert(Alert.AlertType.CONFIRMATION,"Finish The Job Successfully !!!").show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void clean() {
        cmbJob.setItems(null);
        loadJob();
        txtCamera.clear();
        txtPower.clear();
        txtData.clear();
        btnFinishJob.setDisable(true);

    }

    public void addJobFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADD_JOB, finishJobPane);
    }

    public void callJobFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CALL_JOB, finishJobPane);
    }

    public void backManagerFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MANAGER_DASHBOARD, finishJobPane);
    }

    public void keyReleasedOnAction(KeyEvent keyEvent) {

        ValidateUtil.validate(map, btnFinishJob);

        if (keyEvent.getCode() == KeyCode.ENTER) {
            Object response = ValidateUtil.validate(map, btnFinishJob);
            if (response instanceof JFXTextField) {
                JFXTextField txt = (JFXTextField) response;
                txt.requestFocus();
            }
        }

    }
}