package java15.taskhibernate.service.impl;

import java15.taskhibernate.dao.UserDetailDao;
import java15.taskhibernate.dao.impl.UserDetailDaoImpl;
import java15.taskhibernate.entity.UserDetails;
import java15.taskhibernate.service.UserDetailService;
import java.util.List;

public class UserDetailServiceImpl implements UserDetailService {
    private final UserDetailDao userDetailDao = new UserDetailDaoImpl();


    @Override
    public void createUserDetails(Long userId, UserDetails userDetails) {
        userDetailDao.createUserDetails(userId, userDetails);
    }

    @Override
    public UserDetails getUserDetailsById(Long id) {

        return userDetailDao.getUserDetailsById(id);
    }

    @Override
    public void updateUserDetailsAddress(Long userId, String newAddress) {
        userDetailDao.updateUserDetailsAddress(userId, newAddress);

    }

    @Override
    public void deleteUserDetails(Long userId) {
        userDetailDao.deleteUserDetails(userId);
    }

    @Override
    public List<UserDetails> getUserByAddress(String address) {
        return userDetailDao.getUserByAddress(address);
    }

    @Override
    public List<UserDetails> sortUsersByDateOfBirth() {
        return userDetailDao.sortUsersByDateOfBirth();
    }
}
