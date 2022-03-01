package chessgui.pieces;

import chessgui.Board;

import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(int x, int y, boolean is_white)
    {
        super(x,y,is_white);
    }

    public Bishop(int x, int y) {
        super(x, y);
    }
    
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
        Piece PieceInPosition= Board.getPiece(destination_x,destination_y);
        if(PieceInPosition != null){
        if(PieceInPosition.isWhite()&&this.isWhite())
        {
            return false ;
        }
        if(PieceInPosition.isBlack()&&this.isBlack())
        {
            return false ;
        }
        
        }
        //Checking that it moves in a diagonal
        if(Math.abs(destination_x-this.getX())!=Math.abs(destination_y-this.getY()))
       {
            return false;   
       }
        //checking for obstacles
        int dif=Math.abs(destination_x-this.getX());
        for(int i = 1; i < dif; i++)
        {
            
            //RD
             if(destination_x>this.getX()&& destination_y>this.getY())
            {
                Piece p=Board.getPiece(this.getX()+i, this.getY()+i);
                if(p!=null)
                {
                    return false;
                } 
            }
            //RU
             
             if(destination_x<this.getX() && destination_y>this.getY())
            {
                Piece p=Board.getPiece(this.getX()-i, this.getY()+i);
                if(p!=null)
                {
                    return false;
                }
            }
            //LD
             if(destination_x>this.getX() && destination_y<this.getY())
            {
                 Piece p=Board.getPiece(this.getX()+i, this.getY()-i);
                if(p!=null)
                {
                    return false;
                }
            }
            //LU
             if(destination_x<this.getX() && destination_y<this.getY())
            {
                 Piece p=Board.getPiece(this.getX()-i, this.getY()-i);
                if(p!=null)
                {
                    return false;
                }
            }  
        }
        
               return true;

    }
        @Override
    public ArrayList<Move> validMoves(int x, int y) {
           ArrayList<Move> moves = new ArrayList<Move>();

		for(int i = 1; i < 8; i++) {
                    // NE
                    if(canMove(x+i, y+i)) {
                            moves.add(new Move(x+i,y+i));		
			}
                        //NW
                    if(canMove(x-i, y+i)) {
				moves.add(new Move(x-i,y+i));	
			}
                        //SE
                    if(canMove(x+i, y-i)) {
			moves.add(new Move(x+i,y-i));	
			}
                        //SW
                    if(canMove(x-i, y-i)) {
			moves.add(new Move(x-i,y-i));	
			}
		}

		return moves;
    }
}

