package com.sbk.signoff.coreapp.init.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.jdbcAuthentication()
				.dataSource(dataSource)
				.withDefaultSchema()
				.withUser(User.withUsername("user")
						.password(passwordEncoder().encode("password"))
						.roles("USER"))
				.withUser(User.withUsername("admin")
						.password(passwordEncoder().encode("password"))
						.roles("USER", "ADMIN"))
		;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
				.antMatchers("/h2-console/**").permitAll()
				.antMatchers("/users/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().permitAll();
		httpSecurity.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true);
		httpSecurity.csrf()
				.ignoringAntMatchers("/h2-console/**");
		httpSecurity.headers()
				.frameOptions()
				.sameOrigin();
	}
}
