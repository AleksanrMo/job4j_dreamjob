package ru.servlet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.internal.util.DefaultMockingDetails;
import ru.model.Post;
import ru.store.DbStore;
import ru.store.Store;
import static org.mockito.Mockito.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



class PostServletTest {

        @Test
        public void whenCreatePost() throws IOException, ServletException {
            HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
            HttpServletResponse resp = Mockito.mock(HttpServletResponse.class);
            Mockito.when(req.getParameter("id")).thenReturn("0");
            Mockito.when(req.getParameter("name")).thenReturn("New post");
            new PostServlet().doPost(req, resp);
            Store store = DbStore.instOf();
            Post post = store.findById(1);
            Assertions.assertFalse(post.getName().isEmpty());
            Assertions.assertEquals("New post", post.getName());
        }

    @Test
    public void whenGetResponseSuccess() throws ServletException, IOException {
        HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse resp = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        Mockito.when(req.getSession()).thenReturn(session);
        RequestDispatcher dispatcher = Mockito.mock(RequestDispatcher.class);
        Mockito.when(req.getRequestDispatcher("posts.jsp")).thenReturn(dispatcher);
        new PostServlet().doGet(req, resp);
        req.getRequestDispatcher("posts.jsp");
    }
}