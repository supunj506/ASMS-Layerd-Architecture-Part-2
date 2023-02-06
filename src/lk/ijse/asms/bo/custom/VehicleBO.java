package lk.ijse.asms.bo.custom;

import lk.ijse.asms.dto.VehicleDTO;

import java.sql.SQLException;

public interface VehicleBO {
    boolean saveVehicle(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException;
}
