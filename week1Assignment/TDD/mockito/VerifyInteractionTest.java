import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class VerifyInteractionTest {

    @Test
    public void testVerifyInteraction() {

        // Create Mock Object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Inject Mock Object into Service
        MyService service = new MyService(mockApi);

        // Call Service Method
        service.fetchData();

        // Verify that getData() was called exactly once
        verify(mockApi).getData();
    }
}