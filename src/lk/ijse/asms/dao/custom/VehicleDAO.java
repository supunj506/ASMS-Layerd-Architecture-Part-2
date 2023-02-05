package lk.ijse.asms.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.asms.dao.CrudDAO;
import lk.ijse.asms.dto.VehicleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleDAO extends CrudDAO<VehicleDTO> {
    boolean save(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException;
    ArrayList<String> getRegNo() throws SQLException, ClassNotFoundException;
    VehicleDTO search(String reg) throws SQLException, ClassNotFoundException;
    boolean delete(String reg) throws SQLException, ClassNotFoundException;
    VehicleDTO getVehicle(String regNo) throws SQLException, ClassNotFoundException;
    boolean update(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException;
    ObservableList<String> getAllVehicle() throws SQLException, ClassNotFoundException;


}
