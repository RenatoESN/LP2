package figures;

import java.awt.*;

public class Hexagon extends Figure{
	private int x, y, w, h;
    private Color line, background;
	private Polygon p = new Polygon();
	
	public Hexagon (int x, int y, int w, int h, Color line, Color background) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.line = line;
        this.background = background;
        
        p.npoints = 5;
        p.xpoints[0] = (int) (x + w*0.25);
        p.xpoints[1] = (int) (x + w*0.75);
        p.xpoints[2] = x + w;
        p.xpoints[3] = (int) (x + w*0.75);
        p.xpoints[4] = (int) (x + w*0.25);

        p.ypoints[0] = y;
        p.ypoints[1] = y;
        p.ypoints[2] = (int) (y + h*0.40);
        p.ypoints[3] = y + h;
        p.ypoints[4] = y + h;

        p.addPoint(x,(int) (y + h*0.40));
    }
	
	private void print () {
        System.out.format("Hexagono de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
	
	public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(line);
        g2d.drawPolygon(p.xpoints, p.ypoints, p.npoints);
        g2d.setColor(background);
        g2d.fillPolygon(p);
    }
}