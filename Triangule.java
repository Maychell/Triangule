public abstract class Triangule {
  private int trianguleWidth;
  private int trianguleHeight;
  private int colour;
  private int speed;
  
  public Triangule(int width, int height, int colour, int speed) {
    this.trianguleWidth  = width;
    this.trianguleHeight = height;
    this.colour = colour;
    this.speed  = speed;
  }

  public void display() {
    fill(colour);
    triangle(trianguleWidth/2, trianguleHeight/2 - 10, trianguleWidth/2 - 10, trianguleHeight/2 + 10, trianguleWidth/2 + 10, trianguleHeight/2 + 10);
  }

  public abstract void move();

  public abstract void checkIfHasReached();
  
  protected boolean hasReachedMaxHeight() { return trianguleHeight >= height; }

  protected boolean hasReachedMaxWidth() { return trianguleWidth >= width; }

  protected boolean hasReachedMinHeight() { return trianguleHeight <= 0; }

  protected boolean hasReachedMinWidth() { return trianguleWidth <= 0; }

  /**
  * TODO
  **/
  public int distanceEdgeToCentre() { return 1; }
  
  /**
  * TODO
  **/
  protected int getCentre() { return 1; }

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