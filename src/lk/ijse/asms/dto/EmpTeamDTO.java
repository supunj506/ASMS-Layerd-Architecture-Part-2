package lk.ijse.asms.dto;

public class EmpTeamDTO {
    private String team_it;
    private String emp_id;

    public EmpTeamDTO() {
    }

    public EmpTeamDTO(String team_it, String emp_id) {
        this.setTeam_it(team_it);
        this.setEmp_id(emp_id);
    }

    public String getTeam_it() {
        return team_it;
    }

    public void setTeam_it(String team_it) {
        this.team_it = team_it;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }
}
