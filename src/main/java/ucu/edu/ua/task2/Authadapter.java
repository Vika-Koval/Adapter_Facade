package ucu.edu.ua.task2;

public class Authadapter {
    private final Авторизація auth;

    public Authadapter() {
        this.auth = new Авторизація();
    }

    public boolean authenticate(DBadapter db) {
        return auth.авторизуватися(db.getSrc());
    }

}