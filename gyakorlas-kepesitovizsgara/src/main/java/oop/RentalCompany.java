package oop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RentalCompany {

    private List<RentableTool> rentableTools = new ArrayList<>();

    public void addTool(RentableTool rentableTool) {
        rentableTools.add(rentableTool);
    }

    public RentableTool findToolById(String id) {
        return rentableTools.stream()
                .filter(rentableTool -> rentableTool.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<RentableTool> listFreeTools() {
        return rentableTools.stream()
                .filter(rentableTool -> rentableTool.getRentFrom() == null)
                .toList();
    }

    public int calculateTotalIncome() {
        return rentableTools.stream()
                .mapToInt(RentableTool::getTotalIncome)
                .sum();
    }

    public void listExpiredToolsToFileAsCsv(Path path) throws IOException {
        Files.writeString(path, "id;name;rentTo");
        for (RentableTool tool : rentableTools) {
            if (tool.getRentTo() != null && LocalDateTime.now().isAfter(tool.getRentTo())) {
                Files.writeString(path, "\n" +
                        tool.getId() + ";" +
                        tool.getName() + ";" +
                        tool.getRentTo(), StandardOpenOption.APPEND);
            }
        }
    }

    public List<RentableTool> getRentableTools() {
        return rentableTools;
    }
}
