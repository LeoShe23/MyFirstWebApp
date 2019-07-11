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
    Model model;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        model = Model.getInstance();
        List<User> users = model.selectUsersAndRoles();
        req.setAttribute("userNames", users);

        RequestDispatcher dispatcher = req.getRequestDispatcher("views/list.jsp");
        dispatcher.forward(req, resp);

        String action=req.getParameter("action");//создаём action который будет реагировать на те или иные действия
        if(action.equalsIgnoreCase("update")){//если action отреагировал на update
            req.setAttribute("user",model.getUserById(Integer.parseInt(req.getParameter("userId"))));//создаём атрибут который по id возвращает определённого User
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("views/edit.jsp");////перебрасываемся на edit.jsp
            requestDispatcher.forward(req, resp);
        }
        if(action.equalsIgnoreCase("delete")){//если action отреагировал на delete
            doDelete(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        model = Model.getInstance();
        model.deleteUserById(Integer.parseInt(req.getParameter("userID")));//удаляем по id
        doGet(req, resp);
    }
}
