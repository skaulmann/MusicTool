package org.example;

import de.mt.metadaten.MusicMetadatenHandler;
import de.mt.print.HWPrinter;

public class Main {

    public static void main(String ... args) {

        new Main().start(args);


    }


    public void start (String ... args ){


        new HWPrinter().print("Hallo2");

        // new DiscogsRequest().testCall("Störungsmelder", "Zeichen der Freiheit", "");
        new MusicMetadatenHandler("Störungsmelder", "Zeichen der Freiheit", "").test();
    }


}