package week7.assigment_problems;
public final class RingOperations {
    private RingOperations(){}
    public static void ringAll(Ringable[] devices){ if(devices==null)return; for(Ringable device:devices) if(device!=null) System.out.println(device.ring()); }
}