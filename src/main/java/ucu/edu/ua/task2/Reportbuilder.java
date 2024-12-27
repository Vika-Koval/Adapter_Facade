package ucu.edu.ua.task2;

public class Reportbuilder {
    private final DBadapter db;

    public Reportbuilder(DBadapter db) {
        this.db = db;
    }

    public String buildReport() {

        String out = "Building report...\n";
        out += "User data: " + db.getUserData() + '\n';
        out += "Statistical data: " + db.getStatisticalData() + '\n';

        return out;
    }
}
