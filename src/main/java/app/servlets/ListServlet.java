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

        String action=req.getParameter("action");//создаём action который будет реагировать на те или иные действия
        if(action.equalsIgnoreCase("update")){//если action отреагировал на update
            req.setAttribute("user",model.getUserById(Integer.parseInt(req.getParameter("userId"))));//создаём атрибут который по id возвращает определённого HeroesEntity
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("update.jsp");////перебрасываемся на update.jsp
            requestDispatcher.forward(req,resp);
        }
        if(action.equalsIgnoreCase("delete")){//если action отреагировал на update
            model.deleteUserById(Integer.parseInt(req.getParameter("userId")));//удаляем по id
            req.setAttribute("userNames", users);//создаём аттрибут который взял в себя всё что есть в базе данных
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("list.jsp");//перебрасываемся на list.jsp
            requestDispatcher.forward(req,resp);
        }
    }
}
