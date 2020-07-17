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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Regist")
public class Regist extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user=new User();
        //获取表单值
        user.setLoginName(request.getParameter("loginName"));
        user.setUserName(request.getParameter("userName").toString());
        user.setPassword((String) request.getParameter("password"));
        user.setMobile(request.getParameter("mobile").toString());
        user.setEmail(request.getParameter("email").toString());
        user.setSex(Integer.parseInt(request.getParameter("sex")));
        UserDao userDao=new UserDao();
        int i=0;
        try {
            i=userDao.add(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
