package nuc.ss.domain;

public class SystemController {
    private String username; //账号
    private String password; //密码

    public SystemController() {
    }

    public SystemController(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SystemController{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
