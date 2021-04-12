package figures;

import java.awt.*;
import java.awt.geom.Line2D;

public class Line extends Figure {
    int x, y;
    int w, h;
    public Line (int x, int y, int w, int h){
        super(x, y, w, h);
    }

    public void print () {
        System.out.format("Linha na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(new Line2D.Double(this.x, this.y, this.w, this.h));
    }
}
