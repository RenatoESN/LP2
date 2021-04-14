package figures;

import java.awt.*;

public class Triangle extends Figure{
    int x, y;
    int w, h;
    Polygon triangulo = new Polygon();

    public Triangle (int x, int y, int w, int h){
        super(x, y, w, h);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = 0;

        triangulo.npoints = 3;
        triangulo.xpoints[0] = x;
        triangulo.xpoints[1] = y;
        triangulo.xpoints[2] = w;

        triangulo.ypoints[0] = y;
        triangulo.ypoints[1] = w;
        triangulo.ypoints[2] = y;

    }

    public void print(){
        System.out.format("Triangulo de base (%d, %d)", this.x, this.y);
    }
    
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawPolygon(triangulo.xpoints, triangulo.ypoints, triangulo.npoints);
    }
}
