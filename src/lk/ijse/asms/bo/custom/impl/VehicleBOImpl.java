package lk.ijse.asms.bo.custom.impl;

import lk.ijse.asms.bo.custom.VehicleBO;
import lk.ijse.asms.dao.custom.VehicleDAO;
import lk.ijse.asms.dao.custom.impl.VehicleDAOImpl;
import lk.ijse.asms.dto.VehicleDTO;

import java.sql.SQLException;

public class VehicleBOImpl implements VehicleBO {
    VehicleDAO vehicleDAO=new VehicleDAOImpl();

    public boolean saveVehicle(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException {
        return vehicleDAO.save(vehicleDTO);
    }
}
