/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:QueryServlet
 * Time:2019/10/820:58
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
import java.util.List;

public class QueryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            UserService service=new UserServiceImple();
            List<User> uList = service.uList();
            request.setAttribute("uList",uList);
            request.getRequestDispatcher("/tab/tab.jsp").forward(request,response);
    }
}
