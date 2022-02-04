package ru.store;

import ru.model.Candidate;
import ru.model.Post;

import java.util.Collection;

public interface Store {

    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    void save(Post post);

    void save(Candidate post);

    Post findById(int id);

    Candidate findCandidateById(int id);

}
