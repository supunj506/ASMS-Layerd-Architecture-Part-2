package lk.ijse.asms.entity;

public class Team implements SuperEntity{
    private String team_id;
    private String job_id;

    public Team() {
    }

    public Team(String team_id, String job_id) {
        this.team_id = team_id;
        this.job_id = job_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }
}
