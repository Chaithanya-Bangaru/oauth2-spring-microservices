package tech.bangaru.spring.microservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//super.configure(auth);
		auth.inMemoryAuthentication().withUser("camy").password("{noop}camy123").roles("USER")
							.and().withUser("ivaan").password("{noop}ivaan123").roles("USER")
							.and().withUser("shobha").password("{noop}shobha123").roles("USER")
							.and().withUser("raja").password("{noop}raja123").roles("ADMIN")
		;
	}

}
