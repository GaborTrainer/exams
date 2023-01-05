package bistros;

import java.util.*;

public class City {

    private Set<Bistro> bistros = new LinkedHashSet<>();

    public void addBistro(Bistro bistro) {
        bistros.add(bistro);
    }

    public Set<Bistro> getBistros() {
        return bistros;
    }

    public Bistro findBistroByAddress(Address address) {
        return bistros.stream()
                .filter(bistro -> bistro.getAddress().equals(address))
                .findFirst()
                .orElseThrow(() ->new IllegalArgumentException("Bistro not found at address: " + address));
    }

    public Bistro findLongestMenu() {
        return bistros.stream()
                .max(Comparator.comparing(bistro -> bistro.getMenu().size()))
                .get();
    }

    public List<Bistro> findBistroWithMenuItem(String menuItemName) {
        return bistros.stream()
                .filter(bistro -> bistro.findMenuItemByName(menuItemName))
                .toList();
    }
}
