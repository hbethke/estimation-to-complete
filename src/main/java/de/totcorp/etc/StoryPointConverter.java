package de.totcorp.etc;

public class StoryPointConverter {

  public static String EIN_STORY_POINT = "1.0";
  public static String DREI_STORY_POINTS = "3.0";
  public static String FUENF_STORY_POINTS = "5.0";

  public static float KLEIN = 0.5f;
  public static float MITTEL = 1.5f;
  public static float SCHWER = 3f;

  public float convert(String storyPoints) {
    if (EIN_STORY_POINT.equals(storyPoints)) {
      return KLEIN;
    } else
    if (DREI_STORY_POINTS.equals(storyPoints)) {
      return MITTEL;
    } else
    if (FUENF_STORY_POINTS.equals(storyPoints)) {
      return SCHWER;
    } else {
      throw new RuntimeException("Undefined Story Points size:" + storyPoints);
    }
  }
 }
