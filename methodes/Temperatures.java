package methodes;

import java.time.DayOfWeek;

public class Temperatures {
  private static double[] weeklyReadings = { 12.5, 14.2, 13.0, 11.8, 15.6, 16.3, 14.9 };

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

    for (int i = 0; i < readings.length; i++) {
      if (maxTemp < readings[i]) maxTemp = readings[i];
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

    for (int i = 0; i < readings.length; i++) {
      if (maxTemp > readings[i]) maxTemp = readings[i];
    }

    return maxTemp;
  }

  /**
   * Gets and formats the highest and lowest temperatures in the list
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
  public static String getDaysAboveTemp(double[] readings, double tempCheck) {
    StringBuilder stringBuilder = new StringBuilder();

    for(int i = 0; i < readings.length; i++) {
      if(readings[i] > tempCheck) stringBuilder.append((stringBuilder.length() > 0 ? ", " : "") + DayOfWeek.of(i+1)); // Find how to get day from Weekday[i];
    }

    return stringBuilder.toString();
  } 

  /**
   * Tests and displays results of above methods
   * @param args
   */
  public static void main(String[] args) {
    System.out.println();
    System.out.println("--- Readings: " + displayReadings(weeklyReadings));
    System.out.println("- Average temp: " + calcAverageTemp(weeklyReadings));
    // System.out.println("- Highest temp: " + getMaxTemp(weeklyReadings));
    // System.out.println("- Lowest temp: " + getMinTemp(weeklyReadings));
    System.out.println(getMinMaxTemps(weeklyReadings));
    System.out.println("- Days above temp: " + getDaysAboveTemp(weeklyReadings, 15));
    System.out.println();
  }
}
