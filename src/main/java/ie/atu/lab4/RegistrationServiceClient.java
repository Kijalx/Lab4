package ie.atu.lab4;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "confirmation-service",url = "http://localhost:8082")
public class RegistrationServiceClient {
}
