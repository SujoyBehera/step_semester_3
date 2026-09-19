package week7.assigment_problems;
public class GroundRobot implements Trackable {
    private final String id;
    public GroundRobot(String id){ if(id==null||id.trim().isEmpty()) throw new IllegalArgumentException("id cannot be blank"); this.id=id; }
    public String getLocation(){ return id+" at Sector 4"; }
}