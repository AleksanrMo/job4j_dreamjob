package ru.servlet;
import ru.store.Store;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CandidateDeleteServlet extends HttpServlet {


   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        Store.instOf().deleteCandidate(Integer.parseInt(id));
        File file = new File("C:\\images\\" + id + ".jpg");
        if (file.exists()) {
           Files.delete(file.toPath());
        }

        resp.sendRedirect(req.getContextPath() + "/candidate.do");
    }
}
