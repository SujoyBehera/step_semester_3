package week7.assigment_problems;
public class Painting extends ArtPiece {
    private final String title;
    public Painting(String title){ super(); if(title==null||title.trim().isEmpty()) throw new IllegalArgumentException("title cannot be blank"); this.title=title; }
    public String describe(){ return "Painting: "+title+", framed on canvas"; }
}