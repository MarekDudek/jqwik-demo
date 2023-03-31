package md.jqwickdemo;

import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Reporter;
import net.jqwik.api.constraints.AlphaChars;

import java.util.Map;

public class PlatformReportingWithReporterObjectTest
{
    @Example
    void reportInCode(Reporter reporter, @ForAll @AlphaChars String string) {
        reporter.publishReport("report", string);
        reporter.publishValue("value", string);
        reporter.publishReports("reports", Map.of("report", string));
    }

    @Example
    void reportInCodeBlank(Reporter reporter, @ForAll String string) {
        reporter.publishReport("report", string);
        reporter.publishReports("reports", Map.of("report", string));
    }
}
