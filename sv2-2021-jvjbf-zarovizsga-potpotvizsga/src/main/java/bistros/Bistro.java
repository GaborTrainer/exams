package bistros;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bistro {

    private String name;
    private Address address;
    private List<MenuItem> menu = new ArrayList<>();

    public Bistro(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void addMenuItem(MenuItem menuItem) {
        menu.add(menuItem);
    }

    public boolean findMenuItemByName(String menuItemName) {
        return menu.stream()
                .anyMatch(menuItem -> menuItem.getName().equals(menuItemName));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bistro bistro = (Bistro) o;
        return Objects.equals(name, bistro.name) && Objects.equals(address, bistro.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
