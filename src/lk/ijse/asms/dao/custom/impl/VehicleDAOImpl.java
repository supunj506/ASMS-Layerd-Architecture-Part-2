package lk.ijse.asms.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.asms.dao.custom.VehicleDAO;
import lk.ijse.asms.dao.util.SQLUtil;
import lk.ijse.asms.entity.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDAOImpl implements VehicleDAO {

    @Override
    public boolean save(Vehicle vehicleEntity) throws SQLException, ClassNotFoundException {
       return  (SQLUtil.execute("INSERT INTO Vehicle VALUES (?,?,?,?,?)", vehicleEntity.getVehicle_reg_no(), vehicleEntity.getVehicle_type(), vehicleEntity.getVehicle_colour(), vehicleEntity.getVehicle_fuel_type(), vehicleEntity.getVehicle_brand()));
    }
    @Override
    public ArrayList<String> getRegNo() throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT vehicle_reg_no  from Vehicle");
        ArrayList<String>reg=new ArrayList<>();
        while (rst.next()){
            reg.add(rst.getString(1));
        }
        return reg;

    }
    @Override
    public Vehicle search(String reg) throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT * FROM Vehicle where vehicle_reg_no =?",reg);
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
        return  SQLUtil.execute("DELETE FROM Vehicle WHERE vehicle_reg_no =?",reg);

    }
    @Override
    public Vehicle getVehicle(String regNo) throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT * FROM Vehicle WHERE vehicle_reg_no =?",regNo);

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
        return SQLUtil.execute("UPDATE Vehicle SET vehicle_type =?,vehicle_colour =?,vehicle_fuel_type =?,vehicle_brand =? WHERE vehicle_reg_no =?",
                vehicleEntity.getVehicle_type(),
                vehicleEntity.getVehicle_colour(),
                vehicleEntity.getVehicle_fuel_type(),
                vehicleEntity.getVehicle_brand(),
                vehicleEntity.getVehicle_reg_no());
    }
    @Override
    public ObservableList<String> getAllVehicle() throws SQLException, ClassNotFoundException {
        ObservableList<String >list= FXCollections.observableArrayList();
        ResultSet rst= SQLUtil.execute("select vehicle_reg_no ,vehicle_type  from Vehicle");
        while (rst.next()){
            list.add(rst.getString(1)+" / "+rst.getString(2));
        }
            return list;
        }

}
