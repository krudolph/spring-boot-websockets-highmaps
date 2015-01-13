package de.kimrudolph.tutorials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableScheduling
public class HighmapsWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(HighmapsWebsocketApplication.class, args);
    }

    @Autowired
    private MessageSendingOperations<String> messagingTemplate;

    @Scheduled(fixedDelay = 1000)
    public void sendBubbleUpdates() {

        this.messagingTemplate.convertAndSend("/bubbles",
            "{\"hc-key\": \"" + ids.get(new Random().nextInt(ids.size() - 1)) +
                "\", \"z\": " + new Random().nextInt(100) + "}");

    }

    @Scheduled(fixedDelay = 5000)
    public void sendMapUpdates() {

        StringBuilder updates = new StringBuilder("[");

        for (String id : ids) {
            updates.append("{\"hc-key\": \"").append(id)
                .append("\", \"value\": ").append(new Random().nextInt(100))
                .append("}").append(",");
        }
        updates.deleteCharAt(updates.length() - 1);
        updates.append("]");

        this.messagingTemplate.convertAndSend("/map", updates.toString());

    }

    private final List<String> ids = Arrays
        .asList("de-sh-01054000", "de-mv-13074000", "de-mv-13073000",
            "de-mv-13003000", "de-ni-03457000", "de-by-09277000",
            "de-mv-13076000", "de-ni-03356000", "de-by-09184000",
            "de-bb-12053000", "de-bw-08316000", "de-by-09177000",
            "de-by-09175000", "de-rp-07143000", "de-rp-07313000",
            "de-sl-10045000", "de-th-16062000", "de-bw-08211000",
            "de-bw-08216000", "de-st-15090000", "de-hb-04012000",
            "de-by-09377000", "de-by-09187000", "de-ni-03462000",
            "de-by-09372000", "de-bw-08317000", "de-bb-12071000",
            "de-sn-14626000", "de-ni-03459000", "de-by-09172000",
            "de-ni-03405000", "de-bw-08136000", "de-bw-08415000",
            "de-by-09564000", "de-ni-03241000", "de-ni-03252000",
            "de-rp-07134000", "de-sl-10046000", "de-he-06534000",
            "de-he-06535000", "de-bw-08237000", "de-st-15001000",
            "de-st-15082000", "de-nw-05766000", "de-sn-14522000",
            "de-ni-03353000", "de-sh-01053000", "de-sn-14523000",
            "de-th-16075000", "de-th-16074000", "de-by-09163000",
            "de-bw-08435000", "de-bw-08437000", "de-by-09762000",
            "de-nw-05162000", "de-nw-05111000", "de-by-09361000",
            "de-by-09471000", "de-by-09463000", "de-by-09461000",
            "de-ni-03156000", "de-rp-07339000", "de-rp-07133000",
            "de-by-09462000", "de-by-09678000", "de-by-09662000",
            "de-sl-10042000", "de-by-09274000", "de-bb-12069000",
            "de-ni-03455000", "de-ni-03451000", "de-ni-03359000",
            "de-ni-03461000", "de-sh-01056000", "de-mv-13071000",
            "de-sh-01061000", "de-hh-02000000", "de-nw-05962000",
            "de-nw-05954000", "de-by-09478000", "de-by-09472000",
            "de-sh-01001000", "de-nw-05974000", "de-nw-05119000",
            "de-nw-05170000", "de-rp-07319000", "de-rp-07338000",
            "de-bw-08222000", "de-rp-06431000", "de-rp-07337000",
            "de-by-09262000", "de-bw-08236000", "de-bw-08235000",
            "de-bw-08231000", "de-bw-08215000", "de-nw-05554000",
            "de-ni-03456000", "de-ni-03256000", "de-ni-03358000",
            "de-ni-03355000", "de-rp-07314000", "de-bb-12068000",
            "de-ni-04011000", "de-ni-03361000", "de-ni-03254000",
            "de-ni-03102000", "de-ni-03158000", "de-nw-05366000",
            "de-rp-07232000", "de-by-09771000", "de-by-09772000",
            "de-by-09778000", "de-rp-07311000", "de-ni-03154000",
            "de-ni-03151000", "de-he-06432000", "de-by-09676000",
            "de-ni-03101000", "de-bw-08225000", "de-he-06437000",
            "de-by-09576000", "de-rp-07332000", "de-rp-07335000",
            "de-rp-07316000", "de-bw-08115000", "de-by-09777000",
            "de-rp-07140000", "de-he-06433000", "de-he-06436000",
            "de-ni-03403000", "de-th-16054000", "de-th-16070000",
            "de-rp-07318000", "de-nw-05758000", "de-nw-05754000",
            "de-nw-05334000", "de-nw-05370000", "de-nw-05166000",
            "de-th-16052000", "de-he-06636000", "de-th-16056000",
            "de-by-09674000", "de-th-16069000", "de-th-16068000",
            "de-th-16067000", "de-nw-05374000", "de-rp-07132000",
            "de-nw-05124000", "de-he-06438000", "de-nw-05113000",
            "de-nw-05117000", "de-by-09179000", "de-by-09188000",
            "de-he-06414000", "de-nw-05762000", "de-nw-05958000",
            "de-nw-05120000", "de-by-09271000", "de-nw-05112000",
            "de-he-06412000", "de-nw-05378000", "de-nw-05158000",
            "de-nw-05316000", "de-th-16066000", "de-he-06411000",
            "de-by-09174000", "de-by-09162000", "de-bw-08436000",
            "de-by-09764000", "de-bw-08426000", "de-bw-08118000",
            "de-bw-08119000", "de-bw-08111000", "de-bw-08311000",
            "de-by-09186000", "de-bw-08421000", "de-by-09775000",
            "de-by-09183000", "de-st-15086000", "de-st-15089000",
            "de-st-15003000", "de-sh-01062000", "de-sh-01055000",
            "de-sh-01060000", "de-sh-01058000", "de-nw-05914000",
            "de-nw-05978000", "de-bw-08125000", "de-rp-08226000",
            "de-bw-08117000", "de-bw-08116000", "de-nw-05970000",
            "de-he-06532000", "de-rp-07111000", "de-rp-07340000",
            "de-ni-03404000", "de-nw-05566000", "de-nw-05515000",
            "de-st-15088000", "de-st-15087000", "de-by-09774000",
            "de-bw-08425000", "de-by-09776000", "de-bw-08335000",
            "de-rp-07235000", "de-ni-03360000", "de-nw-05570000",
            "de-nw-05558000", "de-rp-07331000", "de-ni-03153000",
            "de-he-06611000", "de-ni-03152000", "de-he-06633000",
            "de-nw-05315000", "de-th-16065000", "de-th-16061000",
            "de-sl-10043000", "de-sl-10044000", "de-nw-05562000",
            "de-rp-07312000", "de-nw-05358000", "de-sn-14729000",
            "de-st-14730000", "de-ni-03402000", "de-bw-08221000",
            "de-st-15083000", "de-bw-08326000", "de-bw-08212000",
            "de-rp-07334000", "de-nw-05362000", "de-nw-05382000",
            "de-rp-07131000", "de-rp-07138000", "de-by-09671000",
            "de-rp-07137000", "de-rp-07141000", "de-bw-08135000",
            "de-ni-03354000", "de-by-09780000", "de-by-09376000",
            "de-nw-05913000", "de-nw-05911000", "de-nw-05916000",
            "de-nw-05513000", "de-ni-03401000", "de-ni-03251000",
            "de-ni-03454000", "de-ni-03352000", "de-by-09779000",
            "de-by-09563000", "de-by-09562000", "de-by-09573000",
            "de-he-06435000", "de-by-09180000", "de-sn-14625000",
            "de-by-09272000", "de-bb-12065000", "de-bb-12073000",
            "de-bb-12064000", "de-by-09189000", "de-sh-01057000",
            "de-sh-01002000", "de-ni-03453000", "de-sl-10041000",
            "de-by-09182000", "de-ni-03458000", "de-ni-03157000",
            "de-by-09574000", "de-by-09185000", "de-by-09176000",
            "de-by-09161000", "de-by-09178000", "de-by-09171000",
            "de-bw-08417000", "de-st-15085000", "de-ni-03255000",
            "de-nw-05966000", "de-by-09181000", "de-ni-03155000",
            "de-nw-05512000", "de-nw-05314000", "de-by-09571000",
            "de-bw-08127000", "de-he-06434000", "de-bb-12070000",
            "de-st-15081000", "de-th-16064000", "de-sh-01003000",
            "de-st-15084000", "de-th-16073000", "de-th-16071000",
            "de-be-11000000", "de-bb-12072000", "de-bb-12063000",
            "de-by-09479000", "de-th-16076000", "de-by-09572000",
            "de-he-06631000", "de-nw-05114000", "de-by-09661000",
            "de-by-09565000", "de-by-09473000", "de-by-09675000",
            "de-bw-08128000", "de-nw-05915000", "de-bw-08327000",
            "de-bw-08325000", "de-he-06413000", "de-rp-07315000",
            "de-by-09373000", "de-nw-05711000", "de-rp-07333000",
            "de-sh-01004000", "de-th-16077000", "de-sn-14511000",
            "de-sn-14524000", "de-by-09173000", "de-by-09190000",
            "de-rp-07320000", "de-th-16051000", "de-bb-12060000",
            "de-by-09475000", "de-nw-05770000", "de-bb-12066000",
            "de-sn-14627000", "de-sn-14628000", "de-rp-07336000",
            "de-by-09673000", "de-by-09679000", "de-by-09677000",
            "de-th-16053000", "de-by-09476000", "de-by-09477000",
            "de-he-06439000", "de-bb-12051000", "de-by-09375000",
            "de-by-09761000", "de-by-09575000", "de-bw-08416000",
            "de-sh-01059000", "de-by-09672000", "de-mv-13004000",
            "de-nw-05122000", "de-ni-03452000", "de-mv-13075000",
            "de-sh-01051000", "de-mv-13072000", "de-bw-08337000",
            "de-bb-12067000", "de-by-09275000", "de-sn-14521000",
            "de-nw-05154000", "de-bw-08336000", "de-sn-14713000",
            "de-bw-08315000", "de-rp-07233000", "de-st-15091000",
            "de-by-09276000", "de-sn-14612000", "de-bb-12061000",
            "de-th-16063000", "de-he-06531000", "de-bw-08121000",
            "de-st-15002000", "de-he-06632000", "de-he-06634000",
            "de-ni-03357000", "de-by-09261000", "de-by-09374000",
            "de-by-09773000", "de-ni-03103000", "de-bw-08126000",
            "de-by-09577000", "de-nw-05774000", "de-nw-05116000",
            "de-he-06635000", "de-by-09279000", "de-by-09278000",
            "de-rp-07317000", "de-rp-07231000", "de-rp-07211000",
            "de-rp-07135000", "de-by-09763000", "de-ni-03460000",
            "de-bb-12052000", "de-th-16072000", "de-by-09371000",
            "de-by-09263000", "de-by-09362000", "de-bb-12062000",
            "de-by-09561000", "de-he-06533000", "de-th-16055000",
            "de-bb-12054000", "de-by-09363000", "de-by-09474000",
            "de-by-09663000", "de-he-06440000", "de-by-09273000",
            "de-ni-03257000", "de-ni-03351000", "de-by-09464000");


}
