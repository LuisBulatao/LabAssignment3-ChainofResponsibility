package Handler;

import Container.WasteContainer;
import Interface.WasteCollector;
public class Organic implements WasteCollector{
    private WasteCollector nextCollector;

    @Override
    public void setNextCollector(WasteCollector nextCollector) {
        this.nextCollector = nextCollector;
    }

    @Override
    public void collect(WasteContainer container) {
        if ("Organic".equalsIgnoreCase(container.getType())) {
            System.out.println("Organic waste collected. Capacity: " + container.getCapacity());
        } else if (nextCollector != null) {
            nextCollector.collect(container);
        } else {
            System.out.println("No collector available for this waste type.");
        }
    }
}

