package ru.store;

import ru.model.Post;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Store {

    private static final Store INST = new Store();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private Store() {
        posts.put(1, new Post(1, "Junior Java Job", "Без опыта."));
        posts.put(2, new Post(2, "Middle Java Job", "1 - 3 лет опыта."));
        posts.put(3, new Post(3, "Senior Java Job", "Опыт более 3х лет"));
    }

    public static Store instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }
}
