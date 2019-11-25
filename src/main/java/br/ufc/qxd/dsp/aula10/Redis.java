package br.ufc.qxd.dsp.aula10;

import br.ufc.qxd.dsp.aula10.jedis.JedisUtil;
import redis.clients.jedis.Jedis;

public class Redis {

    public static void exemplo01() {

        Jedis client = JedisUtil.getClient();
        client.set("Teste1", "testando");

        String teste1 = client.get("Teste1");

        System.out.println(teste1);

        JedisUtil.closeClient(client);
    }

    public static void exemplo02() {

        Jedis client = JedisUtil.getClient();

        client.set("gone", "daddy, gone");
        client.expire("gone", 10);
        String there = client.get("gone");
        assert there.equals("daddy, gone");

        try {
            Thread.sleep(4500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String notThere = client.get("gone");
        assert notThere == null;

        JedisUtil.closeClient(client);

    }

    public static void exemplo03() {
        Jedis client = JedisUtil.getClient();

        client.rpush("people", "Mary");
        assert client.lindex("people", 0).equals("Mary");
        client.rpush("people", "Mark");
        assert client.llen("people") == 2;
        assert client.lindex("people", 1).equals("Mark");

        JedisUtil.closeClient(client);

    }

    public static void main(String[] args) {

//        exemplo01();
//        exemplo02();
        exemplo03();

        System.out.println("Bye, Redis!");
    }

}
