package figures;

import java.awt.*;

public class Line extends Figure {
    int x, y;
    int w, h;
    public Line (int x, int y, int w, int h){
        super(x, y, w, h);
    }
    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(this.x,this.y, this.w,this.h);
    }
}
