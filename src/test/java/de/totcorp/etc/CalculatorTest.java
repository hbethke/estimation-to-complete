package de.totcorp.etc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static de.totcorp.etc.FertigFilter.ABGESCHLOSSEN;
import static de.totcorp.etc.InDevAndBlockedFilter.IN_BEARBEITUNG;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {

  @Test
  public void shouldAddEstimates() {
    List<JiraRecord> records = new ArrayList<>();

    JiraRecord record = new JiraRecord();
    record.setFixVersions(VersionFilter.WG_ONLINE);
    record.setStoryPoints(StoryPointConverter.EIN_STORY_POINT);
    records.add(record);

    record = new JiraRecord();
    record.setFixVersions(VersionFilter.WG_ONLINE);
    record.setStoryPoints(StoryPointConverter.DREI_STORY_POINTS);
    records.add(record);

    record = new JiraRecord();
    record.setFixVersions(VersionFilter.WG_ONLINE);
    record.setStoryPoints(StoryPointConverter.FUENF_STORY_POINTS);
    records.add(record);

    Calculator calculator = new Calculator();
    assertThat(calculator.calculateEtc(records), is(5f));
  }
}