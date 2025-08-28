package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class User implements Serializable {
    private int id;
    private String userName;
    private String passWord;
    private String email;
    private String fullName;
    private String phone;
    private String avatar;
    private int roleId;
    private Date createdDate;

    public User() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPassWord() { return passWord; }
    public void setPassWord(String passWord) { this.passWord = passWord; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }

    public int getRoleId() { return roleId; }
    public void setRoleId(int roleId) { this.roleId = roleId; }

    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }
}
