package lk.ijse.asms.controller.report;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.asms.bo.BOFactory;
import lk.ijse.asms.bo.custom.PaymentReportBO;
import lk.ijse.asms.bo.custom.impl.PaymentReportBOImpl;
import lk.ijse.asms.dao.custom.*;
import lk.ijse.asms.dao.custom.impl.*;
import lk.ijse.asms.dao.util.PaymentPlaneType;
import lk.ijse.asms.dto.EmployeeDTO;
import lk.ijse.asms.dto.JobDTO;
import lk.ijse.asms.util.Navigation;
import lk.ijse.asms.util.Routes;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class PaymentReportFormController {
    private final PaymentReportBO paymentReportBO=(PaymentReportBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PAYMENTREPORT);

    public AnchorPane contractPaymentPane;
    public JFXComboBox <String>cmbJob;
    public JFXButton btnGetPaySlip;

    public  void initialize(){
        btnGetPaySlip.setDisable(true);
        loadAllJob();
    }

    private void loadAllJob() {
        try {
            cmbJob.setItems(paymentReportBO.getAllContractBaseFinishJob());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void contractPaymentOnAction(ActionEvent actionEvent) {
        String[]temp=String.valueOf(cmbJob.getValue()).split(" / ");
        String employeeId=temp[2];
        String jobId=temp[1];
        String subcPayId=temp[0];
        try {
            EmployeeDTO employeeDTO = paymentReportBO.getEmployeeByNic(employeeId);
            HashMap paramMap=new HashMap();
            paramMap.put("Eid", employeeDTO.getId());
            paramMap.put("Enic", employeeDTO.getNic());
            paramMap.put("Ename", employeeDTO.getName());
            paramMap.put("Eaddress", employeeDTO.getAddress());
            JobDTO abc = paymentReportBO.getJobById(jobId);

            Date startDate = java.sql.Date.valueOf(abc.getStartDate());
            Date endDate = java.sql.Date.valueOf(abc.getEndDate());

            paramMap.put("Jid",temp[1]);
            paramMap.put("Jstart",startDate );
            paramMap.put("Jend",endDate );

            int dataCount = (paymentReportBO.getSubPaymentById(subcPayId)).getData_point();
            int powerCount = (paymentReportBO.getSubPaymentById(subcPayId)).getData_point();
            int cameraCount = (paymentReportBO.getSubPaymentById(subcPayId)).getData_point();
            paramMap.put("dataC",dataCount);
            paramMap.put("powerC",powerCount);
            paramMap.put("cameraC",cameraCount);

            double dataUnitPrice=(paymentReportBO.getPointDetails(PaymentPlaneType.DATA)).getUnitPrice();
            double powerUnitPrice=(paymentReportBO.getPointDetails(PaymentPlaneType.POWER)).getUnitPrice();
            double cameraUnitPrice=(paymentReportBO.getPointDetails(PaymentPlaneType.CAMERA)).getUnitPrice();
            paramMap.put("dataV",dataUnitPrice);
            paramMap.put("powerV",powerUnitPrice);
            paramMap.put("cameraV",cameraUnitPrice);

            double dataT=dataUnitPrice*dataCount;
            double powerT=powerUnitPrice*powerCount;
            double cameraT=cameraUnitPrice*cameraCount;

            paramMap.put("dataT",dataT);
            paramMap.put("powerT",powerT);
            paramMap.put("cameraT",cameraT);

            double total=dataT+powerT+cameraT;
            paramMap.put("total",total);

            JasperReport js=(JasperReport)JRLoader.loadObject(this.getClass().getResource("/lk/ijse/asms/view/report/ContractPayseet.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(js, paramMap, new JREmptyDataSource(1));
            JasperViewer.viewReport(jasperPrint,false);
            cmbJob.setItems(null);
            loadAllJob();
            btnGetPaySlip.setDisable(true);

        } catch (JRException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void cmbJobOnAction(ActionEvent actionEvent) {
        btnGetPaySlip.setDisable(false);
    }

    public void backManagerFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MANAGER_DASHBOARD,contractPaymentPane);
    }

    public void jobReportFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.JOB_REPORT,contractPaymentPane);
    }

    public void contractPaymentFormOnAction(ActionEvent actionEvent) {
    }
}
