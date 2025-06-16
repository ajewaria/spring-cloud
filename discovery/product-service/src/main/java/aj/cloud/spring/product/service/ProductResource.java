package aj.cloud.spring.product.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductResource {

    //private final DiscoveryClient discoveryClient;
	//private final RestClient restClient;

	// public ProductResource(DiscoveryClient discoveryClient, RestClient.Builder restClientBuilder) {
	// 	this.discoveryClient = discoveryClient;
	// 	restClient = restClientBuilder.build();
	// }

    /*@GetMapping("greet")
    public String greeting() {
        // Get all instances of inventory-service
        List<ServiceInstance> instances = discoveryClient.getInstances("USER-SERVICE");
        if (instances == null || instances.isEmpty()) {
            return "No instances of inventory-service found!";
        }

        // Basic round-robin (or pick random)
        ServiceInstance instance = instances.get(new Random().nextInt(instances.size()));
        String uri = instance.getUri().toString();

		String serviceAResponse = restClient.get()
				.uri(uri + "/helloUser")
				.retrieve()
				.body(String.class);
		return serviceAResponse;
    } */

    private final RestClient restClient;

    public ProductResource(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    @GetMapping("greet")
    public String greeting() {
        String response = restClient.get()
                .uri("http://USER-SERVICE/helloUser")  // Service name in URI
                .retrieve()
                .body(String.class);

        return "Inventory Service responded: " + response;
    }

}
