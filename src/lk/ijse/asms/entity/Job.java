package lk.ijse.asms.entity;

import java.time.LocalDate;

public class Job implements SuperEntity{
    private String job_id;
    private String job_type;
    private String customer_id;
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

    public Job() {
    }
    public Job(String job_id, String job_type, String customer_id, LocalDate job_dude_date, int job_table_count, String job_location, String job_status) {
        this.job_id = job_id;
        this.job_type = job_type;
        this.customer_id = customer_id;
        this.job_dude_date = job_dude_date;
        this.job_table_count = job_table_count;
        this.job_location = job_location;
        this.job_status = job_status;
    }
    public Job(String job_id, String vehicle_id, LocalDate job_start_date, String job_status, String job_done_by) {
        this.job_id = job_id;
        this.vehicle_id = vehicle_id;
        this.job_start_date = job_start_date;
        this.job_status = job_status;
        this.job_done_by = job_done_by;
    }
    public Job(String job_id, LocalDate job_end_date, String job_status, int job_power_point_count, int job_data_point_count, int job_camera_point_count) {
        this.job_id = job_id;
        this.job_end_date = job_end_date;
        this.job_status = job_status;
        this.job_power_point_count = job_power_point_count;
        this.job_data_point_count = job_data_point_count;
        this.job_camera_point_count = job_camera_point_count;
    }

    public Job(String job_id, String job_type, String customer_id, LocalDate job_dude_date, int job_table_count, String vehicle_id, LocalDate job_start_date, LocalDate job_end_date, String job_location, String job_status, int job_power_point_count, int job_data_point_count, int job_camera_point_count, String job_done_by) {
        this.job_id = job_id;
        this.job_type = job_type;
        this.customer_id = customer_id;
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

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
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
}
