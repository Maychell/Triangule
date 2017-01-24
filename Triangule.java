public abstract class Triangule {
  private int trianguleWidth;
  private int trianguleHeight;
  private int colour;
  private int speed;

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

  // TODO
  public int distanceEdgeToCentre() { return 1; }
  protected int getCentre() { return 1; }
  protected void turnRigth() {}
  protected void turnLeft() {}

  // ACESSORS
  public int getSpeed() {
    return speed;
  }

  public int getTrianguleHeight() {
    return trianguleHeight;
  }

  public void setTrianguleHeight(int trianguleHeight) {
    this.trianguleHeight = trianguleHeight;
  }

  public void setTrianguleWidth(int trianguleWidth) {
    this.trianguleWidth = trianguleWidth;
  }

  public int getTrianguleWidth() {
    return trianguleWidth;
  }
}