package lk.ijse.asms.entity;

import java.time.LocalDate;

public class Job {
    private String id;
    private String type;
    private String cusId;
    private LocalDate dudeDate;
    private int tableCount;
    private String vehicleId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private String jobStatus;
    private int powerPoint;
    private int dataPoint;
    private int cameraPoint;
    private String doneBy;

    public Job() {
    }

    public Job(String id, String type, String cusId, LocalDate dudeDate, int tableCount, String vehicleId, LocalDate startDate, LocalDate endDate, String location, String jobStatus, int powerPoint, int dataPoint, int cameraPoint, String doneBy) {
        this.id = id;
        this.type = type;
        this.cusId = cusId;
        this.dudeDate = dudeDate;
        this.tableCount = tableCount;
        this.vehicleId = vehicleId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.jobStatus = jobStatus;
        this.powerPoint = powerPoint;
        this.dataPoint = dataPoint;
        this.cameraPoint = cameraPoint;
        this.doneBy = doneBy;
    }
}
