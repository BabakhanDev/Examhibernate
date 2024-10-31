package java15.taskhibernate.service;

import java15.taskhibernate.entity.UserDetails;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface UserDetailService {
    void createUserDetails(Long userId, UserDetails userDetails);
    UserDetails getUserDetailsById(Long id);
    void updateUserDetailsAddress(Long userId, String newAddress);
    void deleteUserDetails(Long userId);
    List<UserDetails> getUserByAddress(String address);
    List<UserDetails> sortUsersByDateOfBirth();


}
