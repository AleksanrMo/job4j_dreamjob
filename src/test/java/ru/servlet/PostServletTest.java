package ru.servlet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.model.Post;
import ru.store.DbStore;
import ru.store.Store;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
}