package github.com.brunomeloesilva.transacao.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
public class SegurancaConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/transacoes/**").hasAuthority("SCOPE_scope-transacao:read")
				.and()
			.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	}
}
//SCOPE está associado ao token, ROLE com usuário.
//SCOPE determina o que o cliente pode fazer em nome do Usuário.