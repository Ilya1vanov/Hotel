package spittr.data.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Ilya Ivanov
 */
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="room_id")
    private Room room;

    @Temporal(TemporalType.DATE)
    @Column(name = "from_date")
    private Date from;

    @Temporal(TemporalType.DATE)
    @Column(name = "to_date")
    private Date to;

    private Booking() {}

    public Booking(User owner, Date from, Date to) {
        this.owner = owner;
        this.from = from;
        this.to = to;
    }

    public Long getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
        if (!owner.getBookings().contains(this)) {
            // this may cause performance issues if you have a large data set since this operation is O(n)
            owner.getBookings().add(this);
        }
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
        if (!room.getBookings().contains(this)) {
            // this may cause performance issues if you have a large data set since this operation is O(n)
            room.getBookings().add(this);
        }
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }
}
