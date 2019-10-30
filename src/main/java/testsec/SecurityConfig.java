package testsec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.jwk.JwkTokenStore;

@Configuration
public class SecurityConfig extends ResourceServerConfigurerAdapter {
	
	@Value("${spring.security.oauth2.resource.jwk.key-set-uri}")
	String keySetUri;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/test")
				.authorizeRequests()
				.anyRequest()
				.hasAuthority("user_role");
	}
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(new JwkTokenStore(this.keySetUri));
	}
	
}
