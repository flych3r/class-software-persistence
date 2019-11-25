package br.ufc.qxd.dsp.aula10.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {

    private static final String URI = "localhost";
    private static final JedisPool pool = new JedisPool(new JedisPoolConfig(), URI);

    public static Jedis getClient() {
        return pool.getResource();
    }

    public static void closeClient(Jedis client) {
        client.close();
    }

}
