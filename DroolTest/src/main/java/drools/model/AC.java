package drools.model;

/**
 * Created by 604418 on 5/24/2017.
 */
public class AC {
    private Room room;
    private Boolean condition;
    private Boolean on;

    public AC(Room room, Boolean condition, Boolean on) {
        this.room = room;
        this.condition = condition;
        this.on=on;
    }

    public AC() {
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Boolean getCondition() {
        return condition;
    }

    public void setCondition(Boolean condition) {
        this.condition = condition;
    }

    public Boolean getOn() {
        return on;
    }

    public void setOn(Boolean on) {
        this.on = on;
    }
}
