package ucu.edu.ua.task1;

public class Twiteruseradapter implements User {

    private final TwiterUser twiterUser;

    public Twiteruseradapter(TwiterUser twiterUser) {
        this.twiterUser = twiterUser;
    }

    @Override
    public String getEmail() {
        return twiterUser.getUserEmail();
    }

    @Override
    public String getCountry() {
        return twiterUser.getCountry();
    }

    @Override
    public long getLastActiveTime() {
        return twiterUser.getLastActiveTime();
    }
    
}