package week7.assigment_problems;
public final class TrackingOperations {
    private TrackingOperations(){}
    public static String getLocationIfTrackable(Object object){
        if(object instanceof Trackable) return ((Trackable)object).getLocation();
        return "Tracking not available";
    }
}