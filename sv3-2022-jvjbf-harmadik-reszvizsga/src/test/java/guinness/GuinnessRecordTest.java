package guinness;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GuinnessRecordTest {

    GuinnessRecord guinnessRecord = GuinnessRecord.createGuinnessRecord("Throwing", RecordType.QUANTITY);

    @Test
    void testCreateTimeGuinnessRecord() {
        GuinnessRecord guinnessRecord = GuinnessRecord.createGuinnessRecord("Running", RecordType.TIME);

        assertEquals("Running", guinnessRecord.getRecordName());
        assertEquals(RecordType.TIME, guinnessRecord.getRecordType());
        assertEquals(Integer.MAX_VALUE, guinnessRecord.getBestAttempt());
    }

    @Test
    void testCreateQuantityRecord() {
        GuinnessRecord guinnessRecord = GuinnessRecord.createGuinnessRecord("Throwing", RecordType.QUANTITY);

        assertEquals("Throwing", guinnessRecord.getRecordName());
        assertEquals(RecordType.QUANTITY, guinnessRecord.getRecordType());
        assertEquals(0, guinnessRecord.getBestAttempt());
    }

    @Test
    void testTryBeatQuantityRecordWithFirstRecord() {

        boolean result = guinnessRecord.tryBeatRecord(120, new Recorder(1, "John"));

        assertTrue(result);
        assertEquals(1, guinnessRecord.getAttempts().keySet().size());
        assertEquals(List.of(120), guinnessRecord.getAttempts().get(new Recorder(1, "John")));
        assertEquals(120, guinnessRecord.getBestAttempt());
    }

    @Test
    void testTryBeatQuantityRecordWithSecondTry() {
        guinnessRecord.tryBeatRecord(120, new Recorder(1, "John"));
        boolean result = guinnessRecord.tryBeatRecord(121, new Recorder(1, "John"));

        assertTrue(result);
        assertEquals(List.of(120, 121), guinnessRecord.getAttempts().get(new Recorder(1, "John")));
        assertEquals(121, guinnessRecord.getBestAttempt());
    }

    @Test
    void testTryBeatTimeRecord() {
        GuinnessRecord guinnessRecord = GuinnessRecord.createGuinnessRecord("Running", RecordType.TIME);
        guinnessRecord.tryBeatRecord(120, new Recorder(1, "John"));
        boolean result = guinnessRecord.tryBeatRecord(119, new Recorder(1, "John"));

        assertTrue(result);
        assertEquals(List.of(120, 119), guinnessRecord.getAttempts().get(new Recorder(1, "John")));
        assertEquals(119, guinnessRecord.getBestAttempt());
    }

    @Test
    void testTryBeatRecordWithSameName() {
        guinnessRecord.tryBeatRecord(120, new Recorder(1, "John"));
        boolean result = guinnessRecord.tryBeatRecord(121, new Recorder(2, "John"));

        assertTrue(result);
        assertEquals(List.of(120), guinnessRecord.getAttempts().get(new Recorder(1, "John")));
        assertEquals(121, guinnessRecord.getBestAttempt());
    }

    @Test
    void testTryBeatRecordNotSuccessFul() {
        guinnessRecord.tryBeatRecord(120, new Recorder(1, "John"));
        boolean result = guinnessRecord.tryBeatRecord(119, new Recorder(1, "John"));

        assertFalse(result);
        assertEquals(120, guinnessRecord.getBestAttempt());
    }

    @Test
    void testFindRecordHolder() {
        guinnessRecord.tryBeatRecord(120, new Recorder(1, "John"));
        guinnessRecord.tryBeatRecord(120, new Recorder(2, "Jane"));
        guinnessRecord.tryBeatRecord(121, new Recorder(3, "Jill"));
        guinnessRecord.tryBeatRecord(119, new Recorder(4, "Jack"));

        Recorder recorder = guinnessRecord.findRecordHolder();

        assertTrue(new Recorder(3, "Jill").equals(recorder));
    }

    @Test
    void testFindRecorderWithEmptyAttempts() {
        RecordHasNoAttemptsException re = assertThrows(RecordHasNoAttemptsException.class, () -> guinnessRecord.findRecordHolder());

        assertEquals("No attempts yet!", re.getMessage());
    }

    @Test
    void testToString() {
        guinnessRecord.tryBeatRecord(120, new Recorder(1, "John"));

        assertEquals("GuinnessRecord{recordName='Throwing', recordType=QUANTITY, maxAmount=120 quantity unit",
                guinnessRecord.toString());
    }

    @Test
    void testGetOrderedRecorderNames() {
        guinnessRecord.tryBeatRecord(120, new Recorder(1, "John"));
        guinnessRecord.tryBeatRecord(120, new Recorder(2, "Jane"));
        guinnessRecord.tryBeatRecord(121, new Recorder(3, "Jill"));
        guinnessRecord.tryBeatRecord(119, new Recorder(4, "Jack"));
        guinnessRecord.tryBeatRecord(119, new Recorder(5, "John"));

        List<String> result = guinnessRecord.getOrderedRecorderNames();

        assertEquals(List.of("Jack", "Jane", "Jill", "John", "John"), result);
    }
}