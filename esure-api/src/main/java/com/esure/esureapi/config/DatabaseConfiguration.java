package com.esure.esureapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.esure.esureapi.core.model.PolicyData;

@Configuration
@EnableRedisRepositories
public class DatabaseConfiguration {

	// @Value("${spring.redis.host}")
	// private String redisHost;
	//
	// @Value("${spring.redis.port}")
	// private int redisPort;
	//
	// @Bean
	// JedisConnectionFactory jedisConnectionFactory() {
	// JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
	// jedisConnectionFactory.setHostName(redisHost);
	// jedisConnectionFactory.setPort(redisPort);
	// return jedisConnectionFactory;
	// }
	//
	// @Bean
	// public RedisTemplate<String, PolicyData> policyRedisTemplate(JedisConnectionFactory jedisConnectionFactory) {
	// RedisTemplate<String, PolicyData> redisTemplate = new RedisTemplate<>();
	// redisTemplate.setConnectionFactory(jedisConnectionFactory);
	// redisTemplate.setKeySerializer(new StringRedisSerializer());
	// redisTemplate.setValueSerializer(new JacksonJsonRedisSerializer<>(PolicyData.class));
	// redisTemplate.setEnableTransactionSupport(true);
	// return redisTemplate;
	// }
	//

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	public RedisTemplate<String, PolicyData> redisTemplate() {
		RedisTemplate<String, PolicyData> redisTemplate = new RedisTemplate<String, PolicyData>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new JacksonJsonRedisSerializer<>(PolicyData.class));
		redisTemplate.setEnableTransactionSupport(true);
		return redisTemplate;
	}

}
