package lk.ijse.asms.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

public class LoginFormController {

    public JFXTextField txtUserName;
    public JFXTextField txtPassWord;
    public AnchorPane mainPane;

    public void loginOnActon(ActionEvent actionEvent) {
//        try {
//            User admin = UserModel.checkAdminUser(txtUserName.getText());
//            if(admin!=null){
//                if(admin.getPassword().equals(txtPassWord.getText())){
//                    txtUserName.clear();
////                    new Alert(Alert.AlertType.CONFIRMATION,"Admin Login success ").show();
//                    Navigation.navigate(Routes.ADMIN_DASHBOARD,mainPane);
//
//                }else{
//                    txtPassWord.clear();
//                    new Alert(Alert.AlertType.ERROR,"Admin Password does not match ").show();
//                }
//
//
//            }else if(admin==null){
//
//
//                User manager = UserModel.checkManagerUser(txtUserName.getText());
//                if(manager!=null){
//                    if(manager.getPassword().equals(txtPassWord.getText())){
////                        new Alert(Alert.AlertType.CONFIRMATION,"Manager Login Success ").show();
//                        Navigation.navigate(Routes.MANAGER_DASHBOARD,mainPane);
//                    }else {
//                        txtPassWord.clear();
//                        new Alert(Alert.AlertType.ERROR,"Manager Password does not match ").show();
//                    }
//                }
//
//            }else{
//                new Alert(Alert.AlertType.ERROR,"User not in System ").show();
//            }
//
//
//        } catch (SQLException | ClassNotFoundException e) {
//           new Alert(Alert.AlertType.ERROR,String.valueOf(e)).show();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
////////////        try {
//            String pass = userDAO.checkUser(txtUserName.getText());
//            if(pass!= null){
//                if(pass.equals(txtPassWord.getText())){
//                    Navigation.navigate(Routes.MANAGER_DASHBOARD,mainPane);
//                }else {
//                    new Alert(Alert.AlertType.ERROR,"Password is wrong !!!").show();
//                }
//            }else {
//                new Alert(Alert.AlertType.ERROR,"User Not In System !!!").show();
//            }
//        } catch (SQLException | ClassNotFoundException | IOException e) {
//            throw new RuntimeException(e);
//        }
    }

}
