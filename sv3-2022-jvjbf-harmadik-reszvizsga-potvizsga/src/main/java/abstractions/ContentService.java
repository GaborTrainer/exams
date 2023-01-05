package abstractions;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ContentService {
    
    private Set<Content> contents = new LinkedHashSet<>();

    public Set<Content> getContents() {
        return new LinkedHashSet<>(contents);
    }

    public void addContent(Content content) {
        contents.add(content);
    }

    public List<Content> getContentsSortedByImportance() {
       return contents.stream()
                .sorted(Comparator.comparingInt(Content::getImportance).reversed())
                .toList();
    }
}
