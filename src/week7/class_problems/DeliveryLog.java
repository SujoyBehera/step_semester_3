package week7.class_problems;
public final class DeliveryLog {
    private DeliveryLog(){}
    public static void logAll(DeliveryNote[] notes){ if(notes==null)return; for(DeliveryNote note:notes) if(note!=null) System.out.println(note.confirmDelivery()); }
}