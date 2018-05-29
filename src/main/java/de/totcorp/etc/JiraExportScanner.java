package de.totcorp.etc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class JiraExportScanner {

  public List<JiraRecord> scan(File file) throws IOException {

    BufferedReader reader = new BufferedReader(new FileReader(file));
    // read file line by line
    String line = null;
    Scanner scanner = null;
    int index = 0;
    List<JiraRecord> jiraRecords = new ArrayList<>();
    reader.readLine(); // skip first header line

    while ((line = reader.readLine()) != null) {
      JiraRecord record = new JiraRecord();
      scanner = new Scanner(line);
      scanner.useDelimiter(",");
      while (scanner.hasNext()) {
        String data = scanner.next();
        if (index == 0)
          record.setIssueType(data);
        else if (index == 1)
          record.setIssueKey(data);
        else if (index == 2)
          record.setIssueId(data);
        else if (index == 3)
          record.setParentId(data);
        else if (index == 4)
          record.setSummary(data);
        else if (index == 5)
          record.setAssignee(data);
        else if (index == 6)
          record.setPriority(data);
        else if (index == 7)
          record.setStatus(data);
        else if (index == 8)
          record.setResolution(data);
        else if (index == 9)
          record.setUpdated(data);
        else if (index == 10)
          record.setStoryPoints(data);
        else if (index == 11)
          record.setLabels(data);
        else if (index == 12)
          record.setFixVersions(data);
        else
          System.out.println("invalid data::" + data);
        index++;
      }
      index = 0;
      jiraRecords.add(record);
    }
    reader.close();
    return jiraRecords;
  }
}
