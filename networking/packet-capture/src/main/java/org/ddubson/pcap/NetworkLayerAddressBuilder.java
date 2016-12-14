package org.ddubson.pcap;

public class NetworkLayerAddressBuilder {
    private String address;
    private String netmask;
    private String broadcastAddress;
    private String destinationAddress;

    public NetworkLayerAddressBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public NetworkLayerAddressBuilder setNetmask(String netmask) {
        this.netmask = netmask;
        return this;
    }

    public NetworkLayerAddressBuilder setBroadcastAddress(String broadcastAddress) {
        this.broadcastAddress = broadcastAddress;
        return this;
    }

    public NetworkLayerAddressBuilder setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
        return this;
    }

    public NetworkLayerAddress createNetworkLayerAddress() {
        return new NetworkLayerAddress(address, netmask, broadcastAddress, destinationAddress);
    }
}