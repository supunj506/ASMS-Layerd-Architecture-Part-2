package lk.ijse.asms.dto;

public class DivisionDTO {
    private String id;
    private String job;

    public DivisionDTO() {
    }

    public DivisionDTO(String id, String job) {
        this.setId(id);
        this.setJob(job);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
