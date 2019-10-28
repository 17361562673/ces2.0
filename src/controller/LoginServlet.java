/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:LoginServlet
 * Time:2019/10/2111:03
 * Description:
 */
package controller;

import model.User;
import service.UserService;
import service.serviceImple.UserServiceImple;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service=new UserServiceImple();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = service.getUserByNameAndPassword(username, password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            String cpath = req.getContextPath();
            resp.sendRedirect(cpath + "/ces/main.jsp");
        } else {
            resp.getWriter().write("用户名或者密码错误");
        }
    }
}
