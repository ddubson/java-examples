package org.ddubson.pcap;

import com.sun.jna.Platform;
import org.ddubson.pcap.layer.DataLinkLayer;
import org.pcap4j.core.*;
import org.pcap4j.util.LinkLayerAddress;
import org.pcap4j.util.NifSelector;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Author: ddubson
 */
@SpringBootApplication
@RestController
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

    @RequestMapping("/")
    public String app() {
        return "hello";
    }

    /**
     * List all Network Interfaces (NIFs)
     *
     * @return
     * @throws PcapNativeException
     */
    @RequestMapping(value = "/nifs", produces = "application/json")
    public List<NetworkInterface> nifs() throws PcapNativeException {
        return Pcaps.findAllDevs().stream().map(dev -> {
            NetworkInterface ni = new NetworkInterface();
            ni.setName(dev.getName());
            ni.setDescription(dev.getDescription());
            ni.setLinkLayerAddresses(dev.getLinkLayerAddresses().stream().map(LinkLayerAddress::toString).collect(toList()));
            ni.setNetworkLayerAddresses(dev.getAddresses().stream().map(Object::toString).collect(toList()));
            ni.setLoopback(dev.isLoopBack());
            return ni;
        }).sorted(comparing(NetworkInterface::getName)).collect(toList());
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

            PacketListener listener = packet -> new DataLinkLayer().unpack(packet);

            try {
                handle.loop(COUNT, listener);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            PcapStat ps = handle.getStats();
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
