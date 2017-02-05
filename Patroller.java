class Patroller extends Triangule {
  private boolean isVertical;
  private boolean isForwards;
  private HashMap<Circle, Integer> circles;
  
  public Patroller(int width, int height, int colour, int speed) {
    super(width, height, colour, speed);
    isVertical = getShorterCordinate();
    isForwards = getShorterOrientation();
    circles = new HashMap<Circle, Integer>();
  }

  private boolean getShorterOrientation() {
    return (width - getTrianguleWidth()) < getTrianguleWidth();
  }

  private boolean getShorterCordinate() {
    return (height - getTrianguleHeight()) < getTrianguleHeight();
  }

  public void move() {
    checkIfHasReached();
    
    if(isForwards)
      moveForwards();
    else
      moveBackwards();

    drawCircle();
  }

  private void drawCircle() {
    if(!circles.isEmpty()) {
      for(Circle circle : circles.keySet()) {
        fill(0); // BLACK colour
        ellipse(circle.getXPos(), circle.getYPos(), 100, 100);
      }
    }
  }

  private void addCircle() {
    Circle circle = new Circle(getTrianguleWidth(), getTrianguleHeight());

    if(!circles.containsKey(circle))
      circles.put(circle, 1);
  }

  private void moveForwards() {
    if(isVertical)
      setTrianguleHeight(getTrianguleHeight() + getSpeed());
    else
      setTrianguleWidth(getTrianguleWidth() + getSpeed());
  }

  private void moveBackwards() {
    if(isVertical)
      setTrianguleHeight(getTrianguleHeight() - getSpeed());
    else
      setTrianguleWidth(getTrianguleWidth() - getSpeed());
  }

  public void checkIfHasReached() {
    if(isVertical)
      checkVerticalReached();
    else
      checkHorizontalReached();
  }

  private void checkVerticalReached() {
    if((isForwards && hasReachedMaxHeight()) || (!isForwards && hasReachedMinHeight())) {
      isVertical = false;
      addCircle();
    }
  }

  private void checkHorizontalReached() {
    if(isForwards && hasReachedMaxWidth()) {
      isForwards  = false;
      isVertical = true;
      addCircle();
    } else if(!isForwards && hasReachedMinWidth()) {
      isForwards  = true;
      isVertical = true;
      addCircle();
    }
  }
}