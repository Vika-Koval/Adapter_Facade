package ucu.edu.ua.task1;

public class Twiteruser {

    private final String email;
    private final String country;
    private final long activeTime;

    public Twiteruser(String email, String country, long activeTime) {
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
