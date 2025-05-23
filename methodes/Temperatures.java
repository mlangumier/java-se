package methodes;

import java.time.DayOfWeek;
import java.util.Locale;
import java.util.Scanner;

public class Temperatures {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US); // Allows to enter decimals with a `dot` instead of a `comma` in the terminal

    
    System.out.println();
    
    // double[] weeklyReadings = { 12.5, 14.2, 13.0, 11.8, 15.6, 16.3, 14.9 };
    double[] weeklyReadings = createReadings();

    System.out.println("--- Readings: " + displayReadings(weeklyReadings));
    System.out.println("- Average temp: " + calcAverageTemp(weeklyReadings));
    // System.out.println("- Highest temp: " + getMaxTemp(weeklyReadings));
    // System.out.println("- Lowest temp: " + getMinTemp(weeklyReadings));
    System.out.println(getMinMaxTemps(weeklyReadings));
    System.out.println("- Days above temp: " + getDaysAboveTemp(weeklyReadings));
    
    System.out.println();
  }

  /**
   * Asks the user to enter temperature readings for each week day
   * @return A list of temperature readings
   */
  public static double[] createReadings() {
    Scanner scanner = new Scanner(System.in);
    double[] readings = new double[7]; // Need to define the length of primitive type double[] (fixed memory attribution, != List<> with dynamic memory attribution)

    System.out.println("--- Enter your weekly readings: ");

    for (int i = 0; i < readings.length; i++) {
      System.out.print("- " + DayOfWeek.of(i + 1) + ": ");
      readings[i] = scanner.nextDouble();
    }

    scanner.close();
    return readings;
  }

  /**
   * Displays temperature readings
   * @param readings List of temperatures
   */
  public static String displayReadings(double[] readings) {
  StringBuilder stringBuilder = new StringBuilder();

    for (double reading: readings) {
      stringBuilder.append(reading + " ");
    }

    return stringBuilder.toString();
  }

  /**
   * Calculates the average temperature of the readings
   * @param readings List of temperatures
   * @return The value of the average temperature of the readings
   */
  public static double calcAverageTemp(double[] readings) {
    double sum = 0;

    for(double reading: readings) {
      sum+= reading;
    }

    return Math.round((sum / readings.length) * 10.0) / 10.0; // (keep one decimal)
  }

  /**
   * Finds the highest temperature in the list
   * @param readings List of temperatures
   * @return The highest temperature
   */
  public static double getMaxTemp(double[] readings) {
    double maxTemp = readings[0];

    for(double reading: readings) {
      if (maxTemp < reading) maxTemp = reading;
    }

    return maxTemp;
  } 

  /**
   * Finds the lowest temperature in the list
   * @param readings List of temperatures
   * @return The lowest temperature
   */
  public static double getMinTemp(double[] readings) {
    double maxTemp = readings[0];

    for (double reading: readings) {
      if (maxTemp > reading) maxTemp = reading;
    }

    return maxTemp;
  }

  /**
   * Gets and displays the highest and lowest temperatures in the list
   * @param readings List of temperatures
   * @return The highest and lowest temperatures
   */
  public static String getMinMaxTemps(double[] readings) {
    return String.format("- Highest temp: %s %n- Lowest temp: %s", getMaxTemp(readings), getMinTemp(readings));
  }

  /**
   * Gets the days when the temperature was superior to the compared value
   * @param readings List of temperatures
   * @param tempCheck Temperature to compare the list elements to
   * @return Days when the temperature is superior to the compared value
   */
  public static String getDaysAboveTemp(double[] readings) {
    StringBuilder stringBuilder = new StringBuilder();
    Scanner scanner = new Scanner(System.in);
    double tempCheck;

    System.out.print("- Check days above temperature: ");
    tempCheck = scanner.nextDouble();

    for(int i = 0; i < readings.length; i++) {

      if(readings[i] > tempCheck) stringBuilder.append((stringBuilder.length() > 0 ? ", " : "") + DayOfWeek.of(i + 1));
    }

    scanner.close();

    if (stringBuilder.length() > 0) return stringBuilder.toString();
    else return String.format("(None. Max temp: %s°)", getMaxTemp(readings));
  } 

}
