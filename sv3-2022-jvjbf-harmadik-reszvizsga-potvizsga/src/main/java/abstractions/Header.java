package abstractions;

import java.util.Objects;

public class Header {

    private String title;

    private int headerSize;

    public Header(String title, int headerSize) {
        this.title = title;
        this.headerSize = headerSize;
    }

    public String getTitle() {
        return title;
    }

    public int getHeaderSize() {
        return headerSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Header header = (Header) o;

        return Objects.equals(title, header.title);
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }
}
