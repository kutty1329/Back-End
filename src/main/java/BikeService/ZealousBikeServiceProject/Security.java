package BikeService.ZealousBikeServiceProject;

import javax.management.relation.Role;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security {
	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
   @Bean
   public InMemoryUserDetailsManager uservalues()
   {
	  UserDetails user1=User.withUsername("PRADEEP").password(encoder().encode("PRADEEP123")).roles("USER").build();
	  
	  return new InMemoryUserDetailsManager(user1);
	  
   }
   @Bean
   public SecurityFilterChain safty(HttpSecurity hp) throws Exception
   {
	   hp
		.authorizeRequests()
		.antMatchers("/mybikeproject")
		.authenticated();
		hp.csrf().disable();
		hp.formLogin();
		hp.httpBasic();
		
		return hp.build();
   }
}
