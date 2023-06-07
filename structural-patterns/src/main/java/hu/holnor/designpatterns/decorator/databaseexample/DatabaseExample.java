package hu.holnor.designpatterns.decorator.databaseexample;

/*
* A kávézós példa alapján próbáld értelmezni az alábbi sorokat!
* */


interface Database {
    void query(String sql);
    void update(String sql);
}

class ConcreteDatabase implements Database {
    public void query(String sql) {
        System.out.println("Adatbázis lekérdezés: " + sql);
        // Implementálás
    }

    public void update(String sql) {
        System.out.println("Adatbázis módosítás: " + sql);
        // Implementálás
    }
}

abstract class DatabaseDecorator implements Database {
    protected Database decoratedDatabase;

    public DatabaseDecorator(Database decoratedDatabase) {
        this.decoratedDatabase = decoratedDatabase;
    }

    public void query(String sql) {
        decoratedDatabase.query(sql);
    }

    public void update(String sql) {
        decoratedDatabase.update(sql);
    }
}

class LoggingDatabaseDecorator extends DatabaseDecorator {
    public LoggingDatabaseDecorator(Database decoratedDatabase) {
        super(decoratedDatabase);
    }

    public void query(String sql) {
        System.out.println("Naplózás - Adatbázis lekérdezés: " + sql);
        super.query(sql);
    }

    public void update(String sql) {
        System.out.println("Naplózás - Adatbázis módosítás: " + sql);
        super.update(sql);
    }
}

public class DatabaseExample {
    public static void main(String[] args) {
        Database database = new ConcreteDatabase();
        Database loggingDatabase = new LoggingDatabaseDecorator(database);

        loggingDatabase.query("SELECT * FROM users");
        loggingDatabase.update("UPDATE products SET price = 10.0 WHERE id = 1");
    }
}
