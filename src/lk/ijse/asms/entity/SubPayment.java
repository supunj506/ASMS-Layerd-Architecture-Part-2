package lk.ijse.asms.entity;

import java.time.LocalDate;

public class SubPayment {
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


}
