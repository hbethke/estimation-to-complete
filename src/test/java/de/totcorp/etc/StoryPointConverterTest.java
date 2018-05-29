package de.totcorp.etc;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class StoryPointConverterTest {

  @Test
  public void shouldConvertEinStoryPoint() {
    StoryPointConverter converter = new StoryPointConverter();
    assertTrue(converter.convert(StoryPointConverter.EIN_STORY_POINT) == StoryPointConverter.KLEIN);
  }

  @Test
  public void shouldConvertDreiStoryPoints() {
    StoryPointConverter converter = new StoryPointConverter();
    assertTrue(converter.convert(StoryPointConverter.DREI_STORY_POINTS) == StoryPointConverter.MITTEL);
  }

  @Test
  public void shouldConvertFuenfStoryPoints() {
    StoryPointConverter converter = new StoryPointConverter();
    assertTrue(converter.convert(StoryPointConverter.FUENF_STORY_POINTS) == StoryPointConverter.SCHWER);
  }
}