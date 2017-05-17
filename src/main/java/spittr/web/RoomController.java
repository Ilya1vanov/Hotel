package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spittr.data.model.Room;
import spittr.data.repository.RoomRepository;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Ilya Ivanov
 */
@Controller
@RequestMapping(value = {"/rooms"})
public class RoomController {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @RequestMapping(method = GET)
    public String room(Model model) {
        final List<Room> all = roomRepository.findAll();
        model.addAttribute("rooms", all);
        return "rooms";
    }
}
