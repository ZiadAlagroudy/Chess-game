package chessgui.pieces;

import chessgui.Board;

import java.util.ArrayList;

public abstract class Piece {
    private int x;
    private int y;
    private boolean is_white;
    private String file_path;
    public Board board;
    
    public Piece(int x, int y, boolean is_white, String file_path, Board board)
    {
        this.is_white = is_white;
        this.x = x;
        this.y = y;
        this.file_path = file_path;
        this.board = board;
    }

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public String getFilePath()
    {
        return file_path;
    }
    
    public void setFilePath(String path)
    {
        this.file_path = path;
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
    
    public boolean canMove(int destination_x, int destination_y)
    {
        return false;
    }
     public abstract ArrayList<Move> validMoves(int x, int y);

public boolean isincheck()
{
    int x = 0 ;
    int y = 0 ;
    for(int i=0;i<8;i++)
        for(int j=0;j<8;j++)
        {
            Piece P=board.getPiece(i,j);
            if(P.isWhite()&& P instanceof King && P!=null){
                x=P.getX();
                y=P.getY();
            }
//                System.out.println(x);
//                System.out.println(y);
        }
    
     for(int i=0;i<8;i++)
        for(int j=0;j<8;j++)
        {
           Piece P=board.getPiece(i,j);
           if(P.isBlack()&& P!=null)
           {
               if(P.canMove(x,y))
               {
               System.out.println(y);
                 return true ;  
               }
               
           }
        }
    
    return false;
}
}
