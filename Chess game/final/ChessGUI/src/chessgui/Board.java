package chessgui;

import chessgui.pieces.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class Board {
    public static Piece activePiece = null;
    public static int turnCnt = 0;
    static JFrame frame = new JFrame("Chess");
    static Image Images[]=new Image[12];
    static Boolean whiteTurn = true;
    public static ArrayList<Piece> Pieces_list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        
        BufferedImage all=ImageIO.read(new File("C:\\Users\\avata\\Desktop\\Chessgame3\\chess.png"));
        BufferedImage activeSquare = ImageIO.read(new File("C:\\Users\\avata\\Desktop\\Chessgame4\\ChessGUI\\images\\active_square.png"));

        
        int ind=0;
        
        for(int y=0;y<400;y+=200){
            for(int x=0;x<1200;x+=200){
                Images[ind]=all.getSubimage(x, y, 200, 200).getScaledInstance(65, 65, BufferedImage.SCALE_SMOOTH);
                ind++;
            }
        }
        Pieces_list.add(new Rook(0, 0, false));
        Pieces_list.add(new Knight(1, 0, false));
        Pieces_list.add(new Bishop(2, 0, false));
        Pieces_list.add(new Queen(3, 0, false));
        Pieces_list.add(new King(4, 0, false));
        Pieces_list.add(new Bishop(5, 0, false));
        Pieces_list.add(new Knight(6, 0, false));
        Pieces_list.add(new Rook(7, 0, false));
        Pieces_list.add(new Pawn(0, 1, false));
        Pieces_list.add(new Pawn(1, 1, false));
        Pieces_list.add(new Pawn(2, 1, false));
        Pieces_list.add(new Pawn(3, 1, false));
        Pieces_list.add(new Pawn(4, 1, false));
        Pieces_list.add(new Pawn(5, 1, false));
        Pieces_list.add(new Pawn(6, 1, false));
        Pieces_list.add(new Pawn(7, 1, false));        

        Pieces_list.add(new Rook(0, 7, true));
        Pieces_list.add(new Knight(1, 7, true));
        Pieces_list.add(new Bishop(2, 7, true));
        Pieces_list.add(new Queen(3, 7, true));
        Pieces_list.add(new King(4, 7, true));
        Pieces_list.add(new Bishop(5, 7, true));
        Pieces_list.add(new Knight(6, 7, true));
        Pieces_list.add(new Rook(7, 7, true));
        Pieces_list.add(new Pawn(0, 6, true));
        Pieces_list.add(new Pawn(1, 6, true));
        Pieces_list.add(new Pawn(2, 6, true));
        Pieces_list.add(new Pawn(3, 6, true));
        Pieces_list.add(new Pawn(4, 6, true));
        Pieces_list.add(new Pawn(5, 6, true));
        Pieces_list.add(new Pawn(6, 6, true));
        Pieces_list.add(new Pawn(7, 6, true));         
        
        frame.setBounds(500, 100, 512, 512);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.add(drawBoard());

        System.out.println(getPiece(3, 6).toString());
        
        frame.addMouseListener(new MouseListener(){
          
            @Override
            public void mouseClicked(MouseEvent me) {
                
            }

            @Override
            public void mousePressed(MouseEvent me) {
                    
                if(turnCnt%2 == 1)
                {
                    whiteTurn = false;
                }
                else
                {
                    whiteTurn = true;
                }
                
                Piece clickedPiece = getPiece((me.getX()/64),(me.getY()/64)); 
                
                if(activePiece == null && clickedPiece != null &&
                    ((whiteTurn && clickedPiece.isWhite()) || (!whiteTurn && clickedPiece.isBlack())))
                {
                    activePiece = clickedPiece;
                }
                else if(activePiece != null && clickedPiece != null &&
                       ((whiteTurn && clickedPiece.isWhite()) || (!whiteTurn && clickedPiece.isBlack())))
                {
                    activePiece = clickedPiece;
                }
                else if (activePiece != null && activePiece.getX() == (me.getX()/64) && activePiece.getY() == (me.getY()/64))
                {
                    activePiece = null;
                }
                else if(activePiece != null && activePiece.canMove((me.getX()/64),(me.getY()/64)) &&
                        ((whiteTurn && activePiece.isWhite()) || (!whiteTurn && activePiece.isBlack())))
                {
                    if(clickedPiece != null)
                    {
                        Pieces_list.remove(clickedPiece);
                            
                    }
                    activePiece.setX((me.getX()/64));
                    activePiece.setY((me.getY()/64));
                        
                    activePiece = null;
                
                    turnCnt++;
                }
                try {
                    frame.add(drawBoard());
                }
                catch (IOException ex) {
                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                }
                frame.repaint();
  
            }
                    

            @Override
            public void mouseReleased(MouseEvent me) {
    
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                
                
                
            }

            @Override
            public void mouseExited(MouseEvent me) {
               
                
                
            }
        });
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
    
    public static Piece getPiece(int x,int y){
        
        for(Piece p:Pieces_list){
            if(p.getX() == (x) && p.getY() == (y)){
                return p;
            }
        }
        return null;
    }
    
    public static JPanel drawBoard() throws IOException{
        BufferedImage activeSquare = ImageIO.read(new File("C:\\Users\\avata\\Desktop\\Chessgame4\\ChessGUI\\images\\active_square.png"));

        JPanel panel=new JPanel(){
            @Override
            public void paint(Graphics g) {
                
                boolean white=true;
                for(int y= 0;y<8;y++){
                    for(int x= 0;x<8;x++){
                        if(white){
                            g.setColor(new Color(246, 243, 243));
                        }
                        else{
                            g.setColor(new Color(124, 154, 111));
                        }
                        g.fillRect(x*64, y*64, 64, 64);
                        white=!white;
                    }
                    white=!white;
                }
                for(Piece p: Pieces_list){
                    int ind=0;
                    if(p instanceof King){
                        ind=0;
                    }
                    if(p instanceof Queen){
                        ind=1;
                    }
                    if(p instanceof Bishop){
                        ind=2;
                    }
                    if(p instanceof Knight){
                        ind=3;
                    }   
                    if(p instanceof Rook){
                        ind=4;
                    }
                    if(p instanceof Pawn){
                        ind=5;
                    }
                    if(!p.isWhite()){
                        ind+=6;
                    }
                    g.drawImage(Images[ind], p.getX() * 64, p.getY() * 64, this);
                }
                
                if(activePiece != null)
                {
                    g.drawImage(activeSquare, activePiece.getX()*64, activePiece.getY()*64, this);
                    for(Move m: activePiece.validMoves(activePiece.getX(), activePiece.getY()))
                    {
                        g.drawImage(activeSquare, m.getX()*64, m.getY()*64, this);
                    }
                }
                
            
            }
            

        };
        return panel;
    }

}
