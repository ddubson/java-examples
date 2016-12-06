package org.ddubson.pcap;

import com.sun.jna.Platform;
import org.pcap4j.core.*;
import org.pcap4j.packet.EthernetPacket;
import org.pcap4j.packet.IpV4Packet;
import org.pcap4j.packet.IpV6Packet;
import org.pcap4j.util.NifSelector;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * Author: ddubson
 */
@SpringBootApplication
public class PacketCaptureApp implements CommandLineRunner {
    private static final String COUNT_KEY
            = PacketCaptureApp.class.getName() + ".count";
    private static final int COUNT
            = Integer.getInteger(COUNT_KEY, 5);

    private static final String READ_TIMEOUT_KEY
            = PacketCaptureApp.class.getName() + ".readTimeout";
    private static final int READ_TIMEOUT
            = Integer.getInteger(READ_TIMEOUT_KEY, 10); // [ms]

    private static final String SNAPLEN_KEY
            = PacketCaptureApp.class.getName() + ".snaplen";
    private static final int SNAPLEN
            = Integer.getInteger(SNAPLEN_KEY, 65536); // [bytes]

    public PacketCaptureApp() {

    }

    public static void main(String[] args) throws PcapNativeException, NotOpenException {
        SpringApplication.run(PacketCaptureApp.class, args);
    }

    private static String createSeparator() {
        StringBuilder s = new StringBuilder();
        Stream.iterate(0, n -> n + 1).limit(50).forEach(n -> s.append("="));
        return s.toString();
    }

    private static void print(String s) {
        System.out.println(s);
    }

    @Override
    public void run(String... args) throws Exception {
        String filter = args.length != 0 ? args[0] : "";

        System.out.println(COUNT_KEY + ": " + COUNT);
        System.out.println(READ_TIMEOUT_KEY + ": " + READ_TIMEOUT);
        System.out.println(SNAPLEN_KEY + ": " + SNAPLEN);
        System.out.println("\n");

        PcapNetworkInterface nif;
        try {
            nif = new NifSelector().selectNetworkInterface();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (nif == null) {
            return;
        }

        System.out.println(nif.getName() + "(" + nif.getDescription() + ")");

        final PcapHandle handle
                = nif.openLive(SNAPLEN, PcapNetworkInterface.PromiscuousMode.PROMISCUOUS, READ_TIMEOUT);

        try {
            if (filter.length() != 0) {
                handle.setFilter(filter, BpfProgram.BpfCompileMode.OPTIMIZE);
            }

            PacketListener listener = packet -> {
                System.out.println(handle.getTimestamp());
                System.out.println(packet.getClass());
                if (packet instanceof EthernetPacket) {
                    EthernetPacket p = (EthernetPacket) packet;
                    EthernetPacket.EthernetHeader header = p.getHeader();
                    print("Type: " + header.getType());
                    print("Source MAC: " + header.getSrcAddr());
                    print("Dest MAC: " + header.getDstAddr());

                    if (p.getPayload() instanceof IpV4Packet) {
                        print(createSeparator() + "\n");
                        print("IPv4");
                        IpV4Packet ipV4Packet = (IpV4Packet) p.getPayload();
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
                    }

                    if (p.getPayload() instanceof IpV6Packet) {
                        //print("IPv6");
                    }
                } else {
                    System.out.println("Non-ethernet packet");
                }
                //System.out.println(packet.getHeader());
                System.out.println();
            };

            try {
                handle.loop(COUNT, listener);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            PcapStat ps = handle.getStats();
            System.out.println(PacketCaptureApp.createSeparator());
            System.out.println("\nPackets Received: " + ps.getNumPacketsReceived());
            System.out.println("Packets Dropped: " + ps.getNumPacketsDropped());
            System.out.println("Packets Dropped (by Interface): " + ps.getNumPacketsDroppedByIf());
            if (Platform.isWindows()) {
                System.out.println("Packets Captured: " + ps.getNumPacketsCaptured());
            }

        } finally {
            handle.close();
        }
    }
}
