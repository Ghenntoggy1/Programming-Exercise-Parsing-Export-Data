import edu.duke.*;
import org.apache.commons.csv.*;

public class Part1 {
    public String countryInfo (CSVParser parser, String country) {
        for (CSVRecord record : parser) {
            if (record.get("Country").contains(country)) {
                String export = record.get("Exports");
                String value = record.get("Value (dollars)");
                return country + ": " + export + ": " + value;
            }
        }
        return "NOT FOUND";
    }
    
    public void listExportersTwo (CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportItem1) && export.contains(exportItem2)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    
    public int numberOfExporters (CSVParser parser, String exportItem) {
        int counter = 0;
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportItem)) {
                counter++;
            }
        }
        return counter;
    }
    
    public void bigExporters (CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            if (value.length() > amount.length()) {
                String country = record.get("Country");
                System.out.println(country + " " + value);
            }
        }
    }
    
    public void tester () {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Nauru"));
        System.out.println("-------------------------------------------------");
        parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Germany"));
        System.out.println("-------------------------------------------------");
        parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Moldova"));
        
        System.out.println("=================================================");
        
        parser = fr.getCSVParser();
        listExportersTwo(parser , "gold", "diamonds");
        System.out.println("-------------------------------------------------");
        parser = fr.getCSVParser();
        listExportersTwo(parser , "tea", "coffee");
        System.out.println("-------------------------------------------------");
        parser = fr.getCSVParser();
        listExportersTwo(parser , "tin", "coffee");
        
        System.out.println("=================================================");
        
        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser , "sugar"));
        System.out.println("-------------------------------------------------");
        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser , "tea"));
        System.out.println("-------------------------------------------------");
        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser , "tin"));
        
        System.out.println("=================================================");
        
        parser = fr.getCSVParser();
        bigExporters(parser , "$999,999,999,999");
        System.out.println("-------------------------------------------------");
        parser = fr.getCSVParser();
        bigExporters(parser , "$1,000,000,000");
        System.out.println("-------------------------------------------------");
        parser = fr.getCSVParser();
        bigExporters(parser , "$999,999,999");
    }
}
