package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ilya Ivanov
 */
@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView("error");
        String description;
        Integer httpErrorCode = getErrorCode(req);
        if (httpErrorCode == null)
            httpErrorCode = 500;

        switch (httpErrorCode) {
            case 400: {
                description = "Bad Request";
                break;
            }
            case 403: {
                description = "It looks like you don't have rights to access this page";
                break;
            }
            case 404: {
                description = "It looks like we don't have this page";
                break;
            }
            case 500: {
                description = "Internal Server Error. We have already started fixing it.";
                break;
            }
            default:
                description = "Unknown error";
        }
        mav.addObject("description", description);
        mav.addObject("code", httpErrorCode);
        mav.addObject("exception", e);
        return mav;
    }

    private Integer getErrorCode(HttpServletRequest httpRequest) {
        return httpRequest != null ? (Integer) httpRequest.getAttribute("javax.servlet.error.status_code") : null;
    }
}