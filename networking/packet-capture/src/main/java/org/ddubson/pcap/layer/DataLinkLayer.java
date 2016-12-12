package org.ddubson.pcap.layer;

import org.pcap4j.packet.EthernetPacket;
import org.pcap4j.packet.Packet;

/**
 * Author: ddubson
 */
public class DataLinkLayer implements Layer {
    NetworkLayer networkLayer = new NetworkLayer();
    @Override
    public void unpack(Packet packet) {
        if (packet instanceof EthernetPacket) {
            EthernetPacket p = (EthernetPacket) packet;
            EthernetPacket.EthernetHeader header = p.getHeader();
            print("Type: " + header.getType());
            print("Source MAC: " + header.getSrcAddr());
            print("Dest MAC: " + header.getDstAddr());
            networkLayer.unpack(packet.getPayload());
        }
    }
}