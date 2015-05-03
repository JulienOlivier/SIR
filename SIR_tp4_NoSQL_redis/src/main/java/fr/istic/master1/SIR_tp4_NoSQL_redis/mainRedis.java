package fr.istic.master1.SIR_tp4_NoSQL_redis;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class mainRedis 
{
	public static void main(String[] args) throws InterruptedException{

		Jedis jedis = new Jedis("localhost");
		
		/*
		// Exemple 1
		jedis.set("foo","bar");
		String value = jedis.get("foo");
		System.out.println(value);
		*/
		/*
		//Exemple 2
		System.out.println(jedis.get("counter"));
		jedis.incr("counter");
		System.out.println(jedis.get("counter"));
		*/
		//*
		//Exemple 3
		String cacheKey = "cacheKey";
		//adding a new key
		jedis.set(cacheKey, "cached value");
		//setting the TTL in seconds
		jedis.expire(cacheKey, 15);
		//Getting the remaining ttl
		System.out.println("TTL: "+jedis.ttl(cacheKey));
		Thread.sleep(1000);
		System.out.println("TTL: "+jedis.ttl(cacheKey));
		//Getting the cache value
		System.out.println("Cached value: "+jedis.get(cacheKey));
		//Wait for the TTL finishs
		Thread.sleep(15000);
		//Trying to get the expired key
		System.out.println("Expired key: "+jedis.get(cacheKey));
	}
}
