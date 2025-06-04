package src.fr.training.introduction;

public class Star {
  public static void main(String[] args) {
    printStar(4);
    printTriangle(4);
  }

  /**
   * Dessine un demi-arbre / étoile en ajoutant la chaîne "*" à chaque ligne
   * @param maxWidth
   */
  public static void printStar(int maxWidth) {
    String star = "*";
    int counter = 0;

    while(counter < maxWidth) {
      System.out.println(star);
      
      star += "*";
      counter++;
    }
  }

  /**
   * Dessine un demi-arbre / étoile en itérant sur la hauteur (print() sur la même ligne)
   * @param height
   */
  public static void printTriangle(int height) {
    for (int i = 1; i <= height; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }

      System.out.println();
    }
  }
}
