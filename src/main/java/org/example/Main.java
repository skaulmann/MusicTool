package org.example;

import de.mt.metadaten.MusicMetadatenHandler;
import de.mt.print.HWPrinter;
import de.mt.restApi.DiscogsRequest;

public class Main {

    public static void main(String ... args) {

        new HWPrinter().print("Hallo2");

       // new DiscogsRequest().testCall("Störungsmelder", "Zeichen der Freiheit", "");
        new MusicMetadatenHandler("Störungsmelder", "Zeichen der Freiheit", "").test();
    }



}