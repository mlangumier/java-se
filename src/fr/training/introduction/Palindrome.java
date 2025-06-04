package src.fr.training.introduction;

public class Palindrome {
  public static void main(String[] args) {
    System.out.println(isPalindrome("radar")); // true
    System.out.println(isPalindrome("java"));  // false
  }

  /**
   * Vérifie si une chaîne de caractère est un palindrom (s'écrit de la même façon dans les deux sens)
   * @param mot
   * @return { boolean } Si le mot est un palindrome ou non
   */
  public static boolean isPalindrome(String mot) {
    //--- On set nos deux compteurs 
    int i = 0;                // i = part du début du mot & incrémente
    int j = mot.length() - 1; // j = part de la fin du mot & décrémente

    //--- On boucle sur la chaîne de caractère, et on vérifie si les deux compteurs ont la même valeur 
    while (i < j) {
        if (mot.charAt(i) != mot.charAt(j)) return false;
        i++;
        j--;
    }
    return true;
}

}
