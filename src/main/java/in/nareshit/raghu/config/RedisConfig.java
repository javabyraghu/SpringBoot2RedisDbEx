package in.nareshit.raghu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import in.nareshit.raghu.model.Person;

@Configuration
public class RedisConfig {

	@Bean
	public RedisConnectionFactory cf() {
		return new LettuceConnectionFactory();
	}
	@Bean
	public RedisTemplate<String, Person> rt(){
		RedisTemplate<String, Person> template = new RedisTemplate<>();
		template.setConnectionFactory(cf());
		return template;
	}
}
