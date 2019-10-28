/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:QuerySingle
 * Time:2019/10/822:41
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
import java.io.IOException;
import java.lang.ref.ReferenceQueue;

public class QuerySingle extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id");
        Integer userid=null;
        if (user_id!=null) {
            userid = new Integer(user_id);
        }
        UserService service=new UserServiceImple();
        User user = service.getUser(userid);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/tab/toUpdate.jsp").forward(request,response);
    }
}
