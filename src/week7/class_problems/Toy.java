package week7.class_problems;

public abstract class Toy {
    private static int nextId = 1001;
    private final String toyId;
    protected Toy() { toyId = "TOY-" + nextId++; }
    public abstract String makeSound();
    public String getToyId() { return toyId; }
}

class ToyCar extends Toy {
    private final String name;
    public ToyCar(String name) { super(); if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("name cannot be blank"); this.name = name; }
    @Override public String makeSound() { return name + ": Vroom vroom!"; }
}

class ToyRobot extends Toy {
    private final String name;
    public ToyRobot(String name) { super(); if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("name cannot be blank"); this.name = name; }
    @Override public String makeSound() { return name + ": Beep boop!"; }
}

class TalkingToyBox {
    public static void printSounds(Toy[] toys) {
        if (toys == null) return;
        for (Toy toy : toys) if (toy != null) System.out.println(toy.getToyId() + ": " + toy.makeSound());
    }
}