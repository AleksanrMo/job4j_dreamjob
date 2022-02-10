package ru.servlet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.model.Candidate;
import ru.store.DbStore;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


class CandidateServletTest {

    @Test
    public void whenCreateCandidate() throws IOException, ServletException {
        HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse resp = Mockito.mock(HttpServletResponse.class);
        Mockito.when(req.getParameter("id")).thenReturn("0");
        Mockito.when(req.getParameter("name")).thenReturn("Andrey");
        new CandidateServlet().doPost(req, resp);
        Candidate candidate = DbStore.instOf().findCandidateById(1);
        Assertions.assertFalse(candidate.getName().isEmpty());
        Assertions.assertEquals("Andrey", candidate.getName());
    }

}