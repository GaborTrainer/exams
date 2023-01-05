package abstractions;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContentServiceTest {

    ContentService contentService = new ContentService();

    @Test
    void testAddContent() {
        contentService.addContent(new Article(new Header("Important", 10),
                "John Doe",
                List.of("Very important", "Very very important!")));

        assertEquals(1, contentService.getContents().size());
    }

    @Test
    void testAddAdvertisement() {
        contentService.addContent(new Advertisement("Ad"));

        assertEquals(1, contentService.getContents().size());
    }

    @Test
    void testAddContentWithSameTitle() {
        contentService.addContent(new Article(new Header("Important", 10),
                "John Doe",
                List.of("Very important", "Very very important!")));
        contentService.addContent(new Article(new Header("Important", 10),
                "John Doe",
                List.of("Very important", "Very very important!")));

        assertEquals(1, contentService.getContents().size());
    }

    @Test
    void testAddAdvertisementWithSameTitle() {
        contentService.addContent(new Advertisement("Ad"));
        contentService.addContent(new Advertisement("Ad"));

        assertEquals(2, contentService.getContents().size());
    }

    @Test
    void testAddAdvertisementWithSameTitleAsArticle() {
        contentService.addContent(new Article(new Header("Important", 10),
                "John Doe",
                List.of("Very important", "Very very important!")));
        contentService.addContent(new Advertisement("Important"));

        assertEquals(2, contentService.getContents().size());
        assertEquals(List.of("Important","Important"),
                contentService.getContents().stream().map(Content::getTitle).collect(Collectors.toList()));
    }

    @Test
    void testGetContentsByOrder() {
        contentService.addContent(new Advertisement("Ad"));
        contentService.addContent(new Article(new Header("Important", 8),
                "John Doe",
                List.of("Very important", "Very very important!")));
        contentService.addContent(new Article(new Header("Important 2", 10),
                "John Doe",
                List.of("Very important", "Very very important!")));
        contentService.addContent(new Article(new Header("Important 3", 10),
                "John Doe",
                List.of("Very important")));


        assertEquals(List.of("Important 2", "Important", "Important 3", "Ad"),
                contentService.getContentsSortedByImportance().stream().map(Content::getTitle).toList());

    }
}