package lk.ijse.asms.entity;

public class PaymentPlane implements SuperEntity {
    private String id;
    private String name;
    private String description;
    private double unitPrice;

    public PaymentPlane() {
    }

    public PaymentPlane(String id, String name, String text, double unitPrice) {
        this.id = id;
        this.name = name;
        this.description = text;
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "PaymentPlaneDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
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
