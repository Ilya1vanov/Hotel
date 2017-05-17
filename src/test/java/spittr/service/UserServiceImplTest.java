package spittr.service;

import org.junit.Before;
import org.junit.Test;
import spittr.data.model.User;
import spittr.data.model.UserDto;
import spittr.data.repository.UserRepository;
import spittr.data.repository.UserRoleRepository;
import spittr.service.exception.UserExistsException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Ilya Ivanov
 */
public class UserServiceImplTest {
    UserRepository userRepository = mock(UserRepository.class);

    UserRoleRepository userRoleRepository = mock(UserRoleRepository.class);

    UserDto userDto = new UserDto("first", "last", "user", "pass", "pass", "mail@mail.mail");

    User user = new User();

    UserService SUT;

    @Before
    public void setUp() throws Exception {
        SUT = new UserServiceImpl(userRepository, userRoleRepository);
    }

    @Test(expected = UserExistsException.class)
    public void registerNewUserAccountUserExistsException() throws Exception {
        when(userRepository.findByUsername(userDto.getUsername())).thenReturn(user);
        SUT.registerNewUserAccount(userDto);
    }

    @Test
    public void registerNewUserAccount() throws Exception {
        when(userRepository.findByUsername(userDto.getUsername())).thenReturn(null);
        SUT.registerNewUserAccount(userDto);

        verify(userRepository).findByUsername(userDto.getUsername());
    }

}