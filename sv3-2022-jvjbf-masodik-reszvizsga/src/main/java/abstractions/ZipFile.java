package abstractions;

import java.util.Comparator;
import java.util.List;

public class ZipFile implements File {

    private String title;

    private List<File> files;

    public ZipFile(String title, List<File> files) {
        this.title = title;
        this.files = files;
    }

    public String getTitle() {
        return title;
    }

    public List<File> getFiles() {
        return files;
    }

    @Override
    public String getFullName() {
        return title + ".zip";
    }

    @Override
    public double calculateSize() {
//        double sum = 0;
//        for (File actualFile : files) {
//            sum += actualFile.calculateSize();
//        }
//        return sum * 0.2;
        return files.stream()
                .mapToDouble(File::calculateSize)
                .sum() * 0.2;
    }

    public File findBiggestFile() {
//        if(files.isEmpty()) {
//            throw new IllegalStateException("Zip is empty!");
//        }
//        double biggestSize = 0;
//        File biggestFile = null;
//        for (File actualFile : files) {
//            if (actualFile.calculateSize() > biggestSize) {
//                biggestSize = actualFile.calculateSize();
//                biggestFile = actualFile;
//            }
//        }
//        return biggestFile;
//    }
        return files.stream()
                .max(Comparator.comparing(File::calculateSize))
                .orElseThrow(() -> new IllegalStateException("Zip is empty!"));
    }
}
