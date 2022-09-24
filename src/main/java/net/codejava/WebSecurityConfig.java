package net.codejava;





import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig  {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider  =new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Bean
	protected InMemoryUserDetailsManager configureAuthentication() {
		
	return 	new InMemoryUserDetailsManager();
	}

	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		     .antMatchers("/list_users").authenticated().antMatchers("/asa").authenticated().antMatchers("/men").
		     authenticated().antMatchers("/women").authenticated().antMatchers("/child").authenticated().
		     antMatchers("/womendelete").authenticated().antMatchers("/mendelete").
		     authenticated().antMatchers("/childdelete").authenticated().
		     antMatchers("/List").authenticated().
		     antMatchers("/filter").authenticated()
		     .anyRequest().permitAll()
		     .and()
		     .formLogin()
		     .usernameParameter("email")
		     .defaultSuccessUrl("/show")
		     .permitAll()
		     .and()
		     .logout().logoutSuccessUrl("/").permitAll();
		return http.build();
	}
	
	
	
	
}
