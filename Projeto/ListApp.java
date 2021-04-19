import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;

import figures.*;
//import jdk.internal.org.jline.terminal.MouseEvent;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame{
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
    Color cores[] = {Color.BLUE, Color.GREEN, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW, Color.BLACK};

    /* Variaveis para Mouse Event */
    private int posx, posy;
    private Figure focus = null;
    /* FIM */

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
                    int line = rand.nextInt(7);
                    int background = rand.nextInt(7);
                    if (evt.getKeyChar() == 'r') {
                        Rect r = new Rect(x,y, w,h, cores[line], cores[background]);
                        figs.add(r);
                    } else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h, cores[line], cores[background]));
                    } else if (evt.getKeyChar() == 'l') {
                        figs.add(new Line(x,y, w,h, cores[line], cores[background]));
                    }else if (evt.getKeyChar() == 't') {
                        figs.add(new Triangle(x,y, w,h, cores[line], cores[background]));
                    }
                    repaint();
                }
            }
        );

        /* Mouse Events */
       this.addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent e){
                    seleciona(e.getX(), e.getY());
                    System.out.format("Mouse pressed " + focus.getx() + "e " + focus.gety() + "\n");
                    //repaint();
                }
            }
        );
        this.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseMoved(MouseEvent e){
                int posx = e.getX();
                int posy = e.getY();
                System.out.println("Mouse moved");
                //repaint();
            }
            public void mouseDragged(MouseEvent e){
                focus.drag(e.getX(), e.getY());
                System.out.format("Mouse dragged " + focus.getx() + "e " + focus.gety() + "\n");
                repaint();
            }
        });
        /* FIM */

        this.setTitle("Lista de Figuras");
        this.setSize(500, 500);
    }
    public void seleciona(int x, int y){
        for (Figure fig: this.figs) {
            if (fig.getx() <= x && x <= fig.getx() + fig.getw() && fig.gety() <= y && y <= fig.gety() + fig.geth()){
                focus  = fig;
                System.out.format("Selecionado " + focus + "\n");
            }
        }
        //repaint();
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}