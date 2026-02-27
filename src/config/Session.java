package config;

public class Session {
    private static Session instance;
    private String uid;
    private String name;
    private String email;
    private String status;

    private Session() { }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public String getUid() { return uid; }
    public void setUid(String uid) { this.uid = uid; }
   
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
   
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
   
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
