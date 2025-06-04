package src.fr.training.introduction;

public class ValeurMax {

  public static void main(String[] args) {
    int[] arrayVal = { 38, 5, 65, 18, 15, -2 };
    int maxValue = getMaxValue(arrayVal);
    System.out.println("- Valeur max: " + maxValue);

    int[] arrayValNegative = { -50, -5, -65, -18, -15, -2, -7 };
    int maxValueNegatives = getMaxValue(arrayValNegative);
    System.out.println("- Valeur max negatives: " + maxValueNegatives);
  }
  
  /**
   * Récupère le nombre le plus grand d'un tableau
   * @param valArray Tableau de nombres
   * @return Le nombre le plus grand du tableau
   */
  public static int getMaxValue(int[] valArray) {
    int maxValue = valArray[0];

    for(int value: valArray) {
      if (value > maxValue) maxValue = value;
    }

    return maxValue;
  }
}
