package drools.model;

/**
 * Created by 604418 on 5/24/2017.
 */
public class Room {
    private String name;
    private double temp;

    public Room(String name, double temp) {
        this.name = name;
        this.temp = temp;
    }

    public Room() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    public boolean equals(Room room) {
        return this.name.equals(room.getName());
    }
}
