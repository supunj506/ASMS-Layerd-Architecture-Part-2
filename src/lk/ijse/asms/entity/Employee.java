package lk.ijse.asms.entity;

import java.time.LocalDate;

public class Employee implements SuperEntity{
    private String employee_id;
    private String employee_nic;
    private String employee_name;
    private String employee_gender;
    private LocalDate employee_dob;
    private String employee_address;
    private String employee_email;
    private String employee_contact;
    private String employee_type;
    private String employee_division;
    private LocalDate employee_joinDate;

    public Employee() {
    }

    public Employee(String employee_id, String employee_nic, String employee_name, String employee_gender, LocalDate employee_dob, String employee_address, String employee_email, String employee_contact, String employee_type, String employee_division, LocalDate employee_joinDate) {
        this.employee_id = employee_id;
        this.employee_nic = employee_nic;
        this.employee_name = employee_name;
        this.employee_gender = employee_gender;
        this.employee_dob = employee_dob;
        this.employee_address = employee_address;
        this.employee_email = employee_email;
        this.employee_contact = employee_contact;
        this.employee_type = employee_type;
        this.employee_division = employee_division;
        this.employee_joinDate = employee_joinDate;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_nic() {
        return employee_nic;
    }

    public void setEmployee_nic(String employee_nic) {
        this.employee_nic = employee_nic;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_gender() {
        return employee_gender;
    }

    public void setEmployee_gender(String employee_gender) {
        this.employee_gender = employee_gender;
    }

    public LocalDate getEmployee_dob() {
        return employee_dob;
    }

    public void setEmployee_dob(LocalDate employee_dob) {
        this.employee_dob = employee_dob;
    }

    public String getEmployee_address() {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public String getEmployee_contact() {
        return employee_contact;
    }

    public void setEmployee_contact(String employee_contact) {
        this.employee_contact = employee_contact;
    }

    public String getEmployee_type() {
        return employee_type;
    }

    public void setEmployee_type(String employee_type) {
        this.employee_type = employee_type;
    }

    public String getEmployee_division() {
        return employee_division;
    }

    public void setEmployee_division(String employee_division) {
        this.employee_division = employee_division;
    }

    public LocalDate getEmployee_joinDate() {
        return employee_joinDate;
    }

    public void setEmployee_joinDate(LocalDate employee_joinDate) {
        this.employee_joinDate = employee_joinDate;
    }

}
