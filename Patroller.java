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
    if((isForwards() && hasReachedMaxHeight()) || (!isForwards() && hasReachedMinHeight())) {
      setHorientation(HORIZONTAL);
      addCircle();
    }
  }

  private void checkHorizontalReached() {
    if(isForwards() && hasReachedMaxWidth()) {
      setDirection(BACKWARDS);
      setHorientation(VERTICAL);
      addCircle();
    } else if(!isForwards() && hasReachedMinWidth()) {
      setDirection(FORWARDS);
      setHorientation(VERTICAL);
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
    Circle circle = new Circle(getTrianguleWidth(), getTrianguleHeight());

    if(!circles.containsKey(circle))
      circles.put(circle, 1);
  }

  private void setShorterHorientation() {
    setHorientation(isVerticalShorter() ? VERTICAL : HORIZONTAL);
  }

  private void setShorterDirection() {
    setDirection(isForwarsShorter() ? FORWARDS : BACKWARDS);
  }

  private boolean isVerticalShorter() {
    return (width - getTrianguleWidth()) < getTrianguleWidth();
  }

  private boolean isForwarsShorter() {
    return (height - getTrianguleHeight()) < getTrianguleHeight();
  }
}