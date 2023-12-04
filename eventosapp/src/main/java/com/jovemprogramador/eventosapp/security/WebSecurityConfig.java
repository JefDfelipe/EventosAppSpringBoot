// package com.jovemprogramador.eventosapp.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// /*
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// */

// @Configuration
// @EnableWebSecurity
// public class WebSecurityConfig {

// 	@Bean
// 	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
// 		http.csrf((csrf) -> csrf.disable()) // habilita e desabila recursos de segurança
// 				.authorizeHttpRequests(
// 						(authz) -> authz.requestMatchers(HttpMethod.GET, "/").permitAll()
// 						.requestMatchers(HttpMethod.GET, "/cadastrarEvento").hasRole("ADMIN")
// 						.requestMatchers(HttpMethod.POST, "/cadastrarEvento").hasRole("ADMIN")
// 						.anyRequest().authenticated())
// 				.formLogin((formLogin) -> formLogin.loginPage("/login").defaultSuccessUrl("/cadastrarEvento", true).permitAll())
// 				.logout((logout) -> logout.logoutSuccessUrl("/").permitAll());

// 		return http.build();
// 	}

// 	@Bean
// 	public WebSecurityCustomizer webSecurityCustomizer() {
// 		return (web) -> web.ignoring().requestMatchers("/materialize/**", "/style/**");
// 	}

// //	@Bean
// //	public InMemoryUserDetailsManager userDetailsService() {// para senha gerada pelo spring precisa comentar esse metodo
// //		UserDetails user = User.withDefaultPasswordEncoder().username("helo").password("123").roles("ADMIN").build();
// //		UserDetails admin = User.withDefaultPasswordEncoder().username("user").password("245").roles("USER").build();
// //
// //		return new InMemoryUserDetailsManager(user, admin);
// //	}

// 	@Bean
// 	public PasswordEncoder passwordEncoder() {
// 		return new BCryptPasswordEncoder();
// 	}
// }
