package br.ufc.qxd.dsp.aula8;

import com.mongodb.MongoClient;

public class MongoDB {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost");

        System.out.println(mongoClient);

    }

}
