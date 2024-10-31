package java15.taskhibernate;

import java15.taskhibernate.entity.UserDetails;
import java15.taskhibernate.entity.UserProfile;
import java15.taskhibernate.service.UserDetailService;
import java15.taskhibernate.service.UserProfileService;
import java15.taskhibernate.service.impl.UserDetailServiceImpl;
import java15.taskhibernate.service.impl.UserProfilServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {

        UserProfileService userProfileService = new UserProfilServiceImpl();
        UserDetailService userDetailService = new UserDetailServiceImpl();

         UserProfile userProfile = new UserProfile("username123", "user@example.com", LocalDate.now());
        userProfileService.createUserProfile(userProfile);

        UserDetails userDetails = new UserDetails("John Doe", LocalDate.of(1990, 5, 15), "123 Main St");
        userDetailService.createUserDetails(userProfile.getId(), userDetails);


//userDetails.setUserProfile(userProfile);
//userProfile.setUserDetails(userDetails);
//userProfileService.createUserProfile(userProfile);
//
//      
//        UserProfile foundProfile = userProfileService.findUserByEmail("user@example.com");
//        System.out.println(foundProfile);

//        System.out.println(userProfileService.getUserProfileById(1));
//        userProfileService.updateUserProfileEmail(1,"Bekkkaa@mail.ru");
//       userProfileService.findUserByEmail("Bekkkaa@mail.ru");
//        userProfileService.deleteUserProfile(1);
//        userProfileService.getUsersRegisteredAfterDate( LocalDate.of(2015,9,23));
//
//
//        //
//        userDetailService.createUserDetails(1L,"rggrtgtr",LocalDate.of(2020,10,1),"htrhtrh");
//       userDetailService.createUserDetails(2L,"aaaaaa",LocalDate.of(2025,12,1),"ddddddddddd");
//        System.out.println(userDetailService.getUserByAddress("htrhtrh"));
//        userDetailService.deleteUserDetails(1L);
//        userDetailService.updateUserDetailsAddress(1L,"Neeew");
//        System.out.println(userDetailService.sortUsersByDateOfBirth());


    }
}
