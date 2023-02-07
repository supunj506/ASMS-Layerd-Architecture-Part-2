package lk.ijse.asms.controller.report;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.asms.bo.BOFactory;
import lk.ijse.asms.bo.custom.JobReportBO;
import lk.ijse.asms.bo.custom.PaymentReportBO;
import lk.ijse.asms.bo.custom.impl.JobReportBOImpl;
import lk.ijse.asms.dto.CustomerDTO;
import lk.ijse.asms.dto.JobDTO;
import lk.ijse.asms.util.Navigation;
import lk.ijse.asms.util.Routes;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class JobReportFormController {
    JobReportBO jobReportBO=(JobReportBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.JOBREPORT);

    public AnchorPane jobReportPane;
    public JFXComboBox<String> cmbJob;
    public JFXButton btnGetReport;

    public void initialize(){
        btnGetReport.setDisable(true);
        loadJob();
    }

    private void loadJob() {
        try {
            cmbJob.setItems(jobReportBO.getFinishJobList("DONE"));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getReportOnAction(ActionEvent actionEvent) {
        String[]temp=String.valueOf(cmbJob.getValue()).split(" / ");
        try {
            CustomerDTO customerDTOForJob = jobReportBO.getCustomerByName(temp[1]);

            HashMap paramMap=new HashMap();
            paramMap.put("cusId", customerDTOForJob.getId());
            paramMap.put("cusName", customerDTOForJob.getName());
            paramMap.put("cusAddress", customerDTOForJob.getAddress());

            JobDTO abc = jobReportBO.getJobById(temp[0]);

            paramMap.put("jId", abc.getId());
            paramMap.put("jType", abc.getType());
            paramMap.put("jLocation", abc.getLocation());
            paramMap.put("jTableCount", abc.getTableCount());
            paramMap.put("jData", abc.getDataPoint());
            paramMap.put("jPower", abc.getPowerPoint());

            JasperReport js=(JasperReport) JRLoader.loadObject(this.getClass().getResource("/lk/ijse/asms/view/report/JobReport.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(js, paramMap, new JREmptyDataSource(1));
            JasperViewer.viewReport(jasperPrint,false);
            cmbJob.setItems(null);
            loadJob();
            btnGetReport.setDisable(true);

        } catch (SQLException | ClassNotFoundException | JRException e) {
            e.printStackTrace();
        }
    }

    public void backManagerFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MANAGER_DASHBOARD,jobReportPane);
    }

    public void contractPaymentFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CONTRACT_PAYMENT,jobReportPane);
    }

    public void jobReportFormOnAction(ActionEvent actionEvent) {
    }

    public void cmbJobOnAction(ActionEvent actionEvent) {
        btnGetReport.setDisable(false);
    }
}
