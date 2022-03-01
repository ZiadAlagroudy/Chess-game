package chessgui.pieces;

import chessgui.Board;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }

    public Rook(int x, int y) {
        super(x, y);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
        // Remember: A rook can move as many squares as he wants either forward,
        // backward, or sideways without jumping any pieces. He cannot attack
        // his own pieces.
        // Try not to kill your team
        Piece possiblePiece= board.getPiece(destination_x, destination_y);
        if(possiblePiece != null) 
        {
            if(possiblePiece.isWhite() && this.isWhite())
            {
                return false;
            }
            if(possiblePiece.isBlack()&& this.isBlack())
            {
                return false;
            }
        }
        //Just be in a straight line dude
        if(this.getX() != destination_x && this.getY() != destination_y)
        {
            return false;
        }
        // Remember that I know where you are
        String direction="";
        if(destination_y>this.getY())
        {
            direction="south";
        }
        if(destination_y<this.getY())
        {
            direction="north";
        }
        if(destination_x>this.getX())
        {
            direction="east";
        }
        if(destination_x<this.getX())
        {
            direction="west";
        }
        // checking if the road is clean for killing
        if(direction.equals("south"))
        {
            int num_of_spots=Math.abs(destination_y-this.getY());
            for(int i=1;i<num_of_spots;i++)
            {
                Piece p=board.getPiece(this.getX(), this.getY()+i);
                if(p != null)
                {
                    return false;
                }
            }
        }
        if(direction.equals("north"))
        {
            int num_of_spots=Math.abs(destination_y-this.getY());
            for(int i=1;i<num_of_spots;i++)
            {
                Piece p=board.getPiece(this.getX(), this.getY()-i);
                if(p != null)
                {
                    return false;
                }
            }
        }
        if(direction.equals("east"))
        {
            int num_of_spots=Math.abs(destination_x-this.getX());
            for(int i=1;i<num_of_spots;i++)
            {
                Piece p=board.getPiece(this.getX()+i, this.getY());
                if(p != null)
                {
                    return false;
                }
            }
        }
        if(direction.equals("west"))
        {
            int num_of_spots=Math.abs(destination_x-this.getX());
            for(int i=1;i<num_of_spots;i++)
            {
                Piece p=board.getPiece(this.getX()-i, this.getY());
                if(p != null)
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
                    // up
			if(canMove(x, y+i))
			moves.add(new Move(x,y+i));
                    //down
                    if(canMove(x, y-i))
                            moves.add(new Move(x,y-i));	
                    //left
                    	if(canMove(x-i, y)) {
                            moves.add(new Move(x-i,y));	
			}
                     //right
                        if(canMove(x+i, y)) {
                            moves.add(new Move(x+i,y));	
			}
		}
		
		return moves;
	
    }
    
}
