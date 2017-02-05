import java.util.Random;

class RandomWalk extends Triangule {
  private final int MIN_RANDOM = 1;
  private final int MAX_RANDOM = 2;

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

  private void moveRamdomly() {
    int newHorientation = generateRandomWalk();
    int newDirection    = generateRandomWalk();

    setHorientation(newHorientation);
    setDirection(newDirection);

    checkIfHasReached();
  }

  private int generateRandomWalk() {
    Random rand = new Random();
    return rand.nextInt(MAX_RANDOM) + MIN_RANDOM;
  }

  public void checkIfHasReached() {
    if(isForwards() && (hasReachedMaxHeight() || hasReachedMaxWidth()))
      setDirection(BACKWARDS);

    if(!isForwards() && (hasReachedMinHeight() || hasReachedMinWidth()))
      setDirection(FORWARDS);
  }
}
