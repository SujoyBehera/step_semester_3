package week7.assigment_problems;
public abstract class ArtPiece {
    private static int nextId=1;
    private final String pieceId;
    protected ArtPiece(){ pieceId="ART-"+nextId++; }
    public abstract String describe();
    public String getPieceId(){ return pieceId; }
}