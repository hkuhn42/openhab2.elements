/**
 *
 */
package org.openhab.binding.elements.handler;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.smarthome.config.discovery.AbstractDiscoveryService;
import org.eclipse.smarthome.config.discovery.DiscoveryResult;
import org.eclipse.smarthome.config.discovery.DiscoveryResultBuilder;
import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.ThingUID;
import org.openhab.binding.elements.ElementsBindingConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cc.gigaset.common.Sensor;

/**
 * @author hkuhn
 *
 */
public class ElementsDiscoveryService extends AbstractDiscoveryService {

    private Bridge cloud;
    private Logger logger = LoggerFactory.getLogger(ElementsDiscoveryService.class);

    public ElementsDiscoveryService(Bridge cloud, int timeout) throws IllegalArgumentException {
        super(timeout);
        this.cloud = cloud;
    }

    public void scan() {
        startScan();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.smarthome.config.discovery.AbstractDiscoveryService#startScan()
     */
    @Override
    protected void startScan() {

        logger.debug("ElementsDiscoveryService start -----------------------------------");
        ElementsBridgeHandler handler = (ElementsBridgeHandler) cloud.getHandler();

        try {
            Collection<Sensor> sensors = handler.getSensors();
            for (Sensor sensor : sensors) {
                Map<String, Object> properties = new HashMap<String, Object>();

                ThingTypeUID thingTypeUID = null;
                switch (sensor.getType()) {
                    case DOOR:
                        thingTypeUID = ElementsBindingConstants.THING_TYPE_DOOR;
                        break;
                    case WINDOW:
                        thingTypeUID = ElementsBindingConstants.THING_TYPE_WINDOW;
                        break;
                    case MOTION:
                        thingTypeUID = ElementsBindingConstants.THING_TYPE_MOTION;
                        break;
                    case SIREN:
                        thingTypeUID = ElementsBindingConstants.THING_TYPE_SIREN;
                        break;
                    default:
                        thingTypeUID = null;
                        break;

                }

                if (thingTypeUID != null) {
                    ThingUID thingUID = new ThingUID(thingTypeUID, sensor.getId());

                    DiscoveryResult discoveryResult = DiscoveryResultBuilder.create(thingUID).withProperties(properties)
                            .withRepresentationProperty(sensor.getId()).withBridge(cloud.getUID())
                            .withLabel(sensor.getName()).build();

                    thingDiscovered(discoveryResult);
                }
            }
        } catch (Exception e) {
            logger.error("discovery failed", e);
        }
    }

}
