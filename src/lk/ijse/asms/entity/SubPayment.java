package lk.ijse.asms.entity;

import java.time.LocalDate;

public class SubPayment implements SuperEntity{
    private String sub_payment_id;
    private String employee_id;
    private String job_id;
    private int job_power_point_count;
    private int job_data_point_count;
    private int job_camera_point_count;
    private double sub_payment_total_amount;
    private LocalDate sub_payment_pay_date;
    private String sub_payment_pay_status;

    public SubPayment() {
    }

    public SubPayment(String sub_payment_id, String employee_id, String job_id, int job_power_point_count, int job_data_point_count, int job_camera_point_count, double sub_payment_total_amount, LocalDate sub_payment_pay_date, String sub_payment_pay_status) {
        this.sub_payment_id = sub_payment_id;
        this.employee_id = employee_id;
        this.job_id = job_id;
        this.job_power_point_count = job_power_point_count;
        this.job_data_point_count = job_data_point_count;
        this.job_camera_point_count = job_camera_point_count;
        this.sub_payment_total_amount = sub_payment_total_amount;
        this.sub_payment_pay_date = sub_payment_pay_date;
        this.sub_payment_pay_status = sub_payment_pay_status;
    }

    public SubPayment(String sub_payment_id, String employee_id, String job_id, int job_power_point_count, int job_data_point_count, int job_camera_point_count, double sub_payment_total_amount, String sub_payment_pay_status) {
        this.sub_payment_id = sub_payment_id;
        this.employee_id = employee_id;
        this.job_id = job_id;
        this.job_power_point_count = job_power_point_count;
        this.job_data_point_count = job_data_point_count;
        this.job_camera_point_count = job_camera_point_count;
        this.sub_payment_total_amount = sub_payment_total_amount;
        this.sub_payment_pay_status = sub_payment_pay_status;
    }

    public String getSub_payment_id() {
        return sub_payment_id;
    }

    public void setSub_payment_id(String sub_payment_id) {
        this.sub_payment_id = sub_payment_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
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
}
