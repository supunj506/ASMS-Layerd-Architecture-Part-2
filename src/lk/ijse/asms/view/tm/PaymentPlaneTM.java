package lk.ijse.asms.view.tm;

public class PaymentPlaneTM {
    private String type;
    private String description;
    private double price;

    public PaymentPlaneTM() {
    }

    public PaymentPlaneTM(String type, String description, double price) {
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
