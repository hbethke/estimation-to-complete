package de.totcorp.etc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FertigFilter {

  public static final String ABGESCHLOSSEN = "abgeschlossen";
  public static final String BEARBEITET = "bearbeitet";

  public static List<JiraRecord> onlyFertigeStories(List<JiraRecord> records) {
    List<JiraRecord> fertigeRecords = new ArrayList<JiraRecord>();
    Iterator<JiraRecord> it = records.iterator();
    while (it.hasNext()) {
      JiraRecord record = it.next();
      if (ABGESCHLOSSEN.equals(record.getStatus().toLowerCase()) || BEARBEITET.equals(record.getStatus().toLowerCase())) {
        fertigeRecords.add(record);
      }
    }
    return fertigeRecords;
  }
}
