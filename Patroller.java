class Patroller extends Triangule {
  private final int CIRCLE_COLOUR = 0;
  private HashMap<Circle, Integer> circles;
  private boolean firstSpot = true;
  
  public Patroller(int width, int height, int colour, int speed) {
    super(width, height, colour, speed);

    circles = new HashMap<Circle, Integer>();

    setHorientation(VERTICAL);
    setDirection(FORWARDS);
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
      addCircle();
      turnRight();
    }
    if(!isForwards() && hasReachedMinHeight()) {
      addCircle();
      turnLeft();
    }
  }

  private void checkHorizontalReached() {
    if(isForwards() && hasReachedMaxWidth()) {
      addCircle();
      setDirection(BACKWARDS);
      turnRight();
    } else if(!isForwards() && hasReachedMinWidth()) {
      addCircle();
      setDirection(FORWARDS);
      turnLeft();
    }
  }

  private void drawCircle() {
    if(circles.isEmpty()) return;

    for(Circle circle : circles.keySet()) {
      fill(CIRCLE_COLOUR);
      ellipse(circle.getXPos(), circle.getYPos(), distanceEdgeToCentre(), distanceEdgeToCentre());
    }
  }

  private void addCircle() {
    if(firstSpot) {
      firstSpot = false;
      return;
    }

    Circle circle = new Circle(getXCentre(), getYCentre());

    if(circles.size() < 4)
      circles.put(circle, 1);
  }
}