package lk.ijse.asms.entity;

public class PaymentPlane implements SuperEntity{
    private String payment_plane_id;
    private String payment_plane_name;
    private String payment_plane_description;
    private double payment_plane_unite_price;

    public PaymentPlane() {
    }

    public PaymentPlane(String payment_plane_id, String payment_plane_name, String payment_plane_description, double payment_plane_unite_price) {
        this.payment_plane_id = payment_plane_id;
        this.payment_plane_name = payment_plane_name;
        this.payment_plane_description = payment_plane_description;
        this.payment_plane_unite_price = payment_plane_unite_price;
    }

    public String getPayment_plane_id() {
        return payment_plane_id;
    }

    public void setPayment_plane_id(String payment_plane_id) {
        this.payment_plane_id = payment_plane_id;
    }

    public String getPayment_plane_name() {
        return payment_plane_name;
    }

    public void setPayment_plane_name(String payment_plane_name) {
        this.payment_plane_name = payment_plane_name;
    }

    public String getPayment_plane_description() {
        return payment_plane_description;
    }

    public void setPayment_plane_description(String payment_plane_description) {
        this.payment_plane_description = payment_plane_description;
    }

    public double getPayment_plane_unite_price() {
        return payment_plane_unite_price;
    }

    public void setPayment_plane_unite_price(double payment_plane_unite_price) {
        this.payment_plane_unite_price = payment_plane_unite_price;
    }
}
