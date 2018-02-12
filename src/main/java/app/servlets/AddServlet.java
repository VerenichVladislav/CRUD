package app.servlets;

import app.entities.User;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        получаем из объекта запроса объект диспетчера запросов,
        куда передаем адрес jsp странички, которой мы хотим передать управление;
         */
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
        /*
        используя полученный объект — передаем управление в указанную jsp страницу,
        и не забываем вложить туда те объекты запроса и ответа, которые мы получили от Tomcat.
         */
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        User user = new User(name, password);
        Model model = Model.getInstance();
        model.add(user);
        req.setAttribute("userName", name);
        doGet(req, resp);
    }
}
