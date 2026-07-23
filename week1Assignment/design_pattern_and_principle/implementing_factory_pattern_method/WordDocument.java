package design_pattern_and_principle.implementing_factory_pattern_method;
class WordDocument implements Document {

    @Override
    public void open() {
        System.out.println("Word Document Created.");
    }
}