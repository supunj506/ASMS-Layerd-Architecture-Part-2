package lk.ijse.asms.dto;

public class PaymentPlaneDTO {
    private String id;
    private String name;
    private String description;
    private double unitPrice;

    public PaymentPlaneDTO() {
    }

    public PaymentPlaneDTO(String name, String text, double unitPrice) {
        this.name = name;
        this.description = text;
        this.unitPrice = unitPrice;
    }

    public PaymentPlaneDTO(String id, String name, String text, double unitPrice) {
        this.id = id;
        this.name = name;
        this.description = text;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
