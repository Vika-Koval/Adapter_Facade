package ucu.edu.ua.task2;

public class Авторизація {
    public boolean авторизуватися(Базаданих db) {
        db.отриматиДаніКористувача();
        return true;
    }
}
