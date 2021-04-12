package figures;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure {
	int x, y, w, h;
	//Color line, background;

    public Figure (int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public abstract void print();

    public abstract void paint (Graphics g);
}