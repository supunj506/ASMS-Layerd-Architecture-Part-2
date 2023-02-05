package lk.ijse.asms.dto;

public class CustomerDTO {
    private String id;
    private String name;
    private String address;
    private String email;
    private String contact;
    private String itManagerName;
    private String itManagerContact;

    public CustomerDTO() {
    }

    public CustomerDTO(String id, String name, String address, String email, String contact, String itManagerName, String itManagerContact) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setEmail(email);
        this.setContact(contact);
        this.setItManagerName(itManagerName);
        this.setItManagerContact(itManagerContact);
    }

    public CustomerDTO(String id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
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
