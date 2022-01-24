package ru.servlet;

import ru.model.Candidate;
import ru.store.Store;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


    public class CandidateServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            Store.instOf().save(new Candidate(Integer.valueOf(req.getParameter("id")),  req.getParameter("name")));
            resp.sendRedirect(req.getContextPath() + "/candidates.jsp");
        }
    }

