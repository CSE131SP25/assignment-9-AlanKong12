package assignment9;
import java.util.LinkedList;
public class Snake {
   private static final double SEGMENT_SIZE = 0.02;
   private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
   private LinkedList<BodySegment> segments;
   private double deltaX;
   private double deltaY;
   public Snake() {
       segments = new LinkedList<>();
       segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE)); // Start in the center
       deltaX = 0;
       deltaY = 0;
   }
   public void changeDirection(int direction) {
       if (direction == 1) { // up
           deltaY = MOVEMENT_SIZE;
           deltaX = 0;
       } else if (direction == 2) { // down
           deltaY = -MOVEMENT_SIZE;
           deltaX = 0;
       } else if (direction == 3) { // left
           deltaY = 0;
           deltaX = -MOVEMENT_SIZE;
       } else if (direction == 4) { // right
           deltaY = 0;
           deltaX = MOVEMENT_SIZE;
       }
   }
   //movnig of snake
   public void move() {
       BodySegment head = segments.getFirst();
       double newX = head.getX() + deltaX;
       double newY = head.getY() + deltaY;
       segments.addFirst(new BodySegment(newX, newY, SEGMENT_SIZE));
       //remove last to simulate movement while keeping constant length
       segments.removeLast();
   }
   public void draw() {
       for (BodySegment segment : segments) {
           segment.draw();
       }
   }
   //eat food calculates distance and confirms food has been eaten
   public boolean eatFood(Food f) {
       BodySegment head = segments.getFirst();
       double distance = Math.sqrt(Math.pow(head.getX() - f.getX(), 2) + Math.pow(head.getY() - f.getY(), 2));
       if (distance < SEGMENT_SIZE + Food.FOOD_SIZE) {
//If that distance is less than the sum of the radii (since both snake segments and food are circles),
    	   //then they are touching/overlapping.
    	  
           BodySegment tail = segments.getLast();
           //A new body segment is added to the end of the snake.

           //It’s placed at the current location of the tail.

           //On the next movement update, this new segment will follow behind smoothly, 
           //making the snake look longer.
           segments.addLast(new BodySegment(tail.getX(), tail.getY(), SEGMENT_SIZE));
           return true;
           //a new segmant is added at same location as tail to extend snake
       }
       return false;
   }//check if snake is in bounds 0.0 - 1.0 (method)
   public boolean isInbounds() {
       BodySegment head = segments.getFirst();
       double x = head.getX();
       double y = head.getY();
       return x >= 0 && x <= 1 && y >= 0 && y <= 1;
   }
   public int getScore() {
       return segments.size() - 1;
   }
}