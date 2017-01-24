class Patroller extends Triangule {
  private boolean isVertical;
  private boolean isForward;
  
  public Patroller(int width, int height, int colour, int speed) {
    super(width, height, colour, speed);
    this.isVertical = checkShorterWay();
    this.isForward = checkShorterOrientation();
  }

  private boolean checkShorterOrientation() {
    return (width - getTrianguleWidth()) < getTrianguleWidth();
  }

  private boolean checkShorterWay() {
    return (height - getTrianguleHeight()) < getTrianguleHeight();
  }

  public void move() {
    checkIfHasReached();
    
    if(isForward) {
      if(isVertical)
        setTrianguleHeight(getTrianguleHeight() + getSpeed());
      else
        setTrianguleWidth(getTrianguleWidth() + getSpeed());
    } else {
      if(isVertical)
        setTrianguleHeight(getTrianguleHeight() - getSpeed());
      else
        setTrianguleWidth(getTrianguleWidth() - getSpeed());
    }
  }

  public void checkIfHasReached() {
    if(isVertical)
      if(isForward) {
        if(!hasReachedMaxHeight()) {
          isVertical = false;
        }
      } else {
        if(!hasReachedMinHeight()) {
          isVertical = false;
        }
      }
    else
      if(isForward) {
        if(!hasReachedMaxWidth()) {
          isForward = false;
          isVertical = true;
        }
      } else {
        if(!hasReachedMinWidth()) {
          isVertical = true;
          isForward = true;
        }
      }
  }
}