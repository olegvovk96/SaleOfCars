package ua;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ua.service.implementation.UserDetailsServiceImplementation;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsServiceImplementation userDetailsService;
	
	@Autowired
	public void configurerAuthetification(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder (){
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
		.loginPage("/login") 
		.usernameParameter("email")
		.passwordParameter("password")
		.loginProcessingUrl("/login")
		.failureUrl("/login?fail=true")
		.and()
		.logout().logoutUrl("/logout")
		.logoutSuccessUrl("/")
		.deleteCookies("JSESSIONID", "Secret_cookies")
		.and()
		.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.and()
		.exceptionHandling().accessDeniedPage("/")
		.and()
		.rememberMe()
		.rememberMeParameter("rememberMe")
		.key("my super secret key")
		.rememberMeCookieName("Secret_cookies");
	}
}
