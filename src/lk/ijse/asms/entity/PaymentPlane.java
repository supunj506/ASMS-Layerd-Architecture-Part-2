package lk.ijse.asms.entity;

public class PaymentPlane {
    private String id;
    private String name;
    private String description;
    private double unitPrice;

    public PaymentPlane() {
    }

    public PaymentPlane(String id, String name, String description, double unitPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
    }
}
