package de.totcorp.etc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VersionFilter {

  public static String WG_ONLINE = "WG Online";
  public static String WG_RECHNER = "WG Rechner";
  public static String WG_ANTRAG = "WG Antrag";

  public static List<JiraRecord> filterWgOnline(List<JiraRecord> allRecords) {
    return useFilter(WG_ONLINE, allRecords);
  }

  public static List<JiraRecord> filterWgRechner(List<JiraRecord> allRecords) {
    return useFilter(WG_RECHNER, allRecords);
  }

  public static List<JiraRecord> filterWgAntrag(List<JiraRecord> allRecords) {
    return useFilter(WG_ANTRAG, allRecords);
  }

  private static List<JiraRecord> useFilter(String filter, List<JiraRecord> allRecords) {
    List<JiraRecord> filteredJiraRecords = new ArrayList<>();

    Iterator it = allRecords.iterator();
    while(it.hasNext()) {
      JiraRecord record = (JiraRecord) it.next();
      if (record.getFixVersions().equals(filter)) {
        filteredJiraRecords.add(record);
      }
    }
    return filteredJiraRecords;
  }
}
