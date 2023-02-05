package lk.ijse.asms.dto;

import java.time.LocalDate;

public class CustomDTO {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerContact;
    private String itManagerName;
    private String itManagerContact;

    private String DivisionId;
    private String DivisionType;

    private String employeeId;
    private String nic;
    private String employeeName;
    private String employeeGender;
    private LocalDate employeeDob;
    private String employeeAddress;
    private String employeeEmail;
    private String employeeContact;
    private String empType;
    private LocalDate joinDate;

    private String JobId;
    private String JobType;
    private LocalDate dudeDate;
    private int tableCount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private String jobStatus;
    private int powerPoint;
    private int dataPoint;
    private int cameraPoint;
    private String doneBy;

    private String PaymentPlaneId;
    private String PaymentPlaneName;
    private String description;
    private double unitPrice;

    private String paymentId;
    private double total_amount;
    private LocalDate pay_date;
    private String pay_status;

    private String TeamId;

    private String UserId;
    private String UserPassword;

    private String reg_no;
    private String VehicleType;
    private String VehicleColour;
    private String fuel_type;
    private String VehicleBrand;

    public CustomDTO() {
    }

    public CustomDTO( String employeeId, String employeeName,String divisionType) {
        DivisionType = divisionType;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public CustomDTO(String employeeId, int dataPoint, int powerPoint, int cameraPoint) {
        this.employeeId = employeeId;
        this.powerPoint = powerPoint;
        this.dataPoint = dataPoint;
        this.cameraPoint = cameraPoint;
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
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

    public String getDivisionId() {
        return DivisionId;
    }

    public void setDivisionId(String divisionId) {
        DivisionId = divisionId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public LocalDate getEmployeeDob() {
        return employeeDob;
    }

    public void setEmployeeDob(LocalDate employeeDob) {
        this.employeeDob = employeeDob;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeContact() {
        return employeeContact;
    }

    public void setEmployeeContact(String employeeContact) {
        this.employeeContact = employeeContact;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getJobId() {
        return JobId;
    }

    public void setJobId(String jobId) {
        JobId = jobId;
    }

    public String getJobType() {
        return JobType;
    }

    public void setJobType(String jobType) {
        JobType = jobType;
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

    public String getPaymentPlaneId() {
        return PaymentPlaneId;
    }

    public void setPaymentPlaneId(String paymentPlaneId) {
        PaymentPlaneId = paymentPlaneId;
    }

    public String getPaymentPlaneName() {
        return PaymentPlaneName;
    }

    public void setPaymentPlaneName(String paymentPlaneName) {
        PaymentPlaneName = paymentPlaneName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
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

    public String getTeamId() {
        return TeamId;
    }

    public void setTeamId(String teamId) {
        TeamId = teamId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public String getVehicleColour() {
        return VehicleColour;
    }

    public void setVehicleColour(String vehicleColour) {
        VehicleColour = vehicleColour;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getVehicleBrand() {
        return VehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        VehicleBrand = vehicleBrand;
    }

    public String getDivisionType() {
        return DivisionType;
    }

    public void setDivisionType(String divisionType) {
        DivisionType = divisionType;
    }
}
