package chessgui.pieces;

import chessgui.Board;

import java.util.ArrayList;

public class King extends Piece {
    
    

    public King(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }

    public King(int x, int y) {
        super(x, y);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
        
        //getkingpos();
        
         Piece PieceInPosition = board.getPiece(destination_x,destination_y);
         int diffColumn = Math.abs(this.getY() - destination_y);
         int diffRow = Math.abs(this.getX() - destination_x);
         
         //castling 
         
         
         
         
         
         //end of caslting 
        if(diffColumn > 1 || diffRow > 1)
        {
            return false;
        }
                
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
        
            for(int i = 0; i < 8; i++)
            {
                for(int j = 0; j < 8; j++)
                {
                    Piece p=board.getPiece(j,i);
                    if(p!=null)
                        if(p.isWhite()!=this.isWhite())
                        {
                        if(p instanceof King){
                            if(Math.abs(p.getY()-destination_y)<=1&&Math.abs(p.getX()-destination_x)<=1)
                            return false;
                        }
                        else if( p instanceof Pawn)
                        if(p.isBlack())
                        {
                            if(p.getY()-destination_y==1&&Math.abs(p.getX()-destination_x)==1)
                                return false;
                        }
                        else
                        {
                            if(p.getY()-destination_y==-1&&Math.abs(p.getX()-destination_x)==1)
                                return false;
                        }
                        else{
                     if(p.canMove(destination_x, destination_y))
                     {
                        return false;
                     }
                        }
                        }
                }
            }
            
            
            
            
            return true;
    }
      @Override
    public ArrayList<Move> validMoves(int x, int y) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		// N
		if(canMove(x, y+1))
			moves.add(new Move(x,y+1));
		
		// NE
		if(canMove(x+1, y+1))
			moves.add(new Move(x+1,y+1));
		
		// E
		if(canMove(x+1,y))
			moves.add(new Move(x+1,y));
		
		
		// SE
		if(canMove(x+1,y-1))
			moves.add(new Move(x+1,y-1));
		
		// S
		if(canMove(x,y-1))
			moves.add(new Move(x,y-1));
		
		// SW
		if(canMove(x-1,y-1))
			moves.add(new Move(x-1,y-1));
		
		// W
		if(canMove(x-1,y))
			moves.add(new Move(x-1,y));
		
		// NW
		if(canMove(x-1,y+1))
			moves.add(new Move(x-1,y+1));

		
		return moves;
	
    }
    
}
