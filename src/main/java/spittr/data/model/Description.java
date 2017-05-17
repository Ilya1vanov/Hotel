package spittr.data.model;

import org.apache.log4j.Logger;

import javax.persistence.*;

/**
 * @author Ilya Ivanov
 */
@Entity
@Table(name = "descriptions")
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "description_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "location")
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    private Description() {
    }

    public Description(String title, String text, String location) {
        this(title, text, location, null);
    }

    public Description(String title, String text, String location, Room room) {
        this.title = title;
        this.text = text;
        this.location = location;
        setRoom(room);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
        if (this.room != null) {
            if (!room.getDescriptions().contains(this)) {
                // this may cause performance issues if you have a large data set since this operation is O(n)
                room.addDescription(this);
            }
        }
    }
}
