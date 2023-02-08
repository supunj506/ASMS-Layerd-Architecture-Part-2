package lk.ijse.asms.entity;

public class Vehicle {
    private String reg_no;
    private String type;
    private String colour;
    private String fuel_type;
    private String brand;

    public Vehicle() {
    }

    public Vehicle(String reg_no, String type, String colour, String fuel_type, String brand) {
        this.reg_no = reg_no;
        this.type = type;
        this.colour = colour;
        this.fuel_type = fuel_type;
        this.brand = brand;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
