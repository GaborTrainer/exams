package abstractions;

import java.util.List;
import java.util.Objects;

public class Article implements Content {

    private Header header;

    private String author;

    private List<String> content;

    public Article(Header header, String author, List<String> content) {
        this.header = header;
        this.author = author;
        this.content = content;
    }

    public Header getHeader() {
        return header;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getContent() {
        return content;
    }

    @Override
    public String getTitle() {
        return header.getTitle();
    }

    @Override
    public int getImportance() {
        return header.getHeaderSize() * content.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(header, article.header);
    }

    @Override
    public int hashCode() {
        return header != null ? header.hashCode() : 0;
    }
}
