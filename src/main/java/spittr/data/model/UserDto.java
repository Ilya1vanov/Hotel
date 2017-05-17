package spittr.data.model;

import spittr.data.constraints.annotation.PasswordMatches;
import spittr.data.constraints.annotation.ValidEmail;

import javax.validation.constraints.Size;

/**
 * @author Ilya Ivanov
 */
@PasswordMatches
public class UserDto {
    public static final UserDto PLACEHOLDER = new UserDto("", "", "", "", "", "");

    @Size(min = 2, max = 30)
    private String firstName;

    @Size(min = 2, max = 30)
    private String lastName;

    @Size(min = 2, max = 30)
    private String username;

    @Size(min = 5, max = 25)
    private String password;

    @Size(min = 5, max = 25)
    private String matchingPassword;

    @ValidEmail
    private String email;

    private UserDto() {
    }

    public UserDto(String firstName, String lastName, String username, String password, String matchingPassword, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.email = email;
    }

    public static UserDto getPLACEHOLDER() {
        return PLACEHOLDER;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
