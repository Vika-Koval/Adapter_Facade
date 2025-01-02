package ucu.edu.ua.task1;

public class TwiterUser {

    private final String email;
    private final String country;
    private final long activeTime;

    public TwiterUser(String email, String country, long activeTime) {
        this.email = email;
        this.country = country;
        this.activeTime = activeTime;
    }
    
    public String getUserEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public long getLastActiveTime() {
        return activeTime;
    }
}
