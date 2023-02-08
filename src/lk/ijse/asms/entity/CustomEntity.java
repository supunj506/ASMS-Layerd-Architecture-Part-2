package lk.ijse.asms.entity;

import java.time.LocalDate;

public class CustomEntity implements SuperEntity {
    private String customer_id;
    private String customer_name;
    private String customer_address;
    private String customer_email;
    private String customer_contact;
    private String customer_it_manager_name;
    private String customer_it_manager_contact;

    private String division_id;
    private String division_type;

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

    private String team_id;

    private String job_id;
    private String job_type;;
    private LocalDate job_dude_date;
    private int job_table_count;
    private String vehicle_id;
    private LocalDate job_start_date;
    private LocalDate job_end_date;
    private String job_location;
    private String job_status;
    private int job_power_point_count;
    private int job_data_point_count;
    private int job_camera_point_count;
    private String job_done_by;

    private String payment_plane_id;
    private String payment_plane_name;
    private String payment_plane_description;
    private double payment_plane_unite_price;

    private String sub_payment_id;
    private double sub_payment_total_amount;
    private LocalDate sub_payment_pay_date;
    private String sub_payment_pay_status;

    private String user_id;
    private String user_password;

    private String vehicle_reg_no;
    private String vehicle_type;
    private String vehicle_colour;
    private String vehicle_fuel_type;
    private String vehicle_brand;

    public CustomEntity() {
    }

