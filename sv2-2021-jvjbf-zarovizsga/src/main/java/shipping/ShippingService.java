package shipping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShippingService {

    private List<Transportable> packages = new ArrayList<>();

    void addPackage(Transportable transportable) {
        packages.add(transportable);
    }

    public List<Transportable> getPackages() {
        return new ArrayList<>(packages);
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight) {
        return packages.stream()
                .filter(transportable -> transportable.isBreakable() == breakable && transportable.getWeight() >= weight)
                .toList();
    }

    public Map<String, Integer> collectTransportableByCountry() {
        return packages.stream()
                .collect(Collectors.toMap(Transportable::getDestinationCountry, pack -> 1, Integer::sum));
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        return new ArrayList<>(packages.stream()
                .filter(trans -> !trans.getDestinationCountry().equals(Transportable.DESTINATION_COUNTRY))
                .map(InternationalPackage.class::cast)
                .sorted(Comparator.comparingInt(InternationalPackage::getDistance))
                .toList());
    }
}