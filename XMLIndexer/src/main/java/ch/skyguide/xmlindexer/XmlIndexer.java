package ch.skyguide.xmlindexer;

import ch.skyguide.xmlindexer.index.IndexNode;
import ch.skyguide.xmlindexer.index.IndexStringEntry;
import static ch.skyguide.xmlindexer.query.QueryAddressBuilder.*;

public class XmlIndexer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        IndexNode ch = new IndexNode("ch");
        IndexNode skyguide = new IndexNode("skyguide");
        ch.appendChild(skyguide);

        IndexNode config = new IndexNode("config");
        skyguide.appendChild(config);

        IndexNode gva = new IndexNode("gva");
        config.appendChild(gva);

        gva.appendChild(new IndexStringEntry("ip", "156.135.98.70"));

        IndexNode zrh = new IndexNode("zrh");
        config.appendChild(zrh);

        zrh.appendChild(new IndexStringEntry("ip", "156.135.98.71"));

        ch.preOrderDepthFirstSearch().stream().forEach((node) -> {
            System.out.println(node.toString());
        });
        
        // TODO !!!!
        System.out.println("Query !");
        System.out.println(ch.search(createBuilder().then("ch").then("skyguide").thenPattern("conf.*").then(".*").then("ip").build()));

    }
}
