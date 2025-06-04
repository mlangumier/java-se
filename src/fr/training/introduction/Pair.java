package src.fr.training.introduction;

public class Pair {
  public static void main(String[] args) {
    boolean estPair = estPair(17);
    System.out.println("- Est pair: " + estPair);
  }

  /**
   * Vérifie si un nombre est pair ou non
   * @param value
   * @return {true} si un nombre est pair, {false} si un nombre est impair
   */
  public static boolean estPair(int value) {
    return value % 2 == 0;
  }
}