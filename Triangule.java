public abstract class Triangule {
  protected final int FORWARDS   = 1;
  protected final int BACKWARDS  = 2;
  protected final int VERTICAL   = 1;
  protected final int HORIZONTAL = 2;

  private int tWidth;
  private int tHeight;

  // private int trianguleHeight;
  private int colour;
  private int speed;

  private int horientation;
  private int direction;

  private int xSource = width/2;
  private int ySource = height/2;

  private int xPos1 = 10;
  private int yPos1 = 20;
  private int xPos2;
  private int yPos2;
  private int xPos3;
  private int yPos3;
  
  public Triangule(int tWidth, int tHeight, int colour, int speed) {
    // this.trianguleHeight = tHeight;
    this.colour = colour;
    this.speed  = speed;

    this.tWidth  = tWidth;
    this.tHeight = tHeight;

    xPos1 = xSource + tWidth/2;
    yPos1 = ySource + tHeight;

    xPos2 = xSource;
    yPos2 = ySource;
    
    xPos3 = xSource + tWidth;
    yPos3 = yPos2;
  }

  public void display() {
    fill(colour);
    // triangle(trianguleWidth/2, trianguleHeight/2 - 10, trianguleWidth/2 - 10, trianguleHeight/2 + 10, trianguleWidth/2 + 10, trianguleHeight/2 + 10);
    triangle(xPos1, yPos1, xPos2, yPos2, xPos3, yPos3);
  }

  public abstract void move();

  public abstract void checkIfHasReached();
  
  protected boolean hasReachedMaxHeight() {
    if(isForwards()) {
      return yPos1 >= height;
    } else {
      return yPos2 >= height;
    }

    // return trianguleHeight >= height;
  }

  protected boolean hasReachedMaxWidth() {
    if(isForwards()) {
      return xPos1 >= width;
    } else {
      return xPos2 >= width;
    }

    // return trianguleWidth >= width;
  }

  protected boolean hasReachedMinHeight() {
    if(isForwards()) {
      return yPos1 <= 0;
    } else {
      return yPos2 <= 0;
    }

    // return trianguleHeight <= 0;
  }

  protected boolean hasReachedMinWidth() {
    if(isForwards()) {
      return xPos1 <= 0;
    } else {
      return xPos2 <= 0;
    }

    // return trianguleWidth <= 0;
  }

  protected boolean isVertical() { return horientation == VERTICAL; }

  protected boolean isForwards() { return direction == FORWARDS; }

  protected void moveForwards() {
    if(isVertical()) {
      yPos1 += speed;
      yPos2 += speed;
      yPos3 += speed;
    } else {
      xPos1 += speed;
      xPos2 += speed;
      xPos3 += speed;
    }
  }

  protected void moveBackwards() {
    if(isVertical()) {
      yPos1 -= speed;
      yPos2 -= speed;
      yPos3 -= speed;
    } else {
      xPos1 -= speed;
      xPos2 -= speed;
      xPos3 -= speed;
    }
  }

  // TODO
  public int distanceEdgeToCentre() { return 1; }

  private int getXCentre() { return (xPos1 + xPos2 + xPos3)/3; }

  private int getYCentre() { return (yPos1 + yPos2 + yPos3)/3; }

  protected void turnLeft() {
    if(isVertical())
      whenVertical();
    else
      whenHorizontal();
  }

  protected void turnRight() {
    if(isVertical())
      whenVertical();
    else
      whenHorizontal();
  }

  private void whenVertical() {
    int xCentre = getXCentre();
    int yCentre = getYCentre();

    int l;
    boolean goLeft;

    if((yCentre - yPos1) > 0) {
      l = yCentre - yPos1;
      goLeft = true;
    } else {
      l = yPos1 - yCentre;
      goLeft = false;
    }

    xPos1 = goLeft ? (xCentre - l) : (xCentre + l);
    yPos1 = yCentre;

    xPos2 = goLeft ? (xPos1 + tHeight) : (xPos1 - tHeight);
    yPos2 = yPos1 + tWidth/2;

    xPos3 = goLeft ? (xPos1 + tHeight) : (xPos1 - tHeight);
    yPos3 = yPos1 - tWidth/2;

    horientation = HORIZONTAL;
  }

  private void whenHorizontal() {
    int xCentre = getXCentre();
    int yCentre = getYCentre();

    int l;
    boolean goUp = false;

    if((xCentre - xPos1) > 0) {
      l = xCentre - xPos1;
      goUp = false;
    } else {
      l = xPos1 - xCentre;
      goUp = true;
    }

    xPos1 = xCentre;
    yPos1 = goUp ? (yCentre - l) : (yCentre + l);

    xPos2 = xPos1 + tWidth/2;
    yPos2 = goUp ? (yPos1 + tHeight) : (yPos1 - tHeight);

    xPos3 = xPos1 - tWidth/2;
    yPos3 = goUp ? (yPos1 + tHeight) : (yPos1 - tHeight);

    horientation = VERTICAL;
  }

  // ACESSORS
  public int getHorientation() { return horientation; }

  public void setHorientation(int horientation) { this.horientation = horientation; }

  public int getDirection() { return direction; }

  public void setDirection(int direction) { this.direction = direction; }

  public int getSpeed() { return speed; }

  // public int getTrianguleHeight() { return trianguleHeight; }

  // public void setTrianguleHeight(int trianguleHeight) { this.trianguleHeight = trianguleHeight; }
}