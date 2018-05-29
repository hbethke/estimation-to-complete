package de.totcorp.etc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static de.totcorp.etc.FertigFilter.ABGESCHLOSSEN;
import static de.totcorp.etc.InDevAndBlockedFilter.IN_BEARBEITUNG;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FertigFilterTest {

  @Test
  public void shouldFilterFertig() {
    List<JiraRecord> records = new ArrayList<>();

    JiraRecord record = new JiraRecord();
    record.setFixVersions(VersionFilter.WG_ONLINE);
    record.setStoryPoints(StoryPointConverter.EIN_STORY_POINT);
    record.setStatus(IN_BEARBEITUNG);
    records.add(record);

    record = new JiraRecord();
    record.setFixVersions(VersionFilter.WG_ONLINE);
    record.setStoryPoints(StoryPointConverter.DREI_STORY_POINTS);
    record.setStatus(ABGESCHLOSSEN);
    records.add(record);

    record = new JiraRecord();
    record.setFixVersions(VersionFilter.WG_ONLINE);
    record.setStoryPoints(StoryPointConverter.DREI_STORY_POINTS);
    record.setStatus("open");
    records.add(record);


    assertThat(FertigFilter.onlyFertigeStories(records).size(), is(1));
  }
}