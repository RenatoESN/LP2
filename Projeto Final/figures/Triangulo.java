package figures;
import java.awt.event.*;

import java.awt.*;

public class Triangulo  extends Figure{
	int x, y;
	int w, h;
	Polygon triangle ;
	Color a;
	Color b;
    public int[] x1, x2;

	public Triangulo (int x, int y, int w, int h,Color line, Color background){
        super(x, y,w,h,line,background); 
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.line = line;
		this.background=background;
		int x1[]= {this.x,((this.w)/2) + (this.x),(this.w) + (this.x)};
		int x2[]={this.y, (this.y) - (this.h),this.y};
	 	this.triangle=new Polygon(x1, x2, 3);
    }
	
	public void drag(int x,int y, Point pos){
        this.x += x;
        this.y += y;
		int[] x1= {this.x,((this.w)/2) + (this.x),(this.w) + (this.x)};
		int[] x2={this.y, (this.y) - (this.h),this.y};
        this.triangle = new Polygon(x1, x2, 3);
    }
	
	public boolean contains(MouseEvent evt) {
        if (this.triangle.contains(evt.getPoint())){
            return true;
		}
        return false;
    }

	public void setColor(Color background){
		this.background=background;	
	}
	
	public void print () {
        System.out.format("Triangulo de tamanho (%d,%d) na posicao (%d,%d).\n",this.w, this.h, this.x, this.y);
    }
	
	public void paint (Graphics g, boolean infocus) {
		Graphics2D g2d = (Graphics2D) g;
		if(infocus){
		   g2d.setColor(this.line);
		   g2d.draw(this.triangle);
           g2d.fillPolygon(triangle);
		}
        g2d.setColor(this.line);
        g2d.draw(this.triangle);
        g2d.setColor(this.background);
        g2d.fillPolygon(this.triangle);
	}
}