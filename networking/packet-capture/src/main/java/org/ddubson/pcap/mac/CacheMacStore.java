package org.ddubson.pcap.mac;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * Created by ddubs on 12/7/2016.
 */
@Component("cachedMacStore")
public class CacheMacStore implements MACStore {
    @Override
    public void storeMac(String macAddress, String manufacturer) {
        ObjectMapper m = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = m.readTree(this.getClass().getResourceAsStream("/mac-lookup.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(rootNode == null) return;

        ((ObjectNode) rootNode).put(macAddress, manufacturer);
        try {
            m.writeValue(new File(this.getClass().getResource("/mac-lookup.json").getFile()), rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
