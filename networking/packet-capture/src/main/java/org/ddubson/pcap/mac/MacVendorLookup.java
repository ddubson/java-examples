package org.ddubson.pcap.mac;

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by ddubs on 12/7/2016.
 */
@Component("macLookup")
public class MacVendorLookup implements MACLookup {
    private final MACLookup cachedMacLookup;
    private final MACStore cachedMacStore;

    public MacVendorLookup(@Autowired MACLookup cachedMacLookup, @Autowired MACStore cachedMacStore) {
        this.cachedMacLookup = cachedMacLookup;
        this.cachedMacStore = cachedMacStore;
    }

    @Override
    public String lookupMAC(String macAddress) {
        Optional<String> manu = Optional.ofNullable(cachedMacLookup.lookupMAC(macAddress));

        if (manu.isPresent()) {
            return manu.get();
        } else {
            Optional<Content> c;
            try {
                String fullUrl = String.format("http://api.macvendors.com/%s", macAddress);
                c = Optional.ofNullable(Request.Get(fullUrl).execute().returnContent());
            } catch (IOException e) {
                System.out.println(e.getMessage());
                cachedMacStore.storeMac(macAddress, "N/A");
                return "";
            }

            if (c.isPresent()) {
                cachedMacStore.storeMac(macAddress, c.get().asString());
                return c.get().asString();
            } else return "";
        }
    }
}
