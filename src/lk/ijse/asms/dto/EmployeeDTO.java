package lk.ijse.asms.dto;

import java.time.LocalDate;

public class EmployeeDTO {
    private String id;
    private String nic;
    private String name;
    private String gender;
    private LocalDate dob;
    private String address;
    private String email;
    private String contact;
    private String empType;
    private String division;
    private LocalDate joinDate;

    public EmployeeDTO() {
    }
    public EmployeeDTO(String id, String nic, String name, String gender, LocalDate dob, String address, String email, String contact, String empType, String division, LocalDate joinDate) {
        this.setId(id);
        this.setNic(nic);
        this.setName(name);
        this.setGender(gender);
        this.setDob(dob);
        this.setAddress(address);
        this.setEmail(email);
        this.setContact(contact);
        this.setEmpType(empType);
        this.setDivision(division);
        this.setJoinDate(joinDate);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
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

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }
}
