package lk.ijse.asms.entity;

public class EmpTeam implements SuperEntity {
    private String team_it;
    private String emp_id;

    public EmpTeam() {
    }

    public EmpTeam(String team_it, String emp_id) {
        this.setTeam_it(team_it);
        this.setEmp_id(emp_id);
    }

    @Override
    public String toString() {
        return "EmpTeam{" +
                "team_it='" + team_it + '\'' +
                ", emp_id='" + emp_id + '\'' +
                '}';
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
