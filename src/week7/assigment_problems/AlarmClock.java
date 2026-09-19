package week7.assigment_problems;
public class AlarmClock implements Ringable {
    private final String time;
    public AlarmClock(String time){ if(time==null||time.trim().isEmpty()) throw new IllegalArgumentException("time cannot be blank"); this.time=time; }
    public String ring(){ return "Alarm ringing for "+time; }
}