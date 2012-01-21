package net.timandersen;

public class Stopwatch {

  private static long beginTime = System.currentTimeMillis();

  public static void start() {
    beginTime = System.currentTimeMillis();
  }

  public static long elapsedTime() {
    long currentTime = System.currentTimeMillis();
    long elapsedTime = currentTime - beginTime;
    return elapsedTime;
  }

}
