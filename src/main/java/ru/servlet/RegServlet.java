package ru.servlet;

import ru.model.User;
import ru.store.DbStore;
import ru.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setId(0);
        DbStore.instOf().save(user);
        resp.sendRedirect("login.jsp");

    }
}
