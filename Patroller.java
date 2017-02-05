class Patroller extends Triangule {
  private final int CIRCLE_COLOUR = 0;
  private HashMap<Circle, Integer> circles;
  
  public Patroller(int width, int height, int colour, int speed) {
    super(width, height, colour, speed);

    circles = new HashMap<Circle, Integer>();

    setShorterHorientation();
    setShorterDirection();
  }

  public void move() {
    checkIfHasReached();
    
    if(isForwards())
      moveForwards();
    else
      moveBackwards();

    drawCircle();
  }

  public void checkIfHasReached() {
    if(isVertical())
      checkVerticalReached();
    else
      checkHorizontalReached();
  }

  private void checkVerticalReached() {
    if((isForwards() && hasReachedMaxHeight())) {
      // setHorientation(HORIZONTAL);
      turnRight();
      addCircle();
    }
    if(!isForwards() && hasReachedMinHeight()) {
      turnLeft();
      addCircle();
    }
  }

  private void checkHorizontalReached() {
    if(isForwards() && hasReachedMaxWidth()) {
      setDirection(BACKWARDS);
      // setHorientation(VERTICAL);
      turnRight();
      addCircle();
    } else if(!isForwards() && hasReachedMinWidth()) {
      setDirection(FORWARDS);
      // setHorientation(VERTICAL);
      turnLeft();
      addCircle();
    }
  }

  private void drawCircle() {
    if(circles.isEmpty()) return;

    for(Circle circle : circles.keySet()) {
      fill(CIRCLE_COLOUR);
      ellipse(circle.getXPos(), circle.getYPos(), 100, 100);
    }
  }

  private void addCircle() {
    int xPosition = -1;
    int yPosition = -1;

    if(hasReachedMaxWidth()) {
      xPosition = width;
      yPosition = getYPosition();
    }

    if(hasReachedMinWidth()) {
      xPosition = 0;
      yPosition = getYPosition();
    }

    if(xPosition == -1 || yPosition == -1) return;

    Circle circle = new Circle(xPosition, yPosition);

    if(!circles.containsKey(circle))
      circles.put(circle, 1);
  }

  private int getYPosition() {
    if(hasReachedMinHeight())
      return 0;
    else if(hasReachedMaxHeight())
      return height;
    return -1;
  }

  private void setShorterHorientation() {
    setHorientation(isVerticalShorter() ? VERTICAL : HORIZONTAL);
  }

  private void setShorterDirection() {
    setDirection(isForwarsShorter() ? FORWARDS : BACKWARDS);
  }

  private boolean isVerticalShorter() {
    return true;

    // return (width - getTrianguleWidth()) < getTrianguleWidth();
  }

  private boolean isForwarsShorter() {
    return true;

    // return (height - getTrianguleHeight()) < getTrianguleHeight();
  }
}