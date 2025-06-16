package aj.cloud.spring.user.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Value("${server.port}")
    private String port;

    @GetMapping("/helloUser")
	public String helloWorld() {
		return String.format("User responded from PORT: {}!" + port);
	}

}
