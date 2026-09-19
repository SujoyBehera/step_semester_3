package week7.assigment_problems;
public class DeliveryDrone extends Drone implements Trackable {
    public DeliveryDrone(String id){ super(id); }
    public String fly(){ return getId()+" delivering package"; }
    public String getLocation(){ return getId()+" at Sector 4"; }
}