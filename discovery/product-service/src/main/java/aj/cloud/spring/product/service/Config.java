package aj.cloud.spring.product.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    // @Bean
    // public RestClient.Builder restClientBuilder() {
    //     return RestClient.builder();
    // }

    @Bean
    @LoadBalanced  // Key annotation for enabling service name resolution
    public RestClient.Builder loadBalancedRestClientBuilder() {
        return RestClient.builder();
    }
    
}
