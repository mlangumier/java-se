package src.fr.training.algorithm_optimisation.inverted_string;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static DecimalFormat df = new DecimalFormat("###,###,###");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez une chaîne : ");
        String texte = sc.nextLine();

        // Exemple 1 : "This is a sentence"
        // Exemple 2 : "This is a very long sentence that will write the word "sentence"  a few times so I can look for the word "sentence" afterwards."
        String nouvelleChaine = inverseChaine(texte);                                               // 4,804,352 ns     // 5,313,255 ns
        String nouvelleChaineOptimisee = inverseChaineOptimisee(texte);                             // 242,233 ns       // 671,507 ns
        String nouvelleChaineOptimiseeStringBuilder = inverseChaineOptimiseeStringBuilder(texte);   // 33,472 ns        // 54,532 ns
        String nouvelleChaineOptimisee2 = inverseChaineOptimisee2(texte);                           // 8,816 ns         // 15,999 ns
        String nouvelleChaineOptimiseeNoTemp = inverseChaineOptimiseeStringNoTemp(texte);           // 3,155 ns         // 9,989 ns


        System.out.printf("Chaîner inversée : %s / %s / %s / %s. %n", nouvelleChaine, nouvelleChaineOptimisee, nouvelleChaineOptimisee2, nouvelleChaineOptimiseeStringBuilder, nouvelleChaineOptimiseeNoTemp);
    }

    public static String inverseChaine(String texte) {
        long debut = System.nanoTime();

        String inverse = "";
        for (int i = 0; i < texte.length(); i++) {
            inverse = inverse + texte.charAt(texte.length() - i - 1);
        }

        long fin = System.nanoTime();
        System.out.printf("(old) Temps d'exécution : %s ns %n",df.format((fin - debut)));
        return inverse;
    }

    public static String inverseChaineOptimisee(String texte) {
        long debut = System.nanoTime();

        String inverse = "";
        for (int i = texte.length() -1 ; i >= 0; i--) {
            inverse += texte.charAt(i);
        }

        long fin = System.nanoTime();

        System.out.printf("(new) Temps d'exécution : %s ns %n", df.format(fin - debut));
        return inverse;
    }

    public static String inverseChaineOptimisee2(String texte) {
        long debut = System.nanoTime();

        char[] texteChars = texte.toCharArray();
        int arrLength = texteChars.length;

        for (int i = 0; i < arrLength / 2; i++) {
            int reversedId = arrLength -1 -i;
            char temp = texteChars[i];
            texteChars[i] = texteChars[reversedId];
            texteChars[reversedId] = temp;
        }

        String reversed = new String (texteChars);

        long fin = System.nanoTime();
        System.out.printf("(new-2) Temps d'exécution : %s ns %n",df.format((fin - debut)));
        return reversed;
    }

    public static String inverseChaineOptimiseeStringBuilder(String texte) {
        long debut = System.nanoTime();

        StringBuilder stringBuilder = new StringBuilder(texte);
        stringBuilder.reverse();
        String inverse = stringBuilder.toString();

        long fin = System.nanoTime();

        System.out.printf("(StrB) Temps d'exécution : %s ns %n", df.format(fin - debut));
        return inverse;
    }

    public static String inverseChaineOptimiseeStringNoTemp(String texte) {
        long debut = System.nanoTime();

        char[] inverse = new char[texte.length()];
        for (int i = texte.length() - 1; i >= 0; i--) {
            inverse[(texte.length() - 1) - i] = texte.charAt(i);
        }

        long fin = System.nanoTime();

        System.out.printf("(new) Temps d'exécution : %s ns %n", df.format(fin - debut));
        return new String (inverse);
    }
}
