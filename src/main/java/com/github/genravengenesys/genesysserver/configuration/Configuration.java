package com.github.genravengenesys.genesysserver.configuration;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Configuration {

    private final static String connection = "couchbase://localhost";
    private final static String user = "Administrator";
    private final static String pass = "password";
    private final static String bucket = "genesys";

    @Bean
    public Bucket bucket() {
        return Cluster.connect(connection, user, pass).bucket(bucket);
    }
}
