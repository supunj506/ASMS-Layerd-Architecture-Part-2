package lk.ijse.asms.entity;

public class Vehicle implements SuperEntity{
    private String vehicle_reg_no;
    private String vehicle_type;
    private String vehicle_colour;
    private String vehicle_fuel_type;
    private String vehicle_brand;

    public Vehicle() {
    }

    public Vehicle(String vehicle_reg_no, String vehicle_type, String vehicle_colour, String vehicle_fuel_type, String vehicle_brand) {
        this.vehicle_reg_no = vehicle_reg_no;
        this.vehicle_type = vehicle_type;
        this.vehicle_colour = vehicle_colour;
        this.vehicle_fuel_type = vehicle_fuel_type;
        this.vehicle_brand = vehicle_brand;
    }

    public String getVehicle_reg_no() {
        return vehicle_reg_no;
    }

    public void setVehicle_reg_no(String vehicle_reg_no) {
        this.vehicle_reg_no = vehicle_reg_no;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getVehicle_colour() {
        return vehicle_colour;
    }

    public void setVehicle_colour(String vehicle_colour) {
        this.vehicle_colour = vehicle_colour;
    }

    public String getVehicle_fuel_type() {
        return vehicle_fuel_type;
    }

    public void setVehicle_fuel_type(String vehicle_fuel_type) {
        this.vehicle_fuel_type = vehicle_fuel_type;
    }

    public String getVehicle_brand() {
        return vehicle_brand;
    }

    public void setVehicle_brand(String vehicle_brand) {
        this.vehicle_brand = vehicle_brand;
    }
}
