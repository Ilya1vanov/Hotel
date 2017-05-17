package spittr.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import spittr.data.model.Booking;
import spittr.data.model.Room;
import spittr.data.model.User;
import spittr.data.repository.BookingRepository;
import spittr.data.repository.RoomRepository;
import spittr.data.repository.UserRepository;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Ilya Ivanov
 */

@Controller
@RequestMapping(value = {"/booking"})
public class BookingController {
    private static final Logger log = Logger.getLogger(BookingController.class);

    private final RoomRepository roomRepository;

    private final UserRepository userRepository;

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingController(RoomRepository roomRepository, UserRepository userRepository, BookingRepository bookingRepository) {
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value = "/{id}", method = GET)
    public String booking(@PathVariable("id") Long id, Authentication authentication, Model model) {
        Room one = roomRepository.findOne(id);
        User user = userRepository.findByUsername(authentication.getName());
        model.addAttribute("room", one);
        Booking booking = new Booking();
        booking.setOwner(user);
        booking.setRoom(one);
        model.addAttribute("booking", booking);
        return "booking";
    }

    @RequestMapping(value = "/", method = POST)
    public ModelAndView registerNewBooking(@Valid Booking booking, BindingResult result, WebRequest request, Errors errors) {
//        User registered = null;
//        if (!result.hasErrors()) {
//            registered = createUserAccount(accountDto, result);
//            if (registered == null) {
//                result.rejectValue("username", "Already exists");
//            }
//        }
//        if (result.hasErrors()) {
//            return new ModelAndView("registration", "user", accountDto);
//        }
//        else {
//            log.debug("New user: " + registered);
//            return new ModelAndView("registration", "success", "true");
//        }
        System.out.println("POST");
        bookingRepository.save(booking);
        return null;
    }
}
