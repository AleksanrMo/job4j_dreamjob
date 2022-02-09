package ru.store;

import ru.model.Candidate;
import ru.model.Post;
import ru.model.User;

import java.util.Collection;

public interface Store {

    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    void save(Post post);

    void save(Candidate post);

    void save(User user);

    User findUserByEmail(String email);

    Post findById(int id);

    Candidate findCandidateById(int id);

    boolean deleteCandidate(int id);

    boolean deletePost(int id);




}
