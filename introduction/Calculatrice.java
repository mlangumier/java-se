package introduction;

public class Calculatrice {
  public static void main(String[] args) {
    int addition = addition(1, 3);
    int soustraction = soustraction(9, 5);
    int multiplication = multiplication(2, 2);
    int division = division(16, 4);

    System.out.printf("- Calculatrice: +(%s), -(%s), *(%s), /(%s)%n", addition, soustraction, multiplication, division);
  }

  /**
   * Additione deux nombres
   * @param firstNbr
   * @param secondNbr
   * @return La somme des deux nombres
   */
  public static int addition(int firstNbr, int secondNbr) {
    return firstNbr + secondNbr;
  }

  /**
   * Soustrait un nombre par un autre
   * @param firstNbr
   * @param secondNbr
   * @return Le résultat de la soustraction des deux nombres
   */
  public static int soustraction(int firstNbr, int secondNbr) {
    return firstNbr - secondNbr;
  }

  /**
   * Multiplie deux nombres
   * @param firstNbr
   * @param secondNbr
   * @return Le résultat de la multiplication des deux nombres
   */
  public static int multiplication(int firstNbr, int secondNbr) {
    return firstNbr * secondNbr;
  }
  
  /**
   * Divise un nombre par un autre
   * @param firstNbr
   * @param secondNbr
   * @return Le résultat de la division des deux nombres
   */
  public static int division(int firstNbr, int secondNbr) {
    return (secondNbr != 0) ? firstNbr / secondNbr : 0;
  }


}
