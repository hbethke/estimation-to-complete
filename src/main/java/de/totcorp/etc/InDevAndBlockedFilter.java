package de.totcorp.etc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InDevAndBlockedFilter {

  public static final String IN_BEARBEITUNG = "in bearbeitung";

  public static List<JiraRecord> onlyBlockedInDevStories(List<JiraRecord> records) {
    List<JiraRecord> inDevRecords = new ArrayList<JiraRecord>();
    Iterator<JiraRecord> it = records.iterator();
    while (it.hasNext()) {
      JiraRecord record = it.next();
      if (IN_BEARBEITUNG.equals(record.getStatus().toLowerCase())) {
        inDevRecords.add(record);
      }
    }
    return inDevRecords;
  }
}
