/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:UserServiceImple
 * Time:2019/10/817:23
 * Description:
 */
package service.serviceImple;

import dao.UserDao;
import dao.daoImple.UserDaoImple;
import model.User;
import service.UserService;

import java.util.List;

public class UserServiceImple implements UserService {
    UserDao dao=new UserDaoImple();
    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void delUser(Integer user_id) {
        dao.delUser(user_id);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public User getUser(Integer user_id) {
        return dao.getUser(user_id);
    }

    @Override
    public List<User> uList() {
        return dao.uList();
    }

    @Override
    public User getUserByNameAndPassword(String username, String password) {
        return dao.getUserByNameAndPassword(username,password);
    }
}
