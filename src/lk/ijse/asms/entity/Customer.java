package lk.ijse.asms.entity;

public class Customer {
    private String id;
    private String name;
    private String address;
    private String email;
    private String contact;
    private String it_manager_name;
    private String it_manager_contact;

    public Customer() {
    }

    public Customer(String id, String name, String address, String email, String contact, String it_manager_name, String it_manager_contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.contact = contact;
        this.it_manager_name = it_manager_name;
        this.it_manager_contact = it_manager_contact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", itManagerName='" + it_manager_name + '\'' +
                ", itManagerContact='" + it_manager_contact + '\'' +
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIt_manager_name() {
        return it_manager_name;
    }

    public void setIt_manager_name(String it_manager_name) {
        this.it_manager_name = it_manager_name;
    }

    public String getIt_manager_contact() {
        return it_manager_contact;
    }

    public void setIt_manager_contact(String it_manager_contact) {
        this.it_manager_contact = it_manager_contact;
    }
}
