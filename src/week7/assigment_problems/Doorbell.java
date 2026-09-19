package week7.assigment_problems;
public class Doorbell implements Ringable {
    private final String location;
    public Doorbell(String location){ if(location==null||location.trim().isEmpty()) throw new IllegalArgumentException("location cannot be blank"); this.location=location; }
    public String ring(){ return "Doorbell ringing at "+location; }
}