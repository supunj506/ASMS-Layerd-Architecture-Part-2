package lk.ijse.asms.entity;

import java.time.LocalDate;

public class Job implements SuperEntity{
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

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", cusId='" + cusId + '\'' +
                ", dudeDate=" + dudeDate +
                ", tableCount=" + tableCount +
                ", vehicleId='" + vehicleId + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", location='" + location + '\'' +
                ", jobStatus='" + jobStatus + '\'' +
                ", powerPoint=" + powerPoint +
                ", dataPoint=" + dataPoint +
                ", cameraPoint=" + cameraPoint +
                ", doneBy='" + doneBy + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public LocalDate getDudeDate() {
        return dudeDate;
    }

    public void setDudeDate(LocalDate dudeDate) {
        this.dudeDate = dudeDate;
    }

    public int getTableCount() {
        return tableCount;
    }

    public void setTableCount(int tableCount) {
        this.tableCount = tableCount;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public int getPowerPoint() {
        return powerPoint;
    }

    public void setPowerPoint(int powerPoint) {
        this.powerPoint = powerPoint;
    }

    public int getDataPoint() {
        return dataPoint;
    }

    public void setDataPoint(int dataPoint) {
        this.dataPoint = dataPoint;
    }

    public int getCameraPoint() {
        return cameraPoint;
    }

    public void setCameraPoint(int cameraPoint) {
        this.cameraPoint = cameraPoint;
    }

    public String getDoneBy() {
        return doneBy;
    }

    public void setDoneBy(String doneBy) {
        this.doneBy = doneBy;
    }
}
