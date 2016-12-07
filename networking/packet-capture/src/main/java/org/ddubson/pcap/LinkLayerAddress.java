package org.ddubson.pcap;

/**
 * Created by ddubs on 12/7/2016.
 */
public class LinkLayerAddress {
    private String address;
    private String manufacturer;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
