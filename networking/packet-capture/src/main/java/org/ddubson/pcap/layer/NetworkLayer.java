package org.ddubson.pcap.layer;

import org.pcap4j.packet.IpV4Packet;
import org.pcap4j.packet.IpV6Packet;
import org.pcap4j.packet.Packet;

/**
 * Author: ddubson
 */
public class NetworkLayer implements Layer {
    private Layer transportLayer = new TransportLayer();

    @Override
    public void unpack(Packet p) {
        if (p instanceof IpV4Packet) {
            print(createSeparator() + "\n");
            print("IPv4");
            IpV4Packet ipV4Packet = (IpV4Packet) p;
            print("Version: " + ipV4Packet.getHeader().getVersion().valueAsString());
            print("IHL (Internet Header Length): " + ipV4Packet.getHeader().getIhlAsInt());
            print("DSCP (Differentiated Services Code Point): TODO");//+ ipV4Packet.getHeader().getTos());
            print("ECN (Explicit Congestion Notification): " + ipV4Packet.getHeader().getTotalLength());
            print("Identification: " + ipV4Packet.getHeader().getIdentificationAsInt());
            print("Flags: " + ipV4Packet.getHeader().getDontFragmentFlag());
            print("Fragment Offset: " + ipV4Packet.getHeader().getFragmentOffset());
            print("TTL (Time to Live): " + ipV4Packet.getHeader().getTtlAsInt());
            print("Protocol: " + ipV4Packet.getHeader().getProtocol().valueAsString());
            print("Header Checksum: " + ipV4Packet.getHeader().getHeaderChecksum());
            print("Source Address: " + ipV4Packet.getHeader().getSrcAddr());
            print("Dest Address: " + ipV4Packet.getHeader().getDstAddr());
            print("Options: " + ipV4Packet.getHeader().getOptions());
            print(createSeparator() + "\n");

            transportLayer.unpack(ipV4Packet.getPayload());
        }

        if (p.getPayload() instanceof IpV6Packet) {
            //print("IPv6");
        }
    }
}
