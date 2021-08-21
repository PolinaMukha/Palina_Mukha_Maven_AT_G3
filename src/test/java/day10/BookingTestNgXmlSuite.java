package day10;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class BookingTestNgXmlSuite {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        final TestNG testNG = new TestNG(true);
        final Parser parser = new Parser("src/test/resources/testng.xml");
        final List<XmlSuite> suites = parser.parseToList();
        testNG.setXmlSuites(suites);
        testNG.run();
    }
}
