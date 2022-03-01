package chessgui.pieces;

import chessgui.Board;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }

    public Knight(int x, int y) {
        super(x, y);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
        // Remember: a knight can move in any L shape and can jump over anyone
        // in order to do so. He cannot attack his own pieces.
        // By an L shape, I mean it can move to a square that is 2 squares away
        // horizontally and 1 square away vertically, or 1 square away horizontally
        // and 2 squares away vertically.
        // some examples:
        //
        //  * *       * * *           *       *
        //  *             *       * * *       *
        //  *                                 * *
            
                // WRITE CODE HERE
        Piece PieceInPosition=board.getPiece(destination_x,destination_y);
                // WRITE CODE HERE
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
        int columns_to_move =Math.abs(destination_y-this.getY());
        int Row_to_move=Math.abs(destination_x-this.getX());
        if((columns_to_move*Row_to_move)!=2)
        {
            return false ;
        }
        
        
        return true;
    }
      @Override
    public ArrayList<Move> validMoves(int x, int y) {
        ArrayList<Move> moves = new ArrayList<Move>();
		
		// NNE
		if(canMove(x+1, y+2))
			moves.add(new Move(x+1, y+2));
		
		// ENE
		if(canMove(x+2, y+1))
			moves.add(new Move(x+2, y+1));
		
		// ESE
		if(canMove(x+2,y-1))
			moves.add(new Move(x+2,y-1));
		
		
		// SSE
		if(canMove(x+1,y-2))
			moves.add(new Move(x+1,y-2));
		
		// SSW
		if(canMove(x-1,y-2))
			moves.add(new Move(x-1,y-2));
		
		// WSW
		if(canMove(x-2,y-1))
			moves.add(new Move(x-2,y-1));
		
		// WNW
		if(canMove(x-2,y+1))
			moves.add(new Move(x-2,y+1));
		
		// NNW
		if(canMove(x-1,y+2))
			moves.add(new Move(x-1,y+2));
		
		return moves;
    }
    
}
