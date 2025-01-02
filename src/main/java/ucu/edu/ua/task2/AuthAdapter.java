package ucu.edu.ua.task2;

public class AuthAdapter {
    private final Авторизація auth;

    public AuthAdapter() {
        this.auth = new Авторизація();
    }

    public boolean authenticate(DBAdapter db) {
        return auth.авторизуватися(db.getSrc());
    }

}