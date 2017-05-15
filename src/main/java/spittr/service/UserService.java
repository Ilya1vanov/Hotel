package spittr.service;

import spittr.data.model.User;
import spittr.data.model.UserDto;
import spittr.service.exception.EmailExistsException;

/**
 * @author Ilya Ivanov
 */
public interface UserService {
    User registerNewUserAccount(UserDto accountDto) throws EmailExistsException;
}
