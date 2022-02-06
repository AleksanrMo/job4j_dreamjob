package ru.store;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.model.Candidate;
import ru.model.Post;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class DbStoreTest {
    static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = DbStoreTest.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("jdbc.driver"));
            connection = DriverManager.getConnection(
                    config.getProperty("jdbc.url"),
                    config.getProperty("jdbc.username"),
                    config.getProperty("jdbc.password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from post")) {
            statement.execute();
        }
    }

    @After
    public void wipeTable2() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from candidates")) {
            statement.execute();
        }
    }

    @After
    public void wipeTable3() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "ALTER TABLE candidates ALTER COLUMN id RESTART WITH 1")) {
            statement.execute();
        }
    }

    @After
    public void wipeTable4() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "ALTER TABLE post ALTER COLUMN id RESTART WITH 1")) {
            statement.execute();
        }
    }

    @Test
    public void whenCreatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.save(post);
        Post postInDb = store.findById(post.getId());
        Assertions.assertEquals(postInDb.getName(), (post.getName()));
    }

    @Test
    public void whenCreateCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Ivan");
        store.save(candidate);
        Candidate candidate1 = store.findCandidateById(candidate.getId());
        Assertions.assertEquals(candidate1.getName(), (candidate.getName()));
    }

    @Test
    public void whenFindAllCandidates() {
        Store store = DbStore.instOf();
        store.save(new Candidate(0, "Alex"));
        store.save(new Candidate(0, "Vasiliy"));
        Assertions.assertEquals(store.findCandidateById(1).getName(), "Alex");
        Assertions.assertEquals(store.findCandidateById(2).getName(), "Vasiliy");
    }

    @Test
    public void whenFindAllPost() {
        Store store = DbStore.instOf();
        store.save(new Post(0, "one"));
        store.save(new Post(0, "two"));
        Assertions.assertEquals(store.findById(1).getName(), "one");
        Assertions.assertEquals(store.findById(2).getName(), "two");
    }

    @Test
    public void deleteCandidate() {
        Store store =  DbStore.instOf();
        store.save(new Candidate(0, "Alex"));
        store.deleteCandidate(1);
        Assertions.assertTrue(store.findAllCandidates().isEmpty());
    }

    @Test
    public void whenFindByIdCandidate() {
        Store store =  DbStore.instOf();
        store.save(new Candidate(0, "Alex"));
        store.save(new Candidate(0, "Vasiliy"));
        String st = store.findCandidateById(1).getName();
        Assertions.assertEquals(st, "Alex");
    }

    @Test
    public void whenFindById() {
        Store store =  DbStore.instOf();
        store.save(new Post(0, "One"));
        store.save(new Post(0, "Two"));
        String st = store.findById(1).getName();
        Assertions.assertEquals(st, "One");
    }
}