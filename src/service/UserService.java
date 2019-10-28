package service;

import model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public void delUser(Integer user_id);
    public void updateUser(User user);
    public User getUser(Integer user_id);
    public List<User> uList();
    public User getUserByNameAndPassword(String username,String password);
}
