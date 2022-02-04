package ru.store;

import ru.model.Candidate;
import ru.model.Post;

public class MainStore {

    public static void main(String[] args) {
        Store store = DbStore.instOf();
        store.save(new Post(0, "Java Job"));
        store.save(new Candidate(0, "Sergio"));
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName());
        }
        for (Candidate candidate : store.findAllCandidates()) {
            System.out.println(candidate.getId() + " " + candidate.getName());
        }
        System.out.println("-----------------------------");
        System.out.println(store.findById(1));
        System.out.println(store.findCandidateById(1));
    }
}
