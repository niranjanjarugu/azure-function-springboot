@Configuration
@EnableWebSecurity
public class OAuth2LoginConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests(authorize -> authorize
                .anyRequest().authenticated()
                )
        
        .oauth2Login(withDefaults());
        return http.build();
        
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.azureClientRegistration());
    }

    @Bean
    public OAuth2AuthorizedClientService authorizedClientService(
            ClientRegistrationRepository clientRegistrationRepository) {
        return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository);
    }

    @Bean
    public OAuth2AuthorizedClientRepository authorizedClientRepository(
            OAuth2AuthorizedClientService authorizedClientService) {
        return new AuthenticatedPrincipalOAuth2AuthorizedClientRepository(authorizedClientService);
    }

    private ClientRegistration azureClientRegistration() {
        return ClientRegistration.withRegistrationId("azure")
                .clientId("my-client-id")
                .clientSecret("my-secret")
                .scope("openid", "profile", "email")
           .authorizationUri("https://login.microsoftonline.com/xxx/oauth2/v2.0/authorize")
                .tokenUri("https://login.microsoftonline.com/xxx/oauth2/v2.0/token")
                .build();

}
