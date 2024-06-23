package org.example;

import de.mt.metadaten.MusicMetadatenHandler;
import de.mt.print.HWPrinter;

public class Main {

    public static void main(String ... args) {

        new Main().start(args);


    }


    public void start (String ... args ){

        System.out.println(args[0] + " " + args[1]);
        new HWPrinter().print("Hallo2");


        String interpred = args[0];
        String album = args[1];
        String year = args[2];
        // new DiscogsRequest().testCall(interpred, album, year);
        new MusicMetadatenHandler(args[0], args[1],  args[2]).test();
    }


}