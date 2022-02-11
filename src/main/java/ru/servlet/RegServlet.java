package ru.servlet;

import ru.model.User;
import ru.store.DbStore;
import ru.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Store store = DbStore.instOf();
        User user = null;
        if (store.findUserByEmail(req.getParameter("email")) != null) {
            req.setAttribute("error", "Пользователь с указанным email уже зарегистрирован");
            req.getRequestDispatcher("reg.jsp").forward(req, resp);

        } else {
            user = new User(0, req.getParameter("name"), req.getParameter("email"), req.getParameter("password"));
            store.save(user);
            resp.sendRedirect("login.jsp");
        }
    }
    }

