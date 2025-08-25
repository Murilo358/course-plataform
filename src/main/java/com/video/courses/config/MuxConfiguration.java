package com.video.courses.config;

import com.mux.ApiClient;
import com.mux.auth.HttpBasicAuth;
import com.mux.sdk.AssetsApi;
import com.mux.sdk.DirectUploadsApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MuxConfiguration {


    @Value("${mux.token}")
    private String tokenId;

    @Value("${mux.secret}")
    private String tokenSecret;

    @Bean
    public ApiClient muxApiClient() {
        ApiClient client = new ApiClient();

        client.setBasePath("https://api.mux.com");
        client.setUsername(tokenId);
        client.setPassword(tokenSecret);


        return client;
    }

    @Bean
    public DirectUploadsApi directUploadsApi(ApiClient client) {
        return new DirectUploadsApi(client);
    }


    @Bean
    public AssetsApi assetsApi(ApiClient client) {
        return new AssetsApi(client);
    }
}


