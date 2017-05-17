package spittr.data.model;


import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;

/**
 * @author Ilya Ivanov
 */
@Entity
@Table(name = "user_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_role_id")
    private Long userRoleId;

    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private UserRole() {
    }

    public UserRole(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public UserRole(String username, String role, User user) {
        this.username = username;
        this.role = role;
        setUser(user);
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        if (this.user != null) {
            if (!user.getRoles().contains(this)) {
                // this may cause performance issues if you have a large data set since this operation is O(n)
                user.addRole(this);
            }
        }
    }
}
