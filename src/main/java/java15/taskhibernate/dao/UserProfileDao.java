package java15.taskhibernate.dao;

import java15.taskhibernate.entity.UserDetails;
import java15.taskhibernate.entity.UserProfile;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserProfileDao {
    void createUserProfile(UserProfile userProfile);
    UserProfile getUserProfileById(Long id);
    void updateUserProfileEmail(Long id, String newEmail);
    void deleteUserProfile(Long id);
    UserProfile findUserByEmail(String email);
    List<UserProfile> getUsersRegisteredAfterDate(LocalDate date);
}
