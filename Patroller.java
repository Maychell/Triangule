class Patroller extends Triangule {
  private boolean isVertical;
  private boolean isForwards;
  
  public Patroller(int width, int height, int colour, int speed) {
    super(width, height, colour, speed);
    this.isVertical = getShorterCordinate();
    this.isForwards = getShorterOrientation();
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
    if((isForwards && hasReachedMaxHeight()) || (!isForwards && hasReachedMinHeight()))
      isVertical = false;
  }

  private void checkHorizontalReached() {
    if(isForwards && hasReachedMaxWidth()) {
      isForwards  = false;
      isVertical = true;
    } else if(!isForwards && hasReachedMinWidth()) {
      isForwards  = true;
      isVertical = true;
    }
  }
}