package ucu.edu.ua.task1;

public class Facebookuseradapter  implements User{
    private final Facebookuser facebookUser;

    public Facebookuseradapter(Facebookuser facebookUser) {
        this.facebookUser = facebookUser;
    }

    @Override
    public String getEmail() {
        return facebookUser.getEmail();
    }

    @Override
    public String getCountry() {
        return facebookUser.getUserCountry();
    }

    @Override
    public long getLastActiveTime() {
        return facebookUser.getUserActiveTime();
    }
    
}