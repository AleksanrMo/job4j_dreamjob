package ru.store;

import ru.model.Candidate;
import ru.model.City;
import ru.model.Post;
import ru.model.User;

import java.util.Collection;

public interface Store {

    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    Collection<City> findAllCities();

    void save(Post post);

    void save(Candidate post);

    void save(User user);

    User findUserByEmail(String email);

    Post findById(int id);

    Candidate findCandidateById(int id);

    boolean deleteCandidate(int id);

    boolean deletePost(int id);

    public Collection<Post> findAllPostsInDay();

    public Collection<Candidate> findAllCandidatesInDay();

}
