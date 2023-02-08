package lk.ijse.asms.entity;

public class Team {
    private String id;
    private String jobId;

    public Team() {
    }

    public Team(String id, String jobId) {
        this.id = id;
        this.jobId = jobId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
