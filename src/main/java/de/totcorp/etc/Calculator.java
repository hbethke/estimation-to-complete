package de.totcorp.etc;

import java.util.Iterator;
import java.util.List;

public class Calculator {

  public static Float calculateEtc(List<JiraRecord> records) {
    Float estimation = new Float(0);
    Iterator<JiraRecord> it = records.iterator();
    while (it.hasNext()) {
      JiraRecord record = it.next();
      estimation = estimation + new StoryPointConverter().convert(record.getStoryPoints());
    }
    return estimation;
  }
}
