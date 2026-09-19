package week7.assigment_problems;
public class Tablet extends ClassroomDevice implements Chargeable {
    private final String assetTag;
    public Tablet(String assetTag){ if(assetTag==null||assetTag.trim().isEmpty()) throw new IllegalArgumentException("assetTag cannot be blank"); this.assetTag=assetTag; }
    public String operate(){ return "Tablet "+assetTag+" displaying lesson"; }
    public String charge(){ return assetTag+" charging"; }
    public String charge(int minutes){ if(minutes<0) throw new IllegalArgumentException("minutes cannot be negative"); return assetTag+" charging for "+minutes+" minutes"; }
}