package dao;

import model.User;

public interface UserDao {
    User get(String username);
    User getByEmail(String email);

    void insert(User user);
    
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);
}
