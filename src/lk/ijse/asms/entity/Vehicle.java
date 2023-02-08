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

}
