package spittr.web;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

/**
 * @author Ilya Ivanov
 */
@Controller
public class AdminController {
    //JSR-250 Security
    @RolesAllowed(value={"ROLE_ADMIN"})
    @RequestMapping(value = "/adminOrSuperUserCanCall", method = RequestMethod.GET)
    public ModelAndView adminOrSuperUserCanCall() {
        System.out.println("SecurityController adminOrSuperUserCanCall() is called");
        return new ModelAndView("/security/admin");
    }

    //Spring Security
    //SpEL usage at method level security
    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('USER')")
    @RequestMapping(value="/admin", method=RequestMethod.GET)
    public ModelAndView userOrAdminCanCall() {
        System.out.println("SecurityController userOrAdminCanCall() is called with ROLE_ADMIN or ROLE_USER");
        return new ModelAndView("/security/profile");
    }

    //Spring Security
    @Secured(value={"ROLE_ADMIN"})
    @RequestMapping(value="/admin", method=RequestMethod.GET)
    public String adminMethodSecured() {
        System.out.println("SecurityController adminMethodSecured() is called with ROLE_ADMIN");
        return "/admin";

    }
}
