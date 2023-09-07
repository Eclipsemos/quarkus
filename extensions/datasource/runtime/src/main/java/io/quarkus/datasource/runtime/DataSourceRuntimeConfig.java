package io.quarkus.datasource.runtime;

import java.util.Optional;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.configuration.TrimmedStringConverter;
import io.smallrye.config.WithConverter;

@ConfigGroup
public interface DataSourceRuntimeConfig {

    /**
     * The datasource username
     */
    Optional<String> username();

    /**
     * The datasource password
     */
    Optional<String> password();

    /**
     * The credentials provider name
     */
    @WithConverter(TrimmedStringConverter.class)
    Optional<String> credentialsProvider();

    /**
     * The credentials provider bean name.
     * <p>
     * This is a bean name (as in {@code @Named}) of a bean that implements {@code CredentialsProvider}.
     * It is used to select the credentials provider bean when multiple exist.
     * This is unnecessary when there is only one credentials provider available.
     * <p>
     * For Vault, the credentials provider bean name is {@code vault-credentials-provider}.
     */
    @WithConverter(TrimmedStringConverter.class)
    Optional<String> credentialsProviderName();
}
