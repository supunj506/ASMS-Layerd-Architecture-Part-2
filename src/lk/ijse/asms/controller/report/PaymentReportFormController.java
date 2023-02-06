package lk.ijse.asms.controller.report;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
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

    EmployeeDAO employeeDAO=new EmployeeDAOImpl();
    SubcPaymentDAO paymentDAO=new SubcPaymentDAOImpl();
    JobDAO jobDAO=new JobDAOImpl();
    QueryDAO queryDAO=new QueryDAOImpl();
    PaymentPlaneDAO paymentPlaneDAO=new PaymentPlaneDAOImpl();

    public AnchorPane contractPaymentPane;
    public JFXComboBox <String>cmbJob;
    public JFXButton btnGetPaySlip;

    public  void initialize(){
        btnGetPaySlip.setDisable(true);
        loadAllJob();
    }



    private void loadAllJob() {
        try {

            ArrayList<String> arrayList= queryDAO.getContractBaseFinishJob();
            ObservableList<String> obList= FXCollections.observableArrayList();
            for(String item:arrayList){
                obList.addAll(item);
            }
            cmbJob.setItems(obList);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void cmbJobOnAction(ActionEvent actionEvent) {
        btnGetPaySlip.setDisable(false);
    }

    public void salaryPaymentFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SALARY_PAYMENT,contractPaymentPane);
    }

    public void contractPaymentOnAction(ActionEvent actionEvent) {
        String[]temp=String.valueOf(cmbJob.getValue()).split(" / ");
        String employeeId=temp[2];
        String jobId=temp[1];
        String subcPayId=temp[0];
        try {
            EmployeeDTO employeeDTO = employeeDAO.getEmployeeByNic(employeeId);
            HashMap paramMap=new HashMap();
            paramMap.put("Eid", employeeDTO.getId());
            paramMap.put("Enic", employeeDTO.getNic());
            paramMap.put("Ename", employeeDTO.getName());
            paramMap.put("Eaddress", employeeDTO.getAddress());
            JobDTO abc = jobDAO.getJobById(jobId);

            Date startDate = java.sql.Date.valueOf(abc.getStartDate());
            Date endDate = java.sql.Date.valueOf(abc.getEndDate());

            paramMap.put("Jid",temp[1]);
            paramMap.put("Jstart",startDate );
            paramMap.put("Jend",endDate );

            int dataCount = (paymentDAO.getSubPaymentById(subcPayId)).getData_point();
            int powerCount = (paymentDAO.getSubPaymentById(subcPayId)).getData_point();
            int cameraCount = (paymentDAO.getSubPaymentById(subcPayId)).getData_point();
            paramMap.put("dataC",dataCount);
            paramMap.put("powerC",powerCount);
            paramMap.put("cameraC",cameraCount);

            double dataUnitPrice=(paymentPlaneDAO.getPointDetails(PaymentPlaneType.DATA)).getUnitPrice();
            double powerUnitPrice=(paymentPlaneDAO.getPointDetails(PaymentPlaneType.POWER)).getUnitPrice();
            double cameraUnitPrice=(paymentPlaneDAO.getPointDetails(PaymentPlaneType.CAMERA)).getUnitPrice();
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

//            JasperDesign load = JRXmlLoader.load(this.getClass().getResourceAsStream("/lk/ijse/asms/view/report/HellowJasper.jrxml"));
//            JasperReport jasperReport = JasperCompileManager.compileReport(load);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JREmptyDataSource(1));
//            JasperViewer.viewReport(jasperPrint,false);

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
    public void backManagerFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MANAGER_DASHBOARD,contractPaymentPane);
    }


    public void jobReportFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.JOB_REPORT,contractPaymentPane);
    }

    public void contractPaymentFormOnAction(ActionEvent actionEvent) {
    }
}
