package main.java.com.ceng431.G23_CENG431_HW1.Service;

import main.java.com.ceng431.G23_CENG431_HW1.Entity.User;

public interface IUserService {
    User createUser(String username, String password);
}
