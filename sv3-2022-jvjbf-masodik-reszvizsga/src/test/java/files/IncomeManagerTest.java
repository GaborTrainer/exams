package files;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class IncomeManagerTest {

    IncomeManager incomeManager = new IncomeManager();

    @Test
    void testCreateIncomeManager() {
        assertEquals(0, incomeManager.getIncomes().size());
    }

    @Test
    void testReadIncomesFromFile() {
        incomeManager.readIncomesFromFile(Paths.get("src/test/resources/goodinput.csv"));

        assertEquals(13, incomeManager.getIncomes().size());
        assertEquals(33000, incomeManager.getIncomes().get(3).getMoney());
    }

    @Test
    void testReadIncomesFromFileNotExistingFile() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> incomeManager.readIncomesFromFile(Paths.get("src/test/resources/input.csv")),
                "Cannot read file!");

        assertInstanceOf(IOException.class, iae.getCause());
    }

    @Test
    void testReadIncomesFromFIleWithBadOrder() {
        assertThrows(IllegalArgumentException.class,
                () -> incomeManager.readIncomesFromFile(Paths.get("src/test/resources/badinput.csv")),
                "Income date is not valid: 2022-11-10");
    }
}
