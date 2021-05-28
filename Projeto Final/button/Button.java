package button;
import ivisible.IVisible;
import figures.Figure;
import java.awt.event.*;

import java.awt.*;
public class Button implements IVisible {
    public int x, y;
    int pos = 36;
    public int indice;
    Figure fig;
    public boolean infocus;

    public Button (int indice, Figure fig) {
		this.indice = indice;
        this.fig = fig;
        this.infocus=false;
        this.x = 50;
        this.y = 20 + (indice * pos);
    }

    public boolean contains (MouseEvent evt) {
		boolean x, y, z, a;
		x = evt.getX() >= this.x;
		y = evt.getX() <= this.x + pos;
		z = evt.getY() >= this.y;
		a = evt.getY() <= this.y + pos;
		return x && y && z && a;
    }

    public void paint (Graphics g, boolean infocus) {
	   Graphics2D g2d = (Graphics2D) g;
		if (infocus){
		   g2d.setColor(Color.GRAY);
	    }
		else{
			g2d.setColor(Color.LIGHT_GRAY);
		}
       g2d.fillRect (this.x,this.y, pos, pos);
       g2d.setColor(Color.BLACK);
       g2d.drawRect(this.x,this.y, pos,pos);
       this.fig.paint(g, false);
    }
}