package tech.bangaru.spring.microservices.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig implements AuthorizationServerConfigurer {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// Identifying the trusted client
		clients.inMemory().withClient("client")
		.secret("{noop}secret")
		.authorizedGrantTypes("password")
		//.authorizedGrantTypes("password","authorization_code","client_credentials","refresh_token")
		//.authorizedGrantTypes("password","authorization_code","client_credentials","refresh_token")
		.resourceIds("read-resources")
		.scopes("read");

	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// Securing API end points
		endpoints.authenticationManager(authenticationManager); 
	}

}
