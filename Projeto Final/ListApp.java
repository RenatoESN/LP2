import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.*;
import button.Button;
import ivisible.IVisible;
import java.io.*;
import java.util.Random;


public class ListApp{
    public static void main(String[] args) {
        ListFrame frame=new ListFrame();
        frame.setVisible(true);
    }  
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Button> buttons= new ArrayList<Button>();
	Random rand = new Random();
	Color cores[] = {Color.BLUE, Color.GREEN, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW, Color.BLACK};
	int line, background;

    Point p;
    Figure focus = null;
    Button button_focus=null;

    Color a = null;
    ListFrame () {
		
		try{
			FileInputStream f = new FileInputStream("proj.bin");
			ObjectInputStream o = new ObjectInputStream(f);
			this.figs = (ArrayList<Figure>) o.readObject();
			o.close();
		}
        catch(Exception x){
            System.out.println("ERRO!\n");
        }
		buttons.add(new Button(1, new Ellipse(50,80,27,17, Color.black, Color.black)));
		buttons.add(new Button(2, new Rect(30,110,20,15, Color.black, Color.black)));
		buttons.add(new Button(3, new Triangulo(50, 160, 25, 27, Color.black, Color.black)));
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
					try{
					    FileOutputStream f = new FileOutputStream("proj.bin");
					    ObjectOutputStream o = new ObjectOutputStream(f);
					    o.writeObject(figs);
					    o.flush();
					    o.close();
				    }
                    catch(Exception x){
					    System.out.println("ERRO!\n");
				    }
                    System.exit(0);
                }
        });
		   
        this.addMouseListener (
            new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    p = getMousePosition();
					line = rand.nextInt(7);
					background = rand.nextInt(7);
					if(button_focus != null ){
						if(button_focus.indice==1)
							figs.add(new Ellipse(p.x,p.y,rand.nextInt(150),rand.nextInt(150),cores[line],cores[background]));      
						else if(button_focus.indice==2){
                            figs.add(new Rect(p.x,p.y,rand.nextInt(150),rand.nextInt(150),cores[line],cores[background]));      
						}
						else if(button_focus.indice==3){
                            figs.add(new Triangulo(p.x,p.y,rand.nextInt(150),rand.nextInt(150),cores[line],cores[background])); 
						}
						button_focus = null;
                        repaint();
						return;
					}
					for (Button but: buttons) {
                        but.infocus = false;
						if (but.contains(evt)) {
                            but.infocus = true;
                            button_focus = but;
                        }
                    }
					if (focus != null) {
                        focus.line = a;
                    }
					focus=null;
					for (Figure fig: figs) {
                        if (fig.contains(evt)) {
                          focus = fig;
                          a = focus.line;
                        }
                    }
                    if (focus != null) {
                        focus.line = a;
					    if(focus.line != Color.red){
                            focus.line = Color.red;
                        }
						figs.remove(focus);
                        figs.add(focus);	
                    }
					repaint();
                }
            });

        this.addMouseMotionListener (
            new MouseMotionAdapter() {
                public void mouseDragged (MouseEvent evt) {
					Point mousePressedPos=  evt.getPoint();
                    focus.drag(evt.getX() - p.x, evt.getY() - p.y, mousePressedPos);
                    p = getMousePosition();
                    repaint();
                        
                }
        });

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
					Point p = getMousePosition();
                    int keyCode = evt.getKeyCode();
					line = rand.nextInt(7);
					background = rand.nextInt(7);
					if (evt.getKeyChar() == 'e') {
						figs.add(new Ellipse(p.x,p.y,rand.nextInt(150),rand.nextInt(150),cores[line],cores[background]));
                    }
                    else if(evt.getKeyChar() == 'r'){
						figs.add(new Rect(p.x,p.y,rand.nextInt(150),rand.nextInt(150),cores[line],cores[background])); 
                    }
                    else if(evt.getKeyChar() == 't'){
						figs.add(new Triangulo(p.x,p.y,rand.nextInt(150),rand.nextInt(150),cores[line],cores[background])); 
					}
					else if(evt.getKeyChar() == '1' && focus!=null ){
	                    focus.setColor(Color.blue);			
					}
                    else if(evt.getKeyChar() == '2' && focus!=null ){
                        focus.setColor(Color.green);			
					}
                    else if(evt.getKeyChar() == '3' && focus!=null ){
						focus.setColor(Color.orange);
					}
					else if(evt.getKeyChar() == '4' && focus!=null ){
						focus.setColor(Color.pink);
					}
					else if(evt.getKeyChar() == '5' && focus!=null ){
						focus.setColor(Color.red);
					}
					else if(evt.getKeyChar() == '6' && focus!=null ){
						focus.setColor(Color.yellow);
					}
					else if(evt.getKeyChar() == '7' && focus!=null ){
						focus.setColor(Color.black);
					}
                    else if(evt.getKeyCode() == 40){
					  	for(Figure fig: figs){
                            if(focus == fig){
					         focus.drag(0,1,p);
                            }
                        }
                    }
					else if(evt.getKeyCode() == KeyEvent.VK_DELETE && focus!=null){
						figs.remove(focus);
                        focus=null;
					}	
					repaint();
            }
        });
        this.setTitle("Editor Grafico");
        this.setSize(750, 750);
    }

   public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g, fig.infocus);
        }
		for (Button but: this.buttons) {
            but.paint(g,but.infocus);
        }  
    }
}