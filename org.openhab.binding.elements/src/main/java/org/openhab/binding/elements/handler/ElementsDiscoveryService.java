/**
 *
 */
package org.openhab.binding.elements.handler;

import org.eclipse.smarthome.config.discovery.AbstractDiscoveryService;
import org.eclipse.smarthome.core.thing.Bridge;

/**
 * @author hkuhn
 *
 */
public class ElementsDiscoveryService extends AbstractDiscoveryService {

    private Bridge cloud;

    public ElementsDiscoveryService(Bridge cloud, int timeout) throws IllegalArgumentException {
        super(timeout);
        this.cloud = cloud;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.smarthome.config.discovery.AbstractDiscoveryService#startScan()
     */
    @Override
    protected void startScan() {
        cloud.getThings();

        // DiscoveryResult discoveryResult = DiscoveryResultBuilder
        // .create(thingUID).withProperties(properties)
        // .withRepresentationProperty(device.getIdentifier())
        // .withBridge(bridgeUID).withLabel(device.getName()).build();

        // thingDiscovered(discoveryResult);
    }

}
