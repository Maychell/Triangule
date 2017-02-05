public abstract class Triangule {
  protected final int FORWARDS   = 1;
  protected final int BACKWARDS  = 2;
  protected final int VERTICAL   = 1;
  protected final int HORIZONTAL = 2;

  private int trianguleWidth;
  private int trianguleHeight;
  private int colour;
  private int speed;

  private int horientation;
  private int direction;

  // private int xPos1 = 10;
  // private int yPos1 = 20;
  // private int xPos2;
  // private int yPos2;
  // private int xPos3;
  // private int yPos3;
  
  public Triangule(int width, int height, int colour, int speed) {
    this.trianguleWidth  = width;
    this.trianguleHeight = height;
    this.colour = colour;
    this.speed  = speed;

    // xPos1 = 10;
    // yPos1 = 20;
    // xPos2 = width/2 + xPos1;
    // yPos2 = height + yPos1;
    // xPos3 = width + xPos1;
    // yPos3 = yPos1;
  }

  public void display() {
    fill(colour);
    triangle(trianguleWidth/2, trianguleHeight/2 - 10, trianguleWidth/2 - 10, trianguleHeight/2 + 10, trianguleWidth/2 + 10, trianguleHeight/2 + 10);
    // triangle(xPos1, yPos1, xPos2, yPos2, xPos3, yPos3);
  }

  public abstract void move();

  public abstract void checkIfHasReached();
  
  protected boolean hasReachedMaxHeight() { return trianguleHeight >= height; }

  protected boolean hasReachedMaxWidth() { return trianguleWidth >= width; }

  protected boolean hasReachedMinHeight() { return trianguleHeight <= 0; }

  protected boolean hasReachedMinWidth() { return trianguleWidth <= 0; }

  protected boolean isVertical() { return horientation == VERTICAL; }

  protected boolean isForwards() { return direction == FORWARDS; }

  protected void moveForwards() {
    if(isVertical())
      trianguleHeight += speed;
    else
      trianguleWidth += speed;
  }

  protected void moveBackwards() {
    if(isVertical())
      trianguleHeight -= speed;
    else
      trianguleWidth -= speed;
  }

  // TODO
  public int distanceEdgeToCentre() { return 1; }
  protected int getCentre() { return 1; }
  protected void turnRigth() {}
  protected void turnLeft() {}

  // ACESSORS
  public int getHorientation() { return horientation; }

  public void setHorientation(int horientation) { this.horientation = horientation; }

  public int getDirection() { return direction; }

  public void setDirection(int direction) { this.direction = direction; }

  public int getSpeed() { return speed; }

  public int getTrianguleHeight() { return trianguleHeight; }

  public void setTrianguleHeight(int trianguleHeight) { this.trianguleHeight = trianguleHeight; }

  public void setTrianguleWidth(int trianguleWidth) { this.trianguleWidth = trianguleWidth; }

  public int getTrianguleWidth() { return trianguleWidth; }
}