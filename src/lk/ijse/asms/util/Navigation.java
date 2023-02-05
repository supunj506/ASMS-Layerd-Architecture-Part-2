package lk.ijse.asms.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage)Navigation.pane.getScene().getWindow();

        switch (route) {
            case LOGIN:
                window.setTitle("Login Form");
                initUI("loginForm.fxml");
                break;
            case MANAGER_DASHBOARD:
                window.setTitle("DashBord Form");
                initUI("DashBoardForm.fxml");
                break;
            case ADMIN_DASHBOARD:
                window.setTitle("Admin DashBord");
                initUI("AdminDashBoardForm.fxml");
                break;
            case ADD_CUSTOMER:
                window.setTitle("Add Customer Form");
                initUI("AddCustomerForm.fxml");
                break;
            case UPDATE_CUSTOMER:
                window.setTitle("Update Customer Form");
                initUI("UpdateCustomerForm.fxml");
                break;

            case SALARY_PAYMENT:
                window.setTitle("Salary Payment Form");
                initUI("SalaryPaymentForm.fxml");
                break;
            case CONTRACT_PAYMENT:
                window.setTitle("Contract Payment Form");
                initUI("PaymentReportForm.fxml");
                break;
            case ADD_EMPLOYEE:
                window.setTitle("Add Employee Form");
                initUI("AddEmployeeForm.fxml");
                break;
            case VEHICLE_MANAGE:
                window.setTitle("Vehicle Manage");
                initUI("AddVehicleForm.fxml");
                break;
            case ADD_JOB:
                window.setTitle("Add Job ");
                initUI("AddJobForm.fxml");
                break;
            case CALL_JOB:
                window.setTitle("Call Job ");
                initUI("CallJobForm.fxml");
                break;
            case FINISH_JOB:
                window.setTitle("Finish Job ");
                initUI("FinishJobForm.fxml");
                break;
            case DELETE_VEHICLE:
                window.setTitle("Delete Vehicle Form");
                initUI("DeleteVehicleForm.fxml");
                break;
            case DELETE_EMPLOYEE:
                window.setTitle("Delete Employee Form");
                initUI("DeleteEmployeeForm.fxml");
                break;
            case UPDATE_EMPLOYEE:
                window.setTitle("Update Employee Form");
                initUI("UpdateEmployeeForm.fxml");
                break;
            case SALARY_PLANE_UPDATE:
                window.setTitle("Salary Plane Update Form");
                initUI("SalaryPlaneUpdateForm.fxml");
                break;
            case POINT_PAYMENT_PLANE_UPDATE:
                window.setTitle("Point Payment Plane Update Form");
                initUI("PaymentPlaneUpdateForm.fxml");
                break;
            case JOB_REPORT:
                window.setTitle("Job Report Form");
                initUI("JobReportForm.fxml");
                break;





            default:
                new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    public static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/asms/view/" + location)));
    }
}
