package lk.ijse.asms.view.tm;

public class TeamTM {
    private String id;
    private String name;
    private String division;

    public TeamTM() {
    }

    public TeamTM(String id, String name, String division) {
        this.id = id;
        this.name = name;
        this.division = division;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", division='" + division + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
