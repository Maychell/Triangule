import java.util.Random;

class RandomWalk extends Triangule {
  private final int FORWARDS   = 1;
  private final int BACKWARDS  = 2;
  private final int VERTICAL   = 1;
  private final int HORIZONTAL = 2;
  private final int MIN_RANDOM = 1;
  private final int MAX_RANDOM = 2;

  private int horientation;
  private int direction;

  public RandomWalk(int width, int height, int colour, int speed) {
    super(width, height, colour, speed);
  }

  public void move() {
    moveRamdomly();

    if(isForwards())
      moveForwards();
    else
      moveBackwards();
  }

  private void moveForwards() {
    if(isVertical())
      setTrianguleHeight(getTrianguleHeight() + getSpeed());
    else
      setTrianguleWidth(getTrianguleWidth() + getSpeed());
  }

  private void moveBackwards() {
    if(isVertical())
      setTrianguleHeight(getTrianguleHeight() - getSpeed());
    else
      setTrianguleWidth(getTrianguleWidth() - getSpeed());
  }

  private void moveRamdomly() {
    int newHorientation = generateRandomWalk();
    int newDirection    = generateRandomWalk();

    // if(newHorientation != horientation)
      horientation = newHorientation; // turnHorientation();

    // if(newDirection != direction)
      direction = newDirection; // turnAround();

      checkIfHasReached();
  }

  private int generateRandomWalk() {
    Random rand = new Random();
    return rand.nextInt(MAX_RANDOM) + MIN_RANDOM;
  }

  private boolean isVertical() {
    return horientation == VERTICAL;
  }

  private boolean isForwards() {
    return direction == FORWARDS;
  }

  public void checkIfHasReached() {
    if(isForwards() && (hasReachedMaxHeight() || hasReachedMaxWidth()))
      direction = BACKWARDS;

    if(!isForwards() && (hasReachedMinHeight() || hasReachedMinWidth()))
      direction = FORWARDS;
  }
}
