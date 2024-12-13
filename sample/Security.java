public class SecurityConfig {
	@Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
	String jwkSetUri;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
		.authorizeHttpRequests((authorize) -> authorize
				.anyRequest().authenticated()
		)
		.oauth2ResourceServer((res)->{
			res.jwt(Customizer.withDefaults());
		})
		.addFilterAfter(createPolicyEnforcerFilter(), BearerTokenAuthenticationFilter.class);
return http.build();
    }


    private ServletPolicyEnforcerFilter createPolicyEnforcerFilter() {
		PolicyEnforcerConfig config;

		try {
			config = JsonSerialization.readValue(getClass().getResourceAsStream("/keycloak.json"), PolicyEnforcerConfig.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return new ServletPolicyEnforcerFilter(new ConfigurationResolver() {
			@Override
			public PolicyEnforcerConfig resolve(HttpRequest request) {
				return config;
			}
		});
	}

	@Bean
	JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri).build();
	}

}
