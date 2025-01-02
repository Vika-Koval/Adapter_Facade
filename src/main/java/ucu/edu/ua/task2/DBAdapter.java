package ucu.edu.ua.task2;

public class DBAdapter {
    private final Базаданих db;

    public DBAdapter() {
        this.db = new Базаданих();
    }

    public String getUserData() {
        return db.отриматиДаніКористувача();
    }

    public String getStatisticalData() {
        return db.отриматиСтатистичніДані();
    }

    public Базаданих getSrc() {
        return db;
    }
}