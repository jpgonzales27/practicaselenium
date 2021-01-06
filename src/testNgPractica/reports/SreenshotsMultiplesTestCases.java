package testNgPractica.reports;

import com.relevantcodes.extentreports.ExtentReports;

public class SreenshotsMultiplesTestCases {
    public static ExtentReports getInstance() {
        ExtentReports extent;
        String Path = "C://Users//juamp//Desktop//report-demo.html";
        extent = new ExtentReports(Path, false);
        extent
                .addSystemInfo("Selenium Version", "2.52")
                .addSystemInfo("Platform", "Windows");

        return extent;
    }
}
