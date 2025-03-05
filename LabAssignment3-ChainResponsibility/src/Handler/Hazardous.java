package Handler;

import Container.WasteContainer;
import Interface.WasteCollector;

public class Hazardous implements WasteCollector {
    private WasteCollector nextCollector;

    @Override
    public void setNextCollector(WasteCollector nextCollector) {
        this.nextCollector = nextCollector;
    }

    @Override
    public void collect(WasteContainer container) {
        if ("Hazardous".equalsIgnoreCase(container.getType())) {
            System.out.println("Hazardous waste collected. Capacity: " + container.getCapacity());
        } else if (nextCollector != null) {
            nextCollector.collect(container);
        } else {
            System.out.println("No collector available for this waste type.");
        }
    }
}
