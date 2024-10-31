package java15.taskhibernate.service.impl;

import java15.taskhibernate.dao.UserProfileDao;
import java15.taskhibernate.dao.impl.UserProfileDaoImpl;
import java15.taskhibernate.entity.UserProfile;
import java15.taskhibernate.service.UserProfileService;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class UserProfilServiceImpl implements UserProfileService {
    private final UserProfileDao userProfileDao = new UserProfileDaoImpl();
    @Override
    public void createUserProfile(UserProfile userProfile) {
        userProfileDao.createUserProfile(userProfile);
    }

    @Override
    public UserProfile getUserProfileById(Long id) {
        return userProfileDao.getUserProfileById(id);
    }

    @Override
    public void updateUserProfileEmail(Long id, String newEmail) {
userProfileDao.updateUserProfileEmail(id, newEmail);
    }

    @Override
    public void deleteUserProfile(Long id) {
userProfileDao.deleteUserProfile(id);
    }

    @Override
    public UserProfile findUserByEmail(String email) {
        return  userProfileDao.findUserByEmail(email);
    }

    @Override
    public List<UserProfile> getUsersRegisteredAfterDate(LocalDate date) {
        return userProfileDao.getUsersRegisteredAfterDate(date);
    }

}
