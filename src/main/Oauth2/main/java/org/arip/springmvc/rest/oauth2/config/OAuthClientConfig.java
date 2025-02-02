package org.arip.springmvc.rest.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class OAuthClientConfig {

    private static final String CLIENT_ID = "your-client-id";
    private static final String CLIENT_SECRET = "your-client-secret";
    private static final String REDIRECT_URI = "http://localhost:8080/login/oauth2/code/microsoft";

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.microsoftClientRegistration());
    }

    private ClientRegistration microsoftClientRegistration() {
        return ClientRegistration.withRegistrationId("microsoft")
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .scope("openid", "email", "profile")
                .authorizationUri("https://login.microsoftonline.com/common/oauth2/v2.0/authorize")
                .tokenUri("https://login.microsoftonline.com/common/oauth2/v2.0/token")
                .userInfoUri("https://graph.microsoft.com/oidc/userinfo")
                .userNameAttributeName("email")
                .redirectUri(REDIRECT_URI)
                .clientName("Microsoft")
                .build();
    }
}
