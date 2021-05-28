package figures;
import java.awt.event.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.*;
import java.io.Serializable;
import ivisible.IVisible;

public abstract class Figure implements IVisible,Serializable {
    public int x, y;
    public int w, h;
	public Color line, background;
    public boolean infocus;

    public  Figure (int x, int y, int w, int h, Color line, Color background) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.line=line;
		this.background=background;
		this.infocus=false;
    }

    public void drag (int dx, int dy, Point p) {
        this.x += dx;
        this.y += dy;
    }
	
    public abstract boolean contains(MouseEvent evt);
	public abstract void setColor(Color b);
	public abstract void print ();
}