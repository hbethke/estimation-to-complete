package de.totcorp.etc;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.List;

@SpringBootApplication
public class Etc implements ApplicationRunner {

  public static void main(String[] args) {
    SpringApplication.run(Etc.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    if (args.getNonOptionArgs().isEmpty()) {
      showUsage();
    }
    System.out.println("Let's calculate the Estimation To Completeness:");
    File file = new File(args.getNonOptionArgs().get(0));
    JiraExportScanner scanner = new JiraExportScanner();
    List<JiraRecord> allJiraRecords = scanner.scan(file);
    List<JiraRecord> wgOnlineRecords = VersionFilter.filterWgOnline(allJiraRecords);
    List<JiraRecord> wgRechnerRecords = VersionFilter.filterWgRechner(allJiraRecords);
    List<JiraRecord> wgAntragRecords = VersionFilter.filterWgAntrag(allJiraRecords);


    Float bacGesamt = Calculator.calculateEtc(allJiraRecords);
    Float bacWgOnline = Calculator.calculateEtc(wgOnlineRecords);
    Float bacWgRechner = Calculator.calculateEtc(wgRechnerRecords);
    Float bacWgAntrag = Calculator.calculateEtc(wgAntragRecords);

    List<JiraRecord> fertigeGesamt = FertigFilter.onlyFertigeStories(allJiraRecords);
    List<JiraRecord> fertigeWgOnline = FertigFilter.onlyFertigeStories(wgOnlineRecords);
    List<JiraRecord> fertigeWgRechner = FertigFilter.onlyFertigeStories(wgRechnerRecords);
    List<JiraRecord> fertigeWgAntrag = FertigFilter.onlyFertigeStories(wgAntragRecords);

    List<JiraRecord> inDevAndBlockedGesamt = InDevAndBlockedFilter.onlyBlockedInDevStories(allJiraRecords);
    List<JiraRecord> inDevAndBlockedWgOnline = InDevAndBlockedFilter.onlyBlockedInDevStories(wgOnlineRecords);
    List<JiraRecord> inDevAndBlockedRechner = InDevAndBlockedFilter.onlyBlockedInDevStories(wgRechnerRecords);
    List<JiraRecord> inDevAndBlockedAntrag = InDevAndBlockedFilter.onlyBlockedInDevStories(wgAntragRecords);

    System.out.println("WG Online Jira Records:" + VersionFilter.filterWgOnline(allJiraRecords).size() + "/" + fertigeWgOnline.size());
    System.out.println("WG Antrag Jira Records:" + VersionFilter.filterWgAntrag(allJiraRecords).size() + "/" + fertigeWgAntrag.size());
    System.out.println("WG Rechner Jira Records:" + VersionFilter.filterWgRechner(allJiraRecords).size() + "/" + fertigeWgRechner.size());
    System.out.println("Gesamtanzahl Jira Records:" + allJiraRecords.size() + "/" + fertigeGesamt.size());
    System.out.println("--------------------------------");
    System.out.println("BAC WG Online:" + bacWgOnline);
    System.out.println("BAC WG Antrag:" + bacWgAntrag);
    System.out.println("BAC WG Rechner:" + bacWgRechner);
    System.out.println("BAC Gesamt:" + bacGesamt);
    System.out.println("--------------------------------");
    Float evWgOnline = Calculator.calculateEtc(fertigeWgOnline) + (Calculator.calculateEtc(inDevAndBlockedWgOnline) / 2);
    Float evWgOnlinePercent = evWgOnline * 100 / bacWgOnline;
    Float evWgAntrag = Calculator.calculateEtc(fertigeWgAntrag) + (Calculator.calculateEtc(inDevAndBlockedAntrag) / 2);
    Float evWgAntragPercent = evWgAntrag * 100 / bacWgAntrag;
    Float evWgRechner = Calculator.calculateEtc(fertigeWgRechner) + (Calculator.calculateEtc(inDevAndBlockedRechner) / 2);
    Float wvWgRechnerPercent = evWgRechner * 100 / bacWgRechner;
    Float evGesamt = Calculator.calculateEtc(fertigeGesamt) + (Calculator.calculateEtc(inDevAndBlockedGesamt) / 2);
    Float evGesamtPercent = evGesamt * 100 / bacGesamt;

    System.out.println("EV (WG Online):" + evWgOnline + "; " + evWgOnlinePercent + "%");
    System.out.println("EV (WG Antrag):" + evWgAntrag + "; " + evWgAntragPercent + "%");
    System.out.println("EV (WG Rechner):" + evWgRechner + "; " + wvWgRechnerPercent + "%");
    System.out.println("EV (Gesamt):" + evGesamt + "; " + evGesamtPercent + "%");
    System.out.println("--------------------------------");
    System.out.println("ETC (WG Online):" + (bacWgOnline - Calculator.calculateEtc(fertigeWgOnline) - (Calculator.calculateEtc(inDevAndBlockedWgOnline) / 2)));
    System.out.println("ETC (WG Antrag):" + (bacWgAntrag - Calculator.calculateEtc(fertigeWgAntrag) - (Calculator.calculateEtc(inDevAndBlockedAntrag) / 2)));
    System.out.println("ETC (WG Rechner):" + (bacWgRechner - Calculator.calculateEtc(fertigeWgRechner) - (Calculator.calculateEtc(inDevAndBlockedRechner) / 2)));
    System.out.println("ETC (Gesamt):" + (bacGesamt - Calculator.calculateEtc(fertigeGesamt) - (Calculator.calculateEtc(inDevAndBlockedGesamt) / 2)));
  }

  private void showUsage() {
    System.out.println("Usage java -jar etc-calculator-1.0.jar {JiraExport.csv File}");
    System.exit(1);
  }
}
