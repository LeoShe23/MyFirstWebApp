package app.servlets;

import app.entities.Role;
import app.entities.User;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Model model = Model.getInstance();
        List<Role> roles = model.getRoleList();
        req.setAttribute("roles", roles);

        RequestDispatcher dispatcher = req.getRequestDispatcher("views/add.jsp");
        dispatcher.forward(req, resp);
//        PrintWriter writer = resp.getWriter();
//        writer.println("Hello! Im add servlet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setName(req.getParameter("name"));
        user.setPass(req.getParameter("pass"));
        user.setType(req.getParameter("roles"));

        Model.getInstance().addUser(user);
        req.setAttribute("userName", user.getName());

        doGet(req, resp);
    }
}
