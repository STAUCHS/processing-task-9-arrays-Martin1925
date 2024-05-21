import processing.core.PApplet;

public class Sketch extends PApplet {

  // Related arrays for the (x, y) coordinate of the snowflake
  float[] snowX = new float[42];
  float[] snowY = new float[42];
  int snowDiameter = 10;

  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;

float circleX = 150;
float circleY = 150;

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(0);
    //Generate the snowfall
    for (int i = 0; i < snowX.length; i++) {
      snowX[i] = random(width);
      snowY[i] = random(height);
    }
    // Draw snow
    snowfall();
  }

  public void draw() {
  background(0);
  snowfall();
  if (upPressed) {
    circleY--;
  }
  if (downPressed) {
    circleY++;
  }
  if (leftPressed) {
    circleX--;
  }
  if (rightPressed) {
    circleX++;
  }

  ellipse(circleX, circleY, 25, 25);
  }
  
  // All other defined methods are written below:
  public void snowfall() {
    for (int i = 0; i < snowX.length; i++) {
      circle(snowX[i], snowY[i], snowDiameter);

      snowY[i] += 2;

  // Resets snowflakes
      if (snowY[i] > height) {
        snowY[i] = 0;
        snowX[i] = random(width);
      }
    }
  }

  public void keyPressed() {
    if (keyCode == UP) {
      upPressed = true;
    }
    else if (keyCode == DOWN) {
      downPressed = true;
    }
    else if (keyCode == LEFT) {
      leftPressed = true;
    }
    else if (keyCode == RIGHT) {
      rightPressed = true;
    }
    
  }
  
  public void keyReleased() {
    if (keyCode == UP) {
      upPressed = false;
    }
    else if (keyCode == DOWN) {
      downPressed = false;
    }
    else if (keyCode == LEFT) {
      leftPressed = false;
    }
    else if (keyCode == RIGHT) {
      rightPressed = false;
    }
  }
}