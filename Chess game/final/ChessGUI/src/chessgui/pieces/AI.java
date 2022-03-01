package chessgui.pieces;
import chessgui.Board;

import java.util.ArrayList;

public class AI {
    ArrayList<Move> possibleMoves = new ArrayList();
//    public int evaluateScore(Board board)
//    {
//        return board.white_score - board.black_score; 
//    }
    public int minimax(Board board, int depth, int x, int y, boolean is_whites_turn)
    {
        int eval;
        if(depth == 0);
//            return evaluateScore(board);
        
        if (is_whites_turn)
        {
            int maxValue = -999999;
            for(Move m: possibleMoves)
            {
                eval = minimax(board, depth - 1, m.getX(), m.getY(), false);
                if(eval > maxValue)
                {
                    maxValue = eval;
                }
            }
            return maxValue;
            
        }
        else
        {
            int minValue = 999999;
            for(Move m: possibleMoves)
            {
                eval = minimax(board, depth - 1, m.getX(), m.getY(), false);
                if(eval > minValue)
                {
                    minValue = eval;
                }
            }
            return minValue;
        }
    }
}
