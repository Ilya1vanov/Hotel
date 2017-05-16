package spittr.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Ilya Ivanov
 */
@Controller
public class AdminController {
    private static final Logger log = Logger.getLogger(AdminController.class);

    @RequestMapping(value="/admin", method=RequestMethod.GET)
    public String adminMethodSecured() {
        log.debug("SecurityController adminMethodSecured() is called with ROLE_ADMIN");
        return "/admin";

    }
}
