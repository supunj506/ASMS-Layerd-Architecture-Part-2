package lk.ijse.asms.dto;

public class TeamDTO {
    private String id;
    private String jobId;

    public TeamDTO() {
    }

    public TeamDTO(String id, String jobId) {
        this.setId(id);
        this.setJobId(jobId);
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
