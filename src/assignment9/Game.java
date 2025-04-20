package assignment9;

import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class Game {

    private Snake snake;
    private Food food;
    private int speed; // Speed of the game (lower is faster)

    public Game() {
        StdDraw.enableDoubleBuffering();
        snake = new Snake();
        food = new Food();
        speed = 100; // Initial speed (100 ms pause)
    }

    public void play() {
    	//so this is what stops/ keeps the game going 
    	// saying that while the snake is in the bounds continue to move
        while (snake.isInbounds()) { // 1. GAME LOOP CONDITION
            int dir = getKeypress();//gets the user input WASD
            if (dir != -1) { // 3. UPDATE MOVEMENT DIRECTION
                snake.changeDirection(dir);
            }
            snake.move(); // 4. MOVE THE SNAKE
//this is the creative 
            if (snake.eatFood(food)) {
                food = new Food();
                adjustSpeed(); // Increase speed when the snake grows
                // more than just redrawing or changing visuals — 
                //adding interactive gameplay mechanics that directly affect how the game is played:
            }

            updateDrawing();// 6. DRAW EVERYTHING
        }

        // Game over screen
        System.out.println("Game Over! Your Score: " + snake.getScore());
        StdDraw.clear();
        StdDraw.text(0.5, 0.5, "Game Over! Your Score: " + snake.getScore());
        StdDraw.show();
    }
//snake speeds up 
    private void adjustSpeed() {
        // Decrease the pause duration as the snake grows, with a minimum limit
        int length = snake.getScore();
        speed = Math.max(30, 100 - length * 5); // Minimum speed is 30 ms
    }
//Movement of snake
    private int getKeypress() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_W)) return 1;
        if (StdDraw.isKeyPressed(KeyEvent.VK_S)) return 2;
        if (StdDraw.isKeyPressed(KeyEvent.VK_A)) return 3;
        if (StdDraw.isKeyPressed(KeyEvent.VK_D)) return 4;
        return -1;
    }

    private void updateDrawing() {
        StdDraw.clear();
        snake.draw();
        food.draw();
        StdDraw.pause(speed); // Use dynamic speed
        StdDraw.show();
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.play();
    }
}