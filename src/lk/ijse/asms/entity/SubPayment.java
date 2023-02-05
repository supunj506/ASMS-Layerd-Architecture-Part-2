package lk.ijse.asms.entity;

import java.time.LocalDate;

public class SubPayment implements SuperEntity {
    private String id;
    private String emp_id;
    private String job_id;
    private int data_point;
    private int power_point;
    private int camera_point;
    private double total_amount;
    private LocalDate pay_date;
    private String pay_status;

    public SubPayment() {
    }

    public SubPayment(String id, String emp_id, String job_id, int data_point, int power_point, int camera_point, double total_amount, LocalDate pay_date, String pay_status) {
        this.id = id;
        this.emp_id = emp_id;
        this.job_id = job_id;
        this.data_point = data_point;
        this.power_point = power_point;
        this.camera_point = camera_point;
        this.total_amount = total_amount;
        this.pay_date = pay_date;
        this.pay_status = pay_status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public int getData_point() {
        return data_point;
    }

    public void setData_point(int data_point) {
        this.data_point = data_point;
    }

    public int getPower_point() {
        return power_point;
    }

    public void setPower_point(int power_point) {
        this.power_point = power_point;
    }

    public int getCamera_point() {
        return camera_point;
    }

    public void setCamera_point(int camera_point) {
        this.camera_point = camera_point;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public LocalDate getPay_date() {
        return pay_date;
    }

    public void setPay_date(LocalDate pay_date) {
        this.pay_date = pay_date;
    }

    public String getPay_status() {
        return pay_status;
    }

    public void setPay_status(String pay_status) {
        this.pay_status = pay_status;
    }
}
