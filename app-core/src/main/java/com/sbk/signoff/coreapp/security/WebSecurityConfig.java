package com.sbk.signoff.coreapp.security;

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
		httpSecurity
				.authorizeRequests()
					.antMatchers("/h2-console/**").permitAll()
					.antMatchers("/cases/**").permitAll()
					.antMatchers("/users/**").permitAll()
					.antMatchers("/test/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().permitAll();
		httpSecurity.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true);
		httpSecurity
				.csrf()
				.ignoringAntMatchers("/h2-console/**")
				.ignoringAntMatchers("/cases/**")
				.ignoringAntMatchers("/users/**");
		httpSecurity.headers()
				.frameOptions()
				.sameOrigin();
	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers(
//				"/resources/**", "/static/**", "/css/**", "/js/**", "/images/**",
//				"/resources/static/**", "/css/**", "/js/**", "/img/**", "/fonts/**",
//				"/images/**", "/scss/**", "/vendor/**", "/favicon.ico", "/auth/**", "/favicon.png",
//				"/v2/api-docs", "/configuration/ui", "/configuration/security", "/swagger-ui.html",
//				"/webjars/**", "/swagger-resources/**", "/swagge‌​r-ui.html", "/actuator",
//				"/actuator/**");
//	}

}
