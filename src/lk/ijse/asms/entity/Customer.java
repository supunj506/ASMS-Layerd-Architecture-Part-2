package lk.ijse.asms.entity;

public class Customer {
    private String id;
    private String name;
    private String address;
    private String email;
    private String contact;
    private String itManagerName;
    private String itManagerContact;

    public Customer() {
    }

    public Customer(String id, String name, String address, String email, String contact, String itManagerName, String itManagerContact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.contact = contact;
        this.itManagerName = itManagerName;
        this.itManagerContact = itManagerContact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", itManagerName='" + itManagerName + '\'' +
                ", itManagerContact='" + itManagerContact + '\'' +
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

    public String getItManagerName() {
        return itManagerName;
    }

    public void setItManagerName(String itManagerName) {
        this.itManagerName = itManagerName;
    }

    public String getItManagerContact() {
        return itManagerContact;
    }

    public void setItManagerContact(String itManagerContact) {
        this.itManagerContact = itManagerContact;
    }
}
