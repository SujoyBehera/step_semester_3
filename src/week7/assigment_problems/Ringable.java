package week7.assigment_problems;

public interface Ringable { String ring(); }

class AlarmClock implements Ringable {
    private final String time;
    public AlarmClock(String time) { if (time == null || time.trim().isEmpty()) throw new IllegalArgumentException("time cannot be blank"); this.time = time; }
    @Override public String ring() { return "Alarm ringing for " + time; }
}

class Doorbell implements Ringable {
    private final String location;
    public Doorbell(String location) { if (location == null || location.trim().isEmpty()) throw new IllegalArgumentException("location cannot be blank"); this.location = location; }
    @Override public String ring() { return "Doorbell ringing at " + location; }
}

class RingOperations {
    public static void ringAll(Ringable[] devices) {
        if (devices == null) return;
        for (Ringable device : devices) if (device != null) System.out.println(device.ring());
    }
}