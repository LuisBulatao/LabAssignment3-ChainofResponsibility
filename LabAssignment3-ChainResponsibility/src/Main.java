import Interface.WasteCollector;
import Handler.*;
import Container.*;

public class Main {
    public static void main(String[] args) {
        WasteCollector organicCollector = new Organic();
        WasteCollector recyclableCollector = new Recyclable();
        WasteCollector hazardousCollector = new Hazardous();

        organicCollector.setNextCollector(recyclableCollector);
        recyclableCollector.setNextCollector(hazardousCollector);

        WasteContainer[] wasteContainers = {
                new WasteContainer("Organic", 80),
                new WasteContainer("Recyclable", 50),
                new WasteContainer("Hazardous", 30),
                new WasteContainer("Unknown", 20)
        };

        System.out.println("Processing Waste Collection:");
        for (WasteContainer container : wasteContainers) {
            organicCollector.collect(container);
        }
    }

}
