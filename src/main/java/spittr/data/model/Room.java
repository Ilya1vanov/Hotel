package spittr.data.model;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.util.List;

/**
 * @author Ilya Ivanov
 */
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;

    @Column(name = "wi_fi")
    private Boolean wiFi;



    protected Room() {}

    public Long getId() {
        return id;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
        if (booking.getRoom() != this) {
            booking.setRoom(this);
        }
    }
}
