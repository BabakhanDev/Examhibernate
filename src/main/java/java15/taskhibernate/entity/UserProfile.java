package java15.taskhibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;
    private String username;
    private String email;
    private LocalDate registrationDate;

    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private UserDetails userDetails;

    public UserProfile(String username123, String mail, LocalDate now) {

    }
}
