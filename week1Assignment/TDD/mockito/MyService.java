public class MyService {

    private ExternalApi externalApi;

    // Constructor
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    // Method to fetch data
    public String fetchData() {
        return externalApi.getData();
    }
}