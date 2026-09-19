package week7.assigment_problems;

public abstract class ArtPiece {
    private static int nextId = 1;
    private final String pieceId;
    protected ArtPiece() { pieceId = "ART-" + nextId++; }
    public abstract String describe();
    public String getPieceId() { return pieceId; }
}

class Painting extends ArtPiece {
    private final String title;
    public Painting(String title) { super(); if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("title cannot be blank"); this.title = title; }
    @Override public String describe() { return "Painting: " + title + ", framed on canvas"; }
}

class Sculpture extends ArtPiece {
    private final String title;
    public Sculpture(String title) { super(); if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("title cannot be blank"); this.title = title; }
    @Override public String describe() { return "Sculpture: " + title + ", carved from stone"; }
}