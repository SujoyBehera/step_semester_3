package week7.assigment_problems;
public abstract class Drone {
    private final String id;
    protected Drone(String id){ if(id==null||id.trim().isEmpty()) throw new IllegalArgumentException("id cannot be blank"); this.id=id; }
    protected String getId(){ return id; }
    public abstract String fly();
}