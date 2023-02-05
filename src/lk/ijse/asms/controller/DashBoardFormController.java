package lk.ijse.asms.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.asms.util.Navigation;
import lk.ijse.asms.util.Routes;

import java.io.IOException;

public class DashBoardFormController {
    public AnchorPane managerPane;

    public void managerLogoutOnAction(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.LOGIN,managerPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void jobOnAction(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADD_JOB,managerPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void paymentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CONTRACT_PAYMENT,managerPane);

    }

    public void employeeOnAction(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADD_EMPLOYEE,managerPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void customerOnAction(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADD_CUSTOMER,managerPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void vehicleOnAction(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.VEHICLE_MANAGE,managerPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void planeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.POINT_PAYMENT_PLANE_UPDATE,managerPane);
    }
}
