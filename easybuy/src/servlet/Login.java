package servlet;

import pojo.User;
import servies.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        UserDao userDao=new UserDao();
        boolean isenter=userDao.isenter(request,response);
        if(isenter==true){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else {
            PrintWriter out=response.getWriter();
            if (request.getParameter("loginName")==null||request.getParameter("password")==null)
            {
                out.println("<script> setTimeout(function(){location.href='Login.jsp'},1)</script>");
            }else {
                out.println("<script> alert('账号或密码错误');  setTimeout(function(){location.href='Login.jsp'},1)</script>");
            }
            request.getSession().invalidate();
            out.close();
        }

    }
}