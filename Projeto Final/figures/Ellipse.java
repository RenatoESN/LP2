package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

import java.awt.event.*;

 public class Ellipse  extends Figure {
    int x, y;
    int w, h;
	Ellipse2D  ellipse;

    public Ellipse (int x, int y, int w, int h,Color line, Color background) {
		super(x, y,w,h,line,background);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.line=line;
		this.background=background;
        this.ellipse = new Ellipse2D.Double(this.x, this.y, this.w, this.h);
    }
	
	public void drag(int x,int y, Point p){
        this.x+=x;
        this.y+=y;
        this.ellipse = new Ellipse2D.Double(this.x, this.y, this.w, this.h);
    }
	
	public boolean contains(MouseEvent evt) {
        if (this.ellipse.contains(evt.getPoint())){	
            return true;
		}
        return false;
    }
	  
	public void setColor(Color background){
		this.background=background;
	}
	
	public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",this.w, this.h, this.x, this.y);
    }

	public void paint (Graphics g, boolean infocus) {
        Graphics2D g2d = (Graphics2D) g;
		
		if(infocus){
			g2d.setColor(this.line);
			g2d.draw(this.ellipse);
			g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
		}
        g2d.setColor(this.line);
        g2d.draw(this.ellipse);
        g2d.setColor(this.background);
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
	}
}