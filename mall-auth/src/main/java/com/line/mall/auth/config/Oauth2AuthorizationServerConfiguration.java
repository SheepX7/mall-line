package com.line.mall.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class Oauth2AuthorizationServerConfiguration {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity httpSecurity) {
        return httpSecurity.authorizeExchange(authorizeExchangeSpec ->
                        authorizeExchangeSpec.anyExchange().permitAll())
                .httpBasic(Customizer.withDefaults()).build();
    }

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .password("1234")
                .username("root")
                .roles("admin").build();
        return new MapReactiveUserDetailsService(userDetails);
    }
}
