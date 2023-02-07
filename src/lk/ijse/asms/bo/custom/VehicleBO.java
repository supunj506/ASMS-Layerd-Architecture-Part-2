package lk.ijse.asms.bo.custom;

import lk.ijse.asms.bo.SuperBO;
import lk.ijse.asms.dto.VehicleDTO;

import java.sql.SQLException;

public interface VehicleBO extends SuperBO {
    boolean saveVehicle(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException;
}
