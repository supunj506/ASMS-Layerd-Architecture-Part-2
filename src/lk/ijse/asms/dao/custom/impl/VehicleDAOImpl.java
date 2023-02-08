package lk.ijse.asms.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.asms.dao.custom.VehicleDAO;
import lk.ijse.asms.dto.VehicleDTO;
import lk.ijse.asms.dao.SQLUtil;
import lk.ijse.asms.entity.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDAOImpl implements VehicleDAO {

    @Override
    public boolean save(Vehicle vehicleEntity) throws SQLException, ClassNotFoundException {
       return  (SQLUtil.execute("INSERT INTO vehicle VALUES (?,?,?,?,?)", vehicleEntity.getReg_no(), vehicleEntity.getType(), vehicleEntity.getColour(), vehicleEntity.getFuel_type(), vehicleEntity.getBrand()));
    }
    @Override
    public ArrayList<String> getRegNo() throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT reg_no from vehicle");
        ArrayList<String>reg=new ArrayList<>();
        while (rst.next()){
            reg.add(rst.getString(1));
        }
        return reg;

    }
    @Override
    public Vehicle search(String reg) throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT * FROM vehicle where reg_no=?",reg);
        if (rst.next()){
            return new Vehicle(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)

            );
        }
        return null;
    }
    @Override
    public boolean delete(String reg) throws SQLException, ClassNotFoundException {
        return  SQLUtil.execute("DELETE FROM vehicle WHERE reg_no=?",reg);

    }
    @Override
    public Vehicle getVehicle(String regNo) throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT * FROM vehicle WHERE reg_no=?",regNo);

        if(rst.next()){
            return new Vehicle(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            );
        }
        return null;
    }
    @Override
    public boolean update(Vehicle vehicleEntity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE vehicle SET type=?,color=?,fuel_type=?,brand=? WHERE reg_no=?",
                vehicleEntity.getType(),
                vehicleEntity.getColour(),
                vehicleEntity.getFuel_type(),
                vehicleEntity.getBrand(),
                vehicleEntity.getReg_no());
    }
    @Override
    public ObservableList<String> getAllVehicle() throws SQLException, ClassNotFoundException {
        ObservableList<String >list= FXCollections.observableArrayList();
        ResultSet rst= SQLUtil.execute("select reg_no,type from vehicle");
        while (rst.next()){
            list.add(rst.getString(1)+" / "+rst.getString(2));
        }
            return list;
        }

}
