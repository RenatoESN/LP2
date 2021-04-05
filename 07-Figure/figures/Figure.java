package figures;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure {
	int x, y, w, h;
	Color line, background;
	public abstract void print ();
    public abstract void paint (Graphics g);
}