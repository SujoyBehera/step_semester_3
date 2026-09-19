package week7.assigment_problems;
public class ScoutDrone extends Drone {
    public ScoutDrone(String id){ super(id); }
    public String fly(){ return getId()+" scouting the area"; }
}