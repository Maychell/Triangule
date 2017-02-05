public abstract class Triangule {
  protected final int FORWARDS   = 1;
  protected final int BACKWARDS  = 2;
  protected final int VERTICAL   = 1;
  protected final int HORIZONTAL = 2;
  protected final int LEFT_SIDE  = 1;
  protected final int RIGHT_SIDE = 2;
  protected final int DOWN_SIDE  = 3;
  protected final int UP_SIDE    = 4;

  private int tWidth;
  private int tHeight;

  private int colour;
  private int speed;

  private int horientation;
  private int direction;
  private int directionSide;

  private int xSource = width/2;
  private int ySource = height/2;

  private int xPos1 = 10;
  private int yPos1 = 20;
  private int xPos2;
  private int yPos2;
  private int xPos3;
  private int yPos3;
  
  public Triangule(int tWidth, int tHeight, int colour, int speed) {
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
    triangle(xPos1, yPos1, xPos2, yPos2, xPos3, yPos3);
  }

  public abstract void move();

  public abstract void checkIfHasReached();
  
  protected boolean hasReachedMaxHeight() {
    if(isForwards()) {
      return yPos1 + speed >= height;
    } else {
      return yPos2 + speed >= height;
    }
  }

  protected boolean hasReachedMaxWidth() {
    if(isForwards()) {
      return xPos1 + speed >= width;
    } else {
      return xPos2 + speed >= width;
    }
  }

  protected boolean hasReachedMinHeight() {
    if(isForwards()) {
      return yPos1 - speed - distanceEdgeToCentre() <= 0;
    } else {
      return yPos2 - speed - distanceEdgeToCentre() <= 0;
    }
  }

  protected boolean hasReachedMinWidth() {
    if(isForwards()) {
      return xPos1 - speed - distanceEdgeToCentre() <= 0;
    } else {
      return xPos2 - speed - distanceEdgeToCentre() <= 0;
    }
  }

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

  public int distanceEdgeToCentre() {
    int xCentre = getXCentre();
    int yCentre = getYCentre();

    int l = 0;

    if(isVertical()) {
      if((yCentre - yPos1) > 0) {
        l = yCentre - yPos1;
        directionSide = LEFT_SIDE;
      } else {
        l = yPos1 - yCentre;
        directionSide = RIGHT_SIDE;
      }
    } else {
      if((xCentre - xPos1) > 0) {
        l = xCentre - xPos1;
        directionSide = DOWN_SIDE;
      } else {
        l = xPos1 - xCentre;
        directionSide = UP_SIDE;
      }
    }

    return l;
  }

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
    int l = distanceEdgeToCentre();

    xPos1 = isLeft() ? (xCentre - l) : (xCentre + l);
    yPos1 = yCentre;

    xPos2 = isLeft() ? (xPos1 + tHeight) : (xPos1 - tHeight);
    yPos2 = yPos1 + tWidth/2;

    xPos3 = xPos2;
    yPos3 = yPos1 - tWidth/2;

    horientation = HORIZONTAL;
  }

  private void whenHorizontal() {
    int xCentre = getXCentre();
    int yCentre = getYCentre();
    int l = distanceEdgeToCentre();

    xPos1 = xCentre;
    yPos1 = isUp() ? (yCentre - l) : (yCentre + l);

    xPos2 = xPos1 + tWidth/2;
    yPos2 = isUp() ? (yPos1 + tHeight) : (yPos1 - tHeight);

    xPos3 = xPos1 - tWidth/2;
    yPos3 = yPos2;

    horientation = VERTICAL;
  }

  private int getXCentre() { return (xPos1 + xPos2 + xPos3)/3; }

  private int getYCentre() { return (yPos1 + yPos2 + yPos3)/3; }

  protected boolean isVertical() { return horientation == VERTICAL; }

  protected boolean isForwards() { return direction == FORWARDS; }

  protected boolean isLeft() { return directionSide == LEFT_SIDE; }

  protected boolean isUp() { return directionSide == UP_SIDE; }

  // ACESSORS
  public int getHorientation() { return horientation; }

  public void setHorientation(int horientation) { this.horientation = horientation; }

  public int getDirection() { return direction; }

  public void setDirection(int direction) { this.direction = direction; }

  public int getSpeed() { return speed; }
}