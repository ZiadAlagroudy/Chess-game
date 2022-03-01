package chessgui.pieces;

import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(int x, int y, boolean is_white)
    {
        super(x,y,is_white);
    }

    public Queen(int x, int y) {

        super(x, y);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
        
        if(isWhite())
        return new Bishop(this.getX(),this.getY(),true).canMove(destination_x, destination_y)||new Rook(this.getX(),this.getY(),true).canMove(destination_x, destination_y);
        else 
            return new Bishop(this.getX(),this.getY(),false).canMove(destination_x, destination_y)||new Rook(this.getX(),this.getY(),false).canMove(destination_x, destination_y);
    
    }

    @Override
    public ArrayList<Move> validMoves(int x, int y) {
        ArrayList<Move> moves = new ArrayList<Move>();
		
            	for(int i = 1; i < 8; i++) {
                    
                    // up
			        if(canMove(x, y+i)){
			        moves.add(new Move(x,y+i));
			        }
                    //down
                    if(canMove(x, y-i)) {
                        moves.add(new Move(x, y - i));
                    }//left
                    	if(canMove(x-i, y)) {
                            moves.add(new Move(x-i,y));	
			}
                     //right
                        if(canMove(x+i, y)) {
                            moves.add(new Move(x+i,y));	
			}
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
