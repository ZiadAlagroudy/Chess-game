package chessgui.pieces;

import java.util.ArrayList;

public abstract class Piece {
    private int x;
    private int y;
    private boolean is_white;
    
    
//    public static ArrayList<Piece> Pieces_list = new ArrayList<>();
    
    
    public Piece(int x, int y, boolean is_white)
    {
        this.is_white = is_white;
        this.x = x;
        this.y = y;
    }

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean isWhite()
    {
        return is_white;
    }
    
    public boolean isBlack()
    {
        return !is_white;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public abstract boolean canMove(int destination_x, int destination_y);
    
    public abstract ArrayList<Move> validMoves(int x, int y);

    @Override
    public String toString() {
        return "Piece{" + "x=" + x + ", y=" + y + ", is_white=" + is_white + '}';
    }
    
    

}