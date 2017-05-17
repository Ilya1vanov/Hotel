package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
@RequestMapping(value = {"/"})
public class IndexController {
    private static final Logger log = Logger.getLogger(IndexController.class);

    @Autowired private MessageSource messageSource;

    @RequestMapping(value = {"/"}, method = GET)
    public String redirectIndex() {
        return "redirect:/index";
    }

    @RequestMapping(value = {"/index"}, method = GET)
    public String index() {
//        final String message = messageSource.getMessage("firstName.size", null, LocaleContextHolder.getLocale());
//        log.debug(message);
        log.debug(LocaleContextHolder.getLocale());
        return "index";
    }
}