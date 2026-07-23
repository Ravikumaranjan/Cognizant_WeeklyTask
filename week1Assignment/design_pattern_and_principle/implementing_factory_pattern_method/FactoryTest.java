package design_pattern_and_principle.implementing_factory_pattern_method;

public class FactoryTest {

    public static void main(String[] args) {

        // Create Word Document
        DocumentFactory wordFactory = new WordFactory();
        Document word = wordFactory.createDocument();
        word.open();

        // Create PDF Document
        DocumentFactory pdfFactory = new PdfFactory();
        Document pdf = pdfFactory.createDocument();
        pdf.open();

        // Create Excel Document
        DocumentFactory excelFactory = new ExcelFactory();
        Document excel = excelFactory.createDocument();
        excel.open();
    }
}