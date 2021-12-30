package com.line.mall.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;


@Configuration
@EnableOAuth2Client
public class Oauth2ClientConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "security.oauth2.client.auth-code")
    public OAuth2ProtectedResourceDetails clientOauth2ResourceDetails() {
        return new AuthorizationCodeResourceDetails();
    }

    @ConfigurationProperties(prefix = "security.oauth2.client.client-creds")
    @Bean
    public OAuth2ProtectedResourceDetails messagingClientClientCredsDetails() {
        return new ClientCredentialsResourceDetails();
    }

    @ConfigurationProperties(prefix = "security.oauth2.client.client-password")
    @Bean
    public OAuth2ProtectedResourceDetails messagingClientPasswordDetails() {
        return new ResourceOwnerPasswordResourceDetails();
    }

    @Bean
    public OAuth2RestTemplate clientAuthCodeRestTemplate(
            @Qualifier("clientOauth2ResourceDetails") OAuth2ProtectedResourceDetails resourceDetails,
            OAuth2ClientContext oauth2ClientContext) {
        return new OAuth2RestTemplate(resourceDetails, oauth2ClientContext);
    }
}
