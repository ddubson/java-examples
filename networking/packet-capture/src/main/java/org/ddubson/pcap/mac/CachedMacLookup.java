package org.ddubson.pcap.mac;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by ddubs on 12/7/2016.
 */
@Component("cachedMacLookup")
public class CachedMacLookup implements MACLookup {
    @Override
    public String lookupMAC(String address) {
        ObjectMapper m = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = m.readTree(this.getClass().getResourceAsStream("/mac-lookup.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (rootNode == null) return null;
        JsonNode addrNode = rootNode.findValue(address);

        return addrNode == null ? null : addrNode.asText();
    }
}
