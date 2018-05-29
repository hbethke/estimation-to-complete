package de.totcorp.etc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class VersionFilterTest {

  @Test
  public void shouldFilterWgOnline() throws Exception {
    JiraRecord record = new JiraRecord();
    record.setFixVersions(VersionFilter.WG_ONLINE);
    List<JiraRecord> records = new ArrayList<>();
    records.add(record);

    VersionFilter filter = new VersionFilter();
    assertTrue(filter.filterWgOnline(records).size() == 1);
  }

}