package abstractions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ZipFileTest {

    ZipFile zipFile;

    @BeforeEach
    void createZipFile() {
        TextFile textFile1 = new TextFile("text");

        textFile1.addLine("This is a line");
        textFile1.addLine("Tis is an other line");

        TextFile textFile2 = new TextFile("text");

        textFile2.addLine("This is a line");

        File picture = new Picture("picture", "jpg", 120, 100);

        zipFile = new ZipFile("myzip", Arrays.asList(textFile1, picture, textFile2));
    }

    @Test
    void testCreateZipFile() {
        assertEquals("myzip", zipFile.getTitle());
        assertEquals(3, zipFile.getFiles().size());
    }

    @Test
    void testGetFullName() {
        assertEquals("myzip.zip", zipFile.getFullName());
    }

    @Test
    void testCalculateSize() {
        assertEquals(2.4006, zipFile.calculateSize(), 0.00001);
    }

    @Test
    void testFindBiggestFile() {
        File result = zipFile.findBiggestFile();

        assertEquals("picture.jpg", result.getFullName());
    }

    @Test
    void testFindBiggestFileWithEmptyList() {
        ZipFile zipFile = new ZipFile("empty", new ArrayList<>());

        assertThrows(IllegalStateException.class,
                () -> zipFile.findBiggestFile(),
                "Zip is empty!");
    }
}
