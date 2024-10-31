package java15.taskhibernate.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java15.taskhibernate.config.DatabaseConnection;
import java15.taskhibernate.dao.UserProfileDao;
import java15.taskhibernate.entity.UserProfile;
import java.time.LocalDate;
import java.util.List;

public class UserProfileDaoImpl implements UserProfileDao, AutoCloseable {
    private EntityManager em = DatabaseConnection.getEntityManager().createEntityManager();


    @Override
    public void createUserProfile(UserProfile userProfile) {
        em.getTransaction().begin();
        try {
            em.persist(userProfile);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserProfile getUserProfileById(Long id) {
        try {
            em.getTransaction().begin();
            UserProfile userProfile = em.find(UserProfile.class, id);
            em.getTransaction().commit();
            return userProfile;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUserProfileEmail(Long id, String newEmail) {
        em.getTransaction().begin();
        UserProfile userProfile = em.find(UserProfile.class, id);
        if (userProfile != null) {
            userProfile.setEmail(newEmail);
            em.merge(userProfile);
        }
        em.getTransaction().commit();
    }

    @Override
    public void deleteUserProfile(Long id) {
        em.getTransaction().begin();
        UserProfile userProfile = em.find(UserProfile.class, id);
        if (userProfile != null) {
            em.remove(userProfile);
        }
        em.getTransaction().commit();
    }

    @Override
    public UserProfile findUserByEmail(String email) {
        TypedQuery<UserProfile> query = em.createQuery("SELECT u FROM UserProfile u WHERE u.email = :email", UserProfile.class);
        query.setParameter("email", email);
        UserProfile userProfile = null;
        try {
            userProfile = query.getSingleResult();
        } catch (Exception e) {
            System.out.println("User not found with email: " + email);
        }
        em.close();
        return userProfile;
    }

    @Override
    public List<UserProfile> getUsersRegisteredAfterDate(LocalDate date) {
        TypedQuery<UserProfile> query = em.createQuery("SELECT u FROM UserProfile u WHERE u.registrationDate > :date", UserProfile.class);
        query.setParameter("date", date);
        List<UserProfile> users = query.getResultList();
        em.close();
        return users;
    }

    @Override
    public void close() throws Exception {
        em.close();
    }
}