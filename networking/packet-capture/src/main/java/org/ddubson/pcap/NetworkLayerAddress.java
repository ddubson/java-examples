package org.ddubson.pcap;

/**
 * Author: ddubson
 */
public class NetworkLayerAddress {
    private String address;
    private String netmask;
    private String broadcastAddress;
    private String destinationAddress;

    public NetworkLayerAddress(String address, String netmask, String broadcastAddress, String destinationAddress) {
        this.address = address;
        this.netmask = netmask;
        this.broadcastAddress = broadcastAddress;
        this.destinationAddress = destinationAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNetmask() {
        return netmask;
    }

    public void setNetmask(String netmask) {
        this.netmask = netmask;
    }

    public String getBroadcastAddress() {
        return broadcastAddress;
    }

    public void setBroadcastAddress(String broadcastAddress) {
        this.broadcastAddress = broadcastAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }
}
