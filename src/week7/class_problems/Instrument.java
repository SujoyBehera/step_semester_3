package week7.class_problems;

public abstract class Instrument { public abstract String play(); }

class StringInstrument extends Instrument {
    public StringInstrument() { super(); }
    @Override public String play() { return "Strumming the strings"; }
}

class Violin extends StringInstrument {
    public Violin() { super(); }
    @Override public String play() { return super.play() + ", with a bow drawn across four strings"; }
}