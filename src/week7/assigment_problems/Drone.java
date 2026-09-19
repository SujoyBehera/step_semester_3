package week7.assigment_problems;

public abstract class Drone {
    private final String id;
    protected Drone(String id) { if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("id cannot be blank"); this.id = id; }
    protected String getId() { return id; }
    public abstract String fly();
}

interface Trackable { String getLocation(); }

class DeliveryDrone extends Drone implements Trackable {
    public DeliveryDrone(String id) { super(id); }
    @Override public String fly() { return getId() + " delivering package"; }
    @Override public String getLocation() { return getId() + " at Sector 4"; }
}

class ScoutDrone extends Drone {
    public ScoutDrone(String id) { super(id); }
    @Override public String fly() { return getId() + " scouting the area"; }
}

class GroundRobot implements Trackable {
    private final String id;
    public GroundRobot(String id) { if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("id cannot be blank"); this.id = id; }
    @Override public String getLocation() { return id + " at Sector 4"; }
}

class TrackingOperations {
    public static String getLocationIfTrackable(Object object) {
        if (object instanceof Trackable) return ((Trackable) object).getLocation();
        return "Tracking not available";
    }
}