package week7.assigment_problems;
public class Sculpture extends ArtPiece {
    private final String title;
    public Sculpture(String title){ super(); if(title==null||title.trim().isEmpty()) throw new IllegalArgumentException("title cannot be blank"); this.title=title; }
    public String describe(){ return "Sculpture: "+title+", carved from stone"; }
}