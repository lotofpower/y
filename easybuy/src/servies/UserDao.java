package servies;

import pojo.User;
import until.BaseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    //注册
    public int add(User user) throws Exception {
        int i = 0;
        StringBuffer sb = new StringBuffer();
        sb.append("insert easybuy_user (loginName,userName,password,sex,email,mobile)values(?,?,?,?,?,?) ");
        List<Object> objects = new ArrayList<Object>();
        objects.add(user.getLoginName());
        objects.add(user.getUserName());
        objects.add(user.getPassword());
        objects.add(user.getSex());
        objects.add(user.getEmail());
        objects.add(user.getMobile());
        BaseDao baseDao = new BaseDao();
        baseDao.executeUpdate(sb.toString(), objects.toArray());
        return i;
    }

    //登录
    public  boolean isenter(HttpServletRequest request, HttpServletResponse resp) throws ServletException,IOException {
        boolean end=false;
        User user=new User();;
        resp.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        StringBuffer sb = new StringBuffer();
        sb.append("select id,userName,sex,email,mobile,loginName,password from easybuy_user where loginName=");
        sb.append(request.getParameter("loginName"));
        sb.append(" and password=");
        sb.append(request.getParameter("password"));
        ResultSet rs = null;
        BaseDao baseDao = new BaseDao();
        try {
            rs = baseDao.executeQuery(sb.toString());
        while (rs.next()) {
            end=true;
            user.setLoginName(rs.getString("loginName"));
            user.setPassword(rs.getString("password"));
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("userName"));
            user.setSex(Integer.parseInt(rs.getString("sex")));
            user.setEmail(rs.getString("email"));
            user.setMobile(rs.getString("mobile"));
            request.getSession().setAttribute("user",user);
            System.out.println("123456");
        }}catch (Exception E){

    }
        return end;
    }
}