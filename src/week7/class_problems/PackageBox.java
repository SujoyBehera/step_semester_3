package week7.class_problems;
public class PackageBox implements Printable {
    private final String trackingId;
    public PackageBox(String trackingId){ if(trackingId==null||trackingId.trim().isEmpty()) throw new IllegalArgumentException("trackingId cannot be blank"); this.trackingId=trackingId; }
    public String printLabel(){ return "Package label: "+trackingId; }
}