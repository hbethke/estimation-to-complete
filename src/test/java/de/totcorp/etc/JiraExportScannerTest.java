package de.totcorp.etc;

import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class JiraExportScannerTest {

  @Test
  public void shouldScanFile() throws Exception {
    URL resource = this.getClass().getResource("/jira-export.csv");
    File file = new File(resource.toURI());

    JiraExportScanner scanner = new JiraExportScanner();
    List<JiraRecord> jiraRecords = scanner.scan(file);
    assertTrue(jiraRecords.size() == 175);
    assertTrue(jiraRecords.get(0).getStoryPoints().equals("1.0"));
  }
}