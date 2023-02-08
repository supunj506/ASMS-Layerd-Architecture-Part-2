package lk.ijse.asms.entity;

public class Customer implements SuperEntity{
    private String customer_id;
    private String customer_name;
    private String customer_address;
    private String customer_email;
    private String customer_contact;
    private String customer_it_manager_name;
    private String customer_it_manager_contact;

    public Customer() {
    }

    public Customer(String customer_id, String customer_name, String customer_address, String customer_email, String customer_contact, String customer_it_manager_name, String customer_it_manager_contact) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_address = customer_address;
        this.customer_email = customer_email;
        this.customer_contact = customer_contact;
        this.customer_it_manager_name = customer_it_manager_name;
        this.customer_it_manager_contact = customer_it_manager_contact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + customer_id + '\'' +
                ", name='" + customer_name + '\'' +
                ", address='" + customer_address + '\'' +
                ", email='" + customer_email + '\'' +
                ", contact='" + customer_contact + '\'' +
                ", itManagerName='" + customer_it_manager_name + '\'' +
                ", itManagerContact='" + customer_it_manager_contact + '\'' +
                '}';
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_contact() {
        return customer_contact;
    }

    public void setCustomer_contact(String customer_contact) {
        this.customer_contact = customer_contact;
    }

    public String getCustomer_it_manager_name() {
        return customer_it_manager_name;
    }

    public void setCustomer_it_manager_name(String customer_it_manager_name) {
        this.customer_it_manager_name = customer_it_manager_name;
    }

    public String getCustomer_it_manager_contact() {
        return customer_it_manager_contact;
    }

    public void setCustomer_it_manager_contact(String customer_it_manager_contact) {
        this.customer_it_manager_contact = customer_it_manager_contact;
    }
}
