package ru.servlet;

import ru.model.Post;
import ru.store.DbStore;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("posts", DbStore.instOf().findAllPosts());
        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.getRequestDispatcher("posts.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        DbStore.instOf().save(
                new Post(
                        Integer.valueOf(req.getParameter("id")),
                        req.getParameter("name"), req.getParameter("description")
                )
        );
        resp.sendRedirect(req.getContextPath() + "/posts.do");
    }

}
