package design_pattern_and_principle.implementing_factory_pattern_method;
class ExcelFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}