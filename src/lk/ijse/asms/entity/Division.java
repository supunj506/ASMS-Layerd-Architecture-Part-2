package lk.ijse.asms.entity;

public class Division implements SuperEntity {
    private String id;
    private String job;

    public Division() {
    }

    public Division(String id, String job) {
        this.setId(id);
        this.setJob(job);
    }

    @Override
    public String toString() {
        return "Division{" +
                "id='" + id + '\'' +
                ", job='" + job + '\'' +
                '}';
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
