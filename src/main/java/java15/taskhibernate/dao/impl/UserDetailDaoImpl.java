package java15.taskhibernate.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java15.taskhibernate.config.DatabaseConnection;
import java15.taskhibernate.dao.UserDetailDao;
import java15.taskhibernate.entity.UserDetails;
import java15.taskhibernate.entity.UserProfile;
import java.util.List;

public class UserDetailDaoImpl implements UserDetailDao ,AutoCloseable {
    private EntityManager em = DatabaseConnection.getEntityManager().createEntityManager();


    @Override
    public void createUserDetails(Long userId, UserDetails userDetails) {
        em.getTransaction().begin();
        try {
            UserProfile userProfile = em.find(UserProfile.class, userId);
            if (userProfile == null) {
                throw new RuntimeException("UserProfile with ID " + userId + " not found");
            }
            userDetails.setUserProfile(userProfile);
            userProfile.setUserDetails(userDetails);
            em.persist(userDetails);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }}


    @Override
    public UserDetails getUserDetailsById(Long id) {
        try {
            em.getTransaction().begin();
            UserDetails userDetails = em.find(UserDetails.class, id);
            em.getTransaction().commit();
            return userDetails;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUserDetailsAddress(Long userId, String newAddress) {
        try {
            em.getTransaction().begin();
            UserDetails userDetails = em.find(UserDetails.class, userId);
                userDetails.setAddress(newAddress);
                em.merge(userDetails);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteUserDetails(Long userId) {
        try {
            em.getTransaction().begin();
            UserDetails userDetails = em.find(UserDetails.class, userId);
            if (userDetails != null) {
                em.remove(userDetails);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserDetails> getUserByAddress(String address) {
        try {
            TypedQuery<UserDetails> query = em.createQuery("SELECT u FROM UserDetails u WHERE u.address = :address", UserDetails.class);
            query.setParameter("address", address);
            List<UserDetails> users = query.getResultList();
            return users;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserDetails> sortUsersByDateOfBirth() {
        TypedQuery<UserDetails> query = em.createQuery("SELECT u FROM UserDetails u ORDER BY u.dateOfBirth", UserDetails.class);
        List<UserDetails> sortedUsers = query.getResultList();
        return sortedUsers;
    }

    @Override
    public void close() throws Exception {
        em.close();
    }
}

