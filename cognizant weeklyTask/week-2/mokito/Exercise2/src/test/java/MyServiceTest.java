import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
class MyServiceTest{@Test void test()
    {ExternalApi api=mock(ExternalApi.class);
        new MyService(api).fetchData();verify(api).getData();}}