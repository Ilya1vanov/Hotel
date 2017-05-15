package spittr.data.model;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @author Ilya Ivanov
 */
@Entity
@Table(name="user_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_role_id")
    private Long userRoleId;

    @Column(name="username")
    private String username;

    @Column(name="role")
    private GrantedAuthority role;

    private UserRole() {
    }

    public UserRole(String username, GrantedAuthority role) {
        this.username = username;
        this.role = role;
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

    public GrantedAuthority getRole() {
        return role;
    }

    public void setRole(GrantedAuthority role) {
        this.role = role;
    }
}
