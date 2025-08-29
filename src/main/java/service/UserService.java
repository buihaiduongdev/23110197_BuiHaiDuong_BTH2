package service;

import model.User;

public interface UserService {
    User login(String username, String password);
    User get(String username);
    User getByEmail(String email);

    void insert(User user);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);
}
