package lk.ijse.asms.entity;

public class EmployeeTeam implements SuperEntity{
    private String team_id;
    private String employee_id;

    public EmployeeTeam() {
    }

    public EmployeeTeam(String team_id, String employee_id) {
        this.team_id = team_id;
        this.employee_id = employee_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }
}
