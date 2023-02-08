package lk.ijse.asms.entity;

public class Division implements SuperEntity{
    private String division_id;
    private String division_type;

    public Division() {
    }

    public Division(String division_id, String division_type) {
        this.division_id = division_id;
        this.division_type = division_type;
    }

    public String getDivision_id() {
        return division_id;
    }

    public void setDivision_id(String division_id) {
        this.division_id = division_id;
    }

    public String getDivision_type() {
        return division_type;
    }

    public void setDivision_type(String division_type) {
        this.division_type = division_type;
    }
}
