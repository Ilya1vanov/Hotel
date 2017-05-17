package spittr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spittr.data.model.User;
import spittr.data.model.UserDto;
import spittr.data.model.UserRole;
import spittr.data.repository.UserRepository;
import spittr.data.repository.UserRoleRepository;
import spittr.service.exception.UserExistsException;

/**
 * @author Ilya Ivanov
 */
@Service
public class UserServiceImpl implements UserService {
    private static final GrantedAuthority USER_AUTH = new SimpleGrantedAuthority("ROLE_USER");

    private static final GrantedAuthority ADMIN_AUTH = new SimpleGrantedAuthority("ROLE_ADMIN");

    private final UserRepository userRepository;

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto) throws UserExistsException {
        if (usernameExist(accountDto.getUsername())) {
            throw new UserExistsException("There is an account with that username:  + accountDto.getUsername()");
        }
        User user = new User();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setUsername(accountDto.getUsername());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
        UserRole role = new UserRole(user.getUsername(), USER_AUTH.getAuthority(), user);
        user.addRole(role);
        userRoleRepository.save(role);
        return userRepository.save(user);
    }

    private boolean usernameExist(String username) {
        return userRepository.findByUsername(username) != null;
    }
}
