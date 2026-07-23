package design_pattern_and_principle.implementing_factory_pattern_method;
class ExcelDocument implements Document {

    @Override
    public void open() {
        System.out.println("Excel Document Created.");
    }
}