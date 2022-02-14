package ru.servlet;

import ru.model.Candidate;
import ru.model.City;
import ru.store.DbStore;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


    public class CandidateServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("candidates", DbStore.instOf().findAllCandidates());
            req.getRequestDispatcher("candidates.jsp").forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            DbStore.instOf().save(new Candidate(Integer.valueOf(req.getParameter("id")),  req.getParameter("name")
            , new City(Integer.parseInt(req.getParameter("city_id")))));
            resp.sendRedirect(req.getContextPath() + "/candidate.do");
        }
    }