    public CustomEntity(String employee_id, String employee_name,String division_type) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.division_type = division_type;
    }

    public CustomEntity(String employee_id, int job_data_point_count,int job_power_point_count, int job_camera_point_count) {
        this.employee_id = employee_id;
        this.job_data_point_count = job_data_point_count;
        this.job_power_point_count = job_power_point_count;
        this.job_camera_point_count = job_camera_point_count;
    }

    public CustomEntity(String customer_id, String customer_name, String customer_address, String customer_email, String customer_contact, String customer_it_manager_name, String customer_it_manager_contact, String division_id, String division_type, String employee_id, String employee_nic, String employee_name, String employee_gender, LocalDate employee_dob, String employee_address, String employee_email, String employee_contact, String employee_type, String employee_division, LocalDate employee_joinDate, String team_id, String job_id, String job_type, LocalDate job_dude_date, int job_table_count, String vehicle_id, LocalDate job_start_date, LocalDate job_end_date, String job_location, String job_status, int job_power_point_count, int job_data_point_count, int job_camera_point_count, String job_done_by, String payment_plane_id, String payment_plane_name, String payment_plane_description, double payment_plane_unite_price, String sub_payment_id, double sub_payment_total_amount, LocalDate sub_payment_pay_date, String sub_payment_pay_status, String user_id, String user_password, String vehicle_reg_no, String vehicle_type, String vehicle_colour, String vehicle_fuel_type, String vehicle_brand) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_address = customer_address;
        this.customer_email = customer_email;
        this.customer_contact = customer_contact;
        this.customer_it_manager_name = customer_it_manager_name;
        this.customer_it_manager_contact = customer_it_manager_contact;
        this.division_id = division_id;
        this.division_type = division_type;
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
        this.team_id = team_id;
        this.job_id = job_id;
        this.job_type = job_type;
        this.job_dude_date = job_dude_date;
        this.job_table_count = job_table_count;
        this.vehicle_id = vehicle_id;
        this.job_start_date = job_start_date;
        this.job_end_date = job_end_date;
        this.job_location = job_location;
        this.job_status = job_status;
        this.job_power_point_count = job_power_point_count;
        this.job_data_point_count = job_data_point_count;
        this.job_camera_point_count = job_camera_point_count;
        this.job_done_by = job_done_by;
        this.payment_plane_id = payment_plane_id;
        this.payment_plane_name = payment_plane_name;
        this.payment_plane_description = payment_plane_description;
        this.payment_plane_unite_price = payment_plane_unite_price;
        this.sub_payment_id = sub_payment_id;
        this.sub_payment_total_amount = sub_payment_total_amount;
        this.sub_payment_pay_date = sub_payment_pay_date;
        this.sub_payment_pay_status = sub_payment_pay_status;
        this.user_id = user_id;
        this.user_password = user_password;
        this.vehicle_reg_no = vehicle_reg_no;
        this.vehicle_type = vehicle_type;
        this.vehicle_colour = vehicle_colour;
        this.vehicle_fuel_type = vehicle_fuel_type;
        this.vehicle_brand = vehicle_brand;
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

    public String getDivision_id() {
        return division_id;
    }

    public void setDivision_id(String division_id) {
        this.division_id = division_id;
    }

    public String getDivision_type() {
        return division_type;
    }

    public void setDivision_type(String division_type) {
        this.division_type = division_type;
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

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public LocalDate getJob_dude_date() {
        return job_dude_date;
    }

    public void setJob_dude_date(LocalDate job_dude_date) {
        this.job_dude_date = job_dude_date;
    }

    public int getJob_table_count() {
        return job_table_count;
    }

    public void setJob_table_count(int job_table_count) {
        this.job_table_count = job_table_count;
    }

    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public LocalDate getJob_start_date() {
        return job_start_date;
    }

    public void setJob_start_date(LocalDate job_start_date) {
        this.job_start_date = job_start_date;
    }

    public LocalDate getJob_end_date() {
        return job_end_date;
    }

    public void setJob_end_date(LocalDate job_end_date) {
        this.job_end_date = job_end_date;
    }

    public String getJob_location() {
        return job_location;
    }

    public void setJob_location(String job_location) {
        this.job_location = job_location;
    }

    public String getJob_status() {
        return job_status;
    }

    public void setJob_status(String job_status) {
        this.job_status = job_status;
    }

    public int getJob_power_point_count() {
        return job_power_point_count;
    }

    public void setJob_power_point_count(int job_power_point_count) {
        this.job_power_point_count = job_power_point_count;
    }

    public int getJob_data_point_count() {
        return job_data_point_count;
    }

    public void setJob_data_point_count(int job_data_point_count) {
        this.job_data_point_count = job_data_point_count;
    }

    public int getJob_camera_point_count() {
        return job_camera_point_count;
    }

    public void setJob_camera_point_count(int job_camera_point_count) {
        this.job_camera_point_count = job_camera_point_count;
    }

    public String getJob_done_by() {
        return job_done_by;
    }

    public void setJob_done_by(String job_done_by) {
        this.job_done_by = job_done_by;
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

    public String getSub_payment_id() {
        return sub_payment_id;
    }

    public void setSub_payment_id(String sub_payment_id) {
        this.sub_payment_id = sub_payment_id;
    }

    public double getSub_payment_total_amount() {
        return sub_payment_total_amount;
    }

    public void setSub_payment_total_amount(double sub_payment_total_amount) {
        this.sub_payment_total_amount = sub_payment_total_amount;
    }

    public LocalDate getSub_payment_pay_date() {
        return sub_payment_pay_date;
    }

    public void setSub_payment_pay_date(LocalDate sub_payment_pay_date) {
        this.sub_payment_pay_date = sub_payment_pay_date;
    }

    public String getSub_payment_pay_status() {
        return sub_payment_pay_status;
    }

    public void setSub_payment_pay_status(String sub_payment_pay_status) {
        this.sub_payment_pay_status = sub_payment_pay_status;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getVehicle_reg_no() {
        return vehicle_reg_no;
    }

    public void setVehicle_reg_no(String vehicle_reg_no) {
        this.vehicle_reg_no = vehicle_reg_no;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getVehicle_colour() {
        return vehicle_colour;
    }

    public void setVehicle_colour(String vehicle_colour) {
        this.vehicle_colour = vehicle_colour;
    }

    public String getVehicle_fuel_type() {
        return vehicle_fuel_type;
    }

    public void setVehicle_fuel_type(String vehicle_fuel_type) {
        this.vehicle_fuel_type = vehicle_fuel_type;
    }

    public String getVehicle_brand() {
        return vehicle_brand;
    }

    public void setVehicle_brand(String vehicle_brand) {
        this.vehicle_brand = vehicle_brand;
    }
}
