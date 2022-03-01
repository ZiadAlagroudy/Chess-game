package chessgui.pieces;

import chessgui.Board;

import java.util.ArrayList;

public class Pawn extends Piece {

    private boolean has_moved;
    
    public Pawn(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
        has_moved = false;
    }

    public Pawn(int x, int y) {
        super(x, y);
    }
    
    public void setHasMoved(boolean has_moved)
    {
        this.has_moved = true;
    }
    
    public boolean getHasMoved()
    {
        return has_moved;
    }
    
    @Override
    public boolean canMove(int Column, int Row)
    {
        
        // Remember: A pawn may only move towards the oponent's side of the board.
        // If the pawn has not moved yet in the game, for its first move it can 
        // move two spaces forward. Otherwise, it may only move one space. 
        // When not attacking it may only move straight ahead.
        // When attacking it may only move space diagonally forward

                // WRITE CODE HERE
         int columns_to_move=(Column-this.getX());
        int Row_to_move=(Row-this.getY());
        
        
         Piece PieceInPosition=board.getPiece(Column,Row);
         
//            isincheck();
//         {
//             System.out.println("yes");
//         }
         
        if(PieceInPosition != null){
            
            //to check if that the  piece infront of him is opp color so he cant eat it 
            if(PieceInPosition.isBlack()&&this.isWhite())
                if(Row_to_move==1&&columns_to_move==0)
                    return false ;
            
          //if the place he is going to contains a piece of his color 
        if(PieceInPosition.isWhite()&&this.isWhite())
        {
            return false ;
        }
        
        if(PieceInPosition.isWhite()&&this.isBlack())
                if(Row_to_move==-1&&columns_to_move==0)
                    return false ;
        
        
        // if the place he is going contains a piece of his color 
        if(PieceInPosition.isBlack()&&this.isBlack())
        {
        return false ;}
        }
        
        
        //till here is the conditions of having piece where he is going to 
        
        
        
        
        
        if(isWhite()){
        if(this.getHasMoved()==false)
        {
            if(columns_to_move==0){
                if(Row_to_move==1)
                {
                    //this.setHasMoved(true);
                    return true ;
                }
            if(Row_to_move==2)
            {
                Piece Temp=board.getPiece(Column,Row-1);
                if(Temp!=null)
                    return false;
                else 
                    return true ;
                            
            }
            }
        }
        else 
            if(columns_to_move==0&&Row_to_move==1)
            {   //this.setHasMoved(true);
                return true;
            }
    }
                
              if(this.isBlack()){
        if(this.getHasMoved()==false)
        {
             if(columns_to_move==0){
                if(Row_to_move==-1)
                {
                    //this.setHasMoved(true);
                    return true ;
                }
            if(Row_to_move==-2)
            {
                Piece Temp=board.getPiece(Column,Row+1);
                if(Temp!=null)
                    return false;
                else 
                    return true ;
                            
            }
            }
            
            
        }
        else 
            if(columns_to_move==0&&Row_to_move==-1)
            {
                this.setHasMoved(true);
                return true;
            }
              }
              
              if(PieceInPosition!=null)
              {
//there  is a piece in this pos and we can eat it as a white piece
                  if(PieceInPosition.isBlack()&&this.isWhite())
                      if(columns_to_move==1||columns_to_move==-1)
                          if(Row_to_move==1)
                          return true;
                  
              }
            
            
              
              
              if(PieceInPosition!=null)
              {//there  is a piece in this pos and we can eat it as a Black piece
                  if(PieceInPosition.isWhite()&&this.isBlack())
                      if(columns_to_move==1||columns_to_move==-1)
                          if(Row_to_move==-1)
                          return true;
                  
              }

		
              
              
       return false; 
    }
        @Override
    public ArrayList<Move> validMoves(int x, int y) {
        		ArrayList<Move> moves = new ArrayList<Move>();
		
                        for(int i=0;i<8;i++)
                            for(int j=0;j<8;j++)
                            {
                            if(canMove(i,j))
                                moves.add(new Move(i,j));
                            }
                                
//		if(isWhite()) {
//			// forward
//			if(canMove(x,y+1))
//				moves.add(new Move(x,y+1));
//                       
//			
//			// kill diagonally
//			if(canMove(x+1,y+1))
//				moves.add(new Move(x+1,y+1));
//			
//			// kill diagonally
//			if(canMove(x-1,y+1))
//				moves.add(new Move(x-1,y+1));
//		}
//		else {
//			// forward
//			if(canMove(x,y-1))
//				moves.add(new Move(x,y-1));
//			
//			// kill diagonally
//			if(canMove(x+1,y-1))
//				moves.add(new Move(x+1,y-1));
//			
//			// kill diagonally
//			if(canMove(x-1,y-1))
//				moves.add(new Move(x-1,y-1));
//		}
//		
		return moves;
    }
}


