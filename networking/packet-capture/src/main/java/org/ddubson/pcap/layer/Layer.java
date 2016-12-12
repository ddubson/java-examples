package org.ddubson.pcap.layer;

import org.pcap4j.packet.Packet;

import java.util.stream.Stream;

/**
 * Author: ddubson
 */
public interface Layer {
    void unpack(Packet p);

    default void print(String s) {
        System.out.println(s);
    }

    default String createSeparator() {
        StringBuilder s = new StringBuilder();
        Stream.iterate(0, n -> n + 1).limit(50).forEach(n -> s.append("="));
        return s.toString();
    }
}
