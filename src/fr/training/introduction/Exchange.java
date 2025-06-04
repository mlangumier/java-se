package src.fr.training.introduction;

public class Exchange {
  public static void main(String[] args) {
      int[] tab = {10, 20, 30};
      echanger(tab, 0, 2);

      System.out.print("- New values: ");
      for (int val : tab) {
          System.out.print(val + ", ");
      }
  }

  public static void echanger(int[] tab, int i, int j) {
    int temp = tab[i];
    tab[i] = tab[j];
    tab[j] = temp;
  }

}
