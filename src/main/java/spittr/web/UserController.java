package spittr.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import spittr.data.model.User;
import spittr.data.model.UserDto;
import spittr.service.UserService;
import spittr.service.exception.EmailExistsException;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Ilya Ivanov
 */
@Controller
@RequestMapping(value = {"/"})
public class UserController {
    private static final Logger log = Logger.getLogger(UserController.class);

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/registration", method = GET)
    public String register(Model model) {
        model.addAttribute("user", UserDto.PLACEHOLDER);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = POST)
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDto accountDto, BindingResult result, WebRequest request, Errors errors) {
        User registered = null;
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        if (result.hasErrors()) {
            return new ModelAndView("registration", "user", accountDto);
        }
        else {
            return new ModelAndView("successRegister", "user", accountDto);
        }
    }

    private User createUserAccount(UserDto accountDto, BindingResult result) {
        try {
            return service.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            return null;
        }
    }

    @RequestMapping(value = "/registration", method = POST)
    public String processRegistration(@Valid User user, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "registration";
        }

        log.debug("New user: " + user);
        model.addAttribute("success", "");
        return "registration";
    }
}
