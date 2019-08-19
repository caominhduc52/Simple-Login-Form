package Controller;

import Bean.Users;
import DAO.LoginDAO;
import DB.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = DBConnection.getConnection();
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Login.jsp");
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");

        Users users = new Users();
        users.setUserName(userName);
        users.setPassWord(passWord);

        boolean usersList = LoginDAO.check(users);
        String message = "";
        if (usersList) {
            message = "Login Success";
            request.setAttribute("Message", message);
            rd.forward(request, response);
        } else {
            message = "Login Failed";
            request.setAttribute("Message", message);
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
