package week7.class_problems;
public class ToyRobot extends Toy {
    private final String name;
    public ToyRobot(String name){ super(); if(name==null||name.trim().isEmpty()) throw new IllegalArgumentException("name cannot be blank"); this.name=name; }
    public String makeSound(){ return name+": Beep boop!"; }
}