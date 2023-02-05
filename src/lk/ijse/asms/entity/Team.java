package lk.ijse.asms.entity;

public class Team implements SuperEntity {
    private String id;
    private String jobId;

    public Team() {
    }

    public Team(String id, String jobId) {
        this.setId(id);
        this.setJobId(jobId);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", jobId='" + jobId + '\'' +
                '}';
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
