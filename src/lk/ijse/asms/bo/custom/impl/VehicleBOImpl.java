package lk.ijse.asms.bo.custom.impl;

import lk.ijse.asms.bo.custom.VehicleBO;
import lk.ijse.asms.dao.util.DAOFactory;
import lk.ijse.asms.dao.custom.VehicleDAO;
import lk.ijse.asms.dto.VehicleDTO;
import lk.ijse.asms.entity.Vehicle;

import java.sql.SQLException;

public class VehicleBOImpl implements VehicleBO {
    private final VehicleDAO vehicleDAO;

    public VehicleBOImpl() {
        vehicleDAO=DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.VEHICLE);
    }

    public boolean saveVehicle(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException {
        return vehicleDAO.save(new Vehicle(vehicleDTO.getReg_no(),vehicleDTO.getType(),vehicleDTO.getColour(),vehicleDTO.getFuel_type(),vehicleDTO.getBrand()));
    }
}
