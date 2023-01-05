package guinness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecorderTest {

    @Test
    void createRecorderTest() {
        Recorder recorder = new Recorder(1, "John");

        assertEquals(1, recorder.getId());
        assertEquals("John", recorder.getName());
    }

    @Test
    void testEquals() {
        Recorder recorder = new Recorder(1, "John");
        Recorder recorderEqual = new Recorder(1, "Jane");
        Recorder recorderNotEqual = new Recorder(2, "John");

        assertTrue(recorder.equals(recorderEqual));
        assertFalse(recorder.equals(recorderNotEqual));
    }
}