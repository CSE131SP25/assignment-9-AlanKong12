package assignment9;

import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

    private double x, y, size;
    private Color color;

    public BodySegment(double x, double y, double size) {
        this.x = x;
        this.y = y;
        this.size = size;

        // Assign a default or random color
        this.color = Color.GREEN; // You can replace this with ColorUtils.solidColor();
    }

    /**
     * Draws the segment
     */
    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x, y, size);
    }

    // Getter for X coordinate
    public double getX() {
        return x;
    }

    // Getter for Y coordinate
    public double getY() {
        return y;
    }
}