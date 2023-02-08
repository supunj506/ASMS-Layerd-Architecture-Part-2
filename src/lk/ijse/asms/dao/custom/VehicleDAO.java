package lk.ijse.asms.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.asms.dao.util.CrudDAO;
import lk.ijse.asms.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleDAO extends CrudDAO<Vehicle,String>  {
    boolean save(Vehicle vehicleEntity) throws SQLException, ClassNotFoundException;
    ArrayList<String> getRegNo() throws SQLException, ClassNotFoundException;
    Vehicle search(String reg) throws SQLException, ClassNotFoundException;
    boolean delete(String reg) throws SQLException, ClassNotFoundException;
    Vehicle getVehicle(String regNo) throws SQLException, ClassNotFoundException;
    boolean update(Vehicle vehicleEntity) throws SQLException, ClassNotFoundException;
    ObservableList<String> getAllVehicle() throws SQLException, ClassNotFoundException;


}
