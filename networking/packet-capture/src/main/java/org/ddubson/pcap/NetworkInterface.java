package org.ddubson.pcap;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Author: ddubson
 */
public class NetworkInterface {
    private String name;
    private String description;
    @JsonProperty("layer-II-addresses")
    private List<LinkLayerAddress> linkLayerAddresses;
    @JsonProperty("layer-III-addresses")
    private List<NetworkLayerAddress> networkLayerAddresses;
    private boolean isLoopback;

    public boolean isLoopback() {
        return isLoopback;
    }

    public void setLoopback(boolean loopback) {
        isLoopback = loopback;
    }

    public List<NetworkLayerAddress> getNetworkLayerAddresses() {
        return networkLayerAddresses;
    }

    public void setNetworkLayerAddresses(List<NetworkLayerAddress> networkLayerAddresses) {
        this.networkLayerAddresses = networkLayerAddresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<LinkLayerAddress> getLinkLayerAddresses() {
        return linkLayerAddresses;
    }

    public void setLinkLayerAddresses(List<LinkLayerAddress> linkLayerAddresses) {
        this.linkLayerAddresses = linkLayerAddresses;
    }
}
