package design_pattern_and_principle.implementing_factory_pattern_method;

public class WordFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}