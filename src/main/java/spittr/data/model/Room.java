package spittr.data.model;

import com.google.common.collect.Lists;
import org.apache.log4j.Logger;

import javax.persistence.*;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

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

    @OneToMany(mappedBy = "room")
    private List<Description> descriptions;

    private Long price;

    public Room() {
        this(false, 0L);
    }

    public Room(Boolean wiFi, Long price) {
        this.wiFi = wiFi;
        this.price = price;
        this.bookings = Lists.newArrayList();
        this.descriptions = Lists.newArrayList();
    }

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

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Boolean getWiFi() {
        return wiFi;
    }

    public void setWiFi(Boolean wiFi) {
        this.wiFi = wiFi;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    public void addDescription(Description description) {
        this.descriptions.add(description);
        if (description.getRoom() != this) {
            description.setRoom(this);
        }
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Description getDescriptionWithLocale(Locale locale) {
        Optional<Description> any = descriptions.stream().filter(description -> description.getLocation().equals(locale.getDisplayLanguage())).findAny();
        return any.orElse(null);
    }
}
