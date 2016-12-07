package org.ddubson.pcap.mac;

/**
 * Created by ddubs on 12/7/2016.
 */
@FunctionalInterface
public interface MACLookup {
    String lookupMAC(String address);
}
