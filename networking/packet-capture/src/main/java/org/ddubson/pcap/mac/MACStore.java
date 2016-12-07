package org.ddubson.pcap.mac;

/**
 * Created by ddubs on 12/7/2016.
 */
public interface MACStore {
    void storeMac(String macAddress, String manufacturer);
}
