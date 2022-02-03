package ru.servlet;

import ru.model.Candidate;
import ru.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CandidateDeleteServlet extends HttpServlet {


   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            Store.instOf().deleteCandidate(Integer.parseInt(id));
        }
        resp.sendRedirect(req.getContextPath() + "/candidate.do");
    }
}
