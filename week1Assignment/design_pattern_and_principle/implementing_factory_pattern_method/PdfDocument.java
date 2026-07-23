package design_pattern_and_principle.implementing_factory_pattern_method;
class PdfDocument implements Document {

    @Override
    public void open() {
        System.out.println("PDF Document Created.");
    }
}