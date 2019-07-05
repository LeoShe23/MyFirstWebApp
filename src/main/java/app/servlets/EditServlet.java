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
import java.io.PrintWriter;
import java.util.List;

public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter writer = resp.getWriter();
//        writer.println("Hello! Im edit servlet");

        Model model = Model.getInstance();
        User user = model.getUserById(Integer.parseInt(req.getParameter("userID")));
        req.setAttribute("user", user);

        List<Role> roles = model.getRoleList();
        req.setAttribute("roles", roles);

        RequestDispatcher dispatcher = req.getRequestDispatcher("views/edit.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setName(req.getParameter("name"));
        user.setPass(req.getParameter("pass"));
        user.setType(req.getParameter("roles"));
        user.setId(Integer.parseInt(req.getParameter("userID")));
        System.out.println(user);

        Model.getInstance().updateUser(user);
        req.setAttribute("userName", user.getName());

        doGet(req, resp);
    }
}
