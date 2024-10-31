package java15.taskhibernate.service;
import java15.taskhibernate.entity.UserProfile;
import java.time.LocalDate;
import java.util.List;

public interface UserProfileService {
    void createUserProfile(UserProfile userProfile);
    UserProfile getUserProfileById(Long id);
    void updateUserProfileEmail(Long id, String newEmail);
    void deleteUserProfile(Long id);
    UserProfile findUserByEmail(String email);
    List<UserProfile> getUsersRegisteredAfterDate(LocalDate date);

}
