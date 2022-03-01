package chessgui.pieces;

import chessgui.Board;

import java.util.ArrayList;

public class Pawn extends Piece {

    private boolean has_moved;

    public Pawn(int x, int y, boolean is_white) {
        super(x, y, is_white);
        has_moved = false;
    }

    public Pawn(int x, int y) {
        super(x, y);
    }

    public void setHasMoved(boolean has_moved) {
        this.has_moved = true;
    }

    public boolean getHasMoved() {
        return has_moved;
    }

    @Override
    public boolean canMove(int Column, int Row) {

        // Remember: A pawn may only move towards the oponent's side of the board.
        // If the pawn has not moved yet in the game, for its first move it can 
        // move two spaces forward. Otherwise, it may only move one space. 
        // When not attacking it may only move straight ahead.
        // When attacking it may only move space diagonally forward

        int Columns_to_move = (this.getX() - Column);
        int Row_to_move = (this.getY() - Row);
        Piece PieceInPosition = Board.getPiece(Column, Row);
        //white normal moves
        if(this.isWhite()==true) {
            if (Columns_to_move == 0) {
                if (Row_to_move == 1) {
                    if (PieceInPosition != null)
                        return false;

                    else {
                        return true;
                    }
                }

                Piece temp = Board.getPiece(this.getX(), this.getY()-1);
                if (Row_to_move == 2) {
                    if (PieceInPosition != null) {
                        return false;}
                    else {
                        if(this.getY()==6)
                        {
                            if(temp!=null)
                                return false;
                                else
                            return true;
                        }
                    }

                }
            }
            if(Columns_to_move==1||Columns_to_move==-1)
            {
                if(Row_to_move==1&& PieceInPosition!=null)
                {
                    if(PieceInPosition.isBlack()==true)
                    return true;
                }

            }
        }
        //black normal moves
        if(this.isBlack()==true)
        {
            if(Columns_to_move==0) {
                if (Row_to_move == -1) {
                    if (PieceInPosition != null) {
                        return false;
                    } else
                        return true;
                }
                Piece temp = Board.getPiece(this.getX(), this.getY()+1);
                if (Row_to_move == -2)
                    if (PieceInPosition != null)
                        return false;
                    else {
                        if (this.getY() == 1) {
                            if(temp!=null)
                                return false;
                            else
                            return true;
                        }
                    }
            }
            if(Columns_to_move==1||Columns_to_move==-1)
            {
                if(Row_to_move==-1&& PieceInPosition!=null)
                {
                    if(PieceInPosition.isWhite()==true)
                        return true;
                }

            }
        }
return false;
    }
        @Override
    public ArrayList<Move> validMoves(int x, int y){
        ArrayList<Move> moves = new ArrayList<Move>();

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                if (canMove(i, j))
                    moves.add(new Move(i, j));
            }


		return moves;
    }
}


