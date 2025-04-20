package assignment9;

import java.awt.Color;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;

public class Food {

    public static final double FOOD_SIZE = 0.02;
    private double x, y;

    /**
     * Creates a new Food at a random location
     */
    public Food() {
        Random rand = new Random();
        this.x = rand.nextDouble(); // Random x coordinate (0.0 to 1.0)
        this.y = rand.nextDouble(); // Random y coordinate (0.0 to 1.0)
    }

    /**
     * Draws the Food
     */
    public void draw() {
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(x, y, FOOD_SIZE);
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