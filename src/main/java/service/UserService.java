package service;

import model.User;

public interface UserService {
    User login(String username, String password);
    User get(String username);
    void insert(User user);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);
}
