package ucu.edu.ua.task2;

public class DBadapter {
    private final Базаданих db;

    public DBadapter() {
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