package lk.ijse.asms.dto;

public class UserDTO {
    private String id;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String id, String password) {
        this.id = id;
        this.password = password;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
