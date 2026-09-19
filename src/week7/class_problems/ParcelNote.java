package week7.class_problems;
public class ParcelNote extends DeliveryNote {
    private final String trackingId;
    public ParcelNote(String trackingId){ if(trackingId==null||trackingId.trim().isEmpty()) throw new IllegalArgumentException("trackingId cannot be blank"); this.trackingId=trackingId; }
    public String confirmDelivery(){ return "Parcel "+trackingId+" delivered"; }
}