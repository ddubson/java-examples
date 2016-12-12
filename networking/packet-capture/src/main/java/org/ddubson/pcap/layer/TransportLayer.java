package org.ddubson.pcap.layer;

import org.pcap4j.packet.Packet;
import org.pcap4j.packet.TcpPacket;

/**
 * Author: ddubson
 */
public class TransportLayer implements Layer {
    @Override
    public void unpack(Packet packet) {
        if(packet instanceof TcpPacket) {
            TcpPacket tcpPacket = (TcpPacket)packet;

        }
    }
}
