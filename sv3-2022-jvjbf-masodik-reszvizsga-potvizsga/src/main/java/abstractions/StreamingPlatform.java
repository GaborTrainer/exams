package abstractions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamingPlatform {

    private List <Content> contents = new ArrayList<>();

    public List<Content> getContents() {
        return contents;
    }

    public void addContent(Content content) {
        contents.add(content);
    }

    public Content findLongestContent() {
//        if (contents.isEmpty()) {
//            throw new IllegalStateException();
//        }
//        Content longestContent = contents.get(0);
//        for (Content content : contents) {
//            if (content.getLength() > longestContent.getLength()) {
//                longestContent = content;
//            }
//        }
//        return longestContent;
//    }
        return contents.stream()
                .max(Comparator.comparing(Content::getLength))
                .orElseThrow(IllegalStateException::new);
    }
}
