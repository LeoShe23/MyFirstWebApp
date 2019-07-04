package app.servlets;

import app.entities.User;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter writer = resp.getWriter();
//        writer.println("Hello! Im list servlet");

        Model model = Model.getInstance();
        List<User> users = model.selectUsersAndRoles();
        req.setAttribute("userNames", users);

        RequestDispatcher dispatcher = req.getRequestDispatcher("views/list.jsp");
        dispatcher.forward(req, resp);

    }
}
