/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:DeleteServlet
 * Time:2019/10/821:01
 * Description:
 */
package controller;

import service.UserService;
import service.serviceImple.UserServiceImple;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
        String delId = request.getParameter("delId");
        Integer del_Id=null;
        if (delId != null) {
            del_Id=new Integer(delId);
        }
        UserService service= new UserServiceImple();
        service.delUser(del_Id);
        response.sendRedirect("/ces2_0_war_exploded/query");
    }
}
