package net.engineeringdigest.journalApp.Config;

import net.engineeringdigest.journalApp.Service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Profile("prod")
public class SpringSecurityProd extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception{
//        http
//                .csrf().disable() // Disable CSRF for simplicity; enable in production
//                .authorizeRequests()
//                .antMatchers("/user/**", "/health-check").permitAll() // Public endpoints
//                .antMatchers("/journal/**").authenticated()          // Secured endpoints
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic(); // Use HTTP Basic authentication
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}