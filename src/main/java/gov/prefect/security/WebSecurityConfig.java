package gov.prefect.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;


	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
	     http.formLogin().loginPage("/login");//.permitAll(true).and().logout().logoutSuccessUrl("/mylog?logout").permitAll();
	     http.authorizeRequests().antMatchers("/home/").hasRole("USER");
	     http.authorizeRequests().antMatchers("/").hasRole("USER");
	     http.authorizeRequests().antMatchers("/articles/").hasRole("USER");
	     http.authorizeRequests().antMatchers("/bonSortie/").hasRole("USER");
	     http.authorizeRequests().antMatchers("/bonSortie/creerBonS").hasRole("ADMIN");
	     http.authorizeRequests().antMatchers("/bonSortie/ajouterLigneS").hasRole("ADMIN");
	     http.authorizeRequests().antMatchers("/bonSortie/supprimerLigneS").hasRole("ADMIN");
	     http.authorizeRequests().antMatchers("/bonSortie/enrgistrerBonS").hasRole("ADMIN");
	     http.authorizeRequests().antMatchers("/divisions/").hasRole("USER");
	     http.authorizeRequests().antMatchers("/categories/").hasRole("USER");
	     http.authorizeRequests().antMatchers("/fournisseurs/").hasRole("USER");
	     http.authorizeRequests().antMatchers("/articles/nouveau").hasRole("ADMIN");
	     http.authorizeRequests().antMatchers("/articles/modifier").hasRole("ADMIN");
	     http.authorizeRequests().antMatchers("/articles/supprimer").hasRole("ADMIN");
	     http.authorizeRequests().antMatchers("/bonSortie/nouveauS").hasRole("ADMIN");
	     http.authorizeRequests().antMatchers("/fournisseurs/modifier").hasRole("ADMIN");
	     http.authorizeRequests().antMatchers("/fournisseurs/supprimer").hasRole("ADMIN");
	     http.authorizeRequests().antMatchers("/fournisseurs/nouveau").hasRole("ADMIN");
	     http.authorizeRequests().antMatchers("/divisions/nouveau").hasRole("ADMIN");
	     http.authorizeRequests().antMatchers("/categories/nouveau").hasRole("ADMIN");
	     http.authorizeRequests().antMatchers("/categories/modifier").hasRole("ADMIN");
	     http.authorizeRequests().antMatchers("/categories/supprimer").hasRole("ADMIN");
	     http.authorizeRequests().antMatchers("/users/**").hasRole("ADMIN");
	     http.exceptionHandling().accessDeniedPage("/deny");
	 }
	
	 @Autowired
	 public void configure(AuthenticationManagerBuilder auth) throws Exception {
//	     auth
//	             .inMemoryAuthentication()
//	             .withUser("medo").password("{noop}medo").roles("ADMIN","USER");
//		 auth
//		     .inMemoryAuthentication()
//		     .withUser("faty").password("{noop}faty").roles("USER");
		 
		 auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username as principal, password as credentials, active from users where username =?")
		 .authoritiesByUsernameQuery("select username as principal, role as role from users_roles where username =?")
		 .rolePrefix("ROLE_");
	 }
	 
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

 
}
