package ie.atu.lab4;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private RegistrationServiceClient registrationServiceClient;
    private RegistrationNotificationClient registrationNotificationClient;

    @Autowired
    public UserController(RegistrationServiceClient registrationServiceClient, RegistrationNotificationClient registrationNotificationClient){
        this.registrationServiceClient = registrationServiceClient;
        this.registrationNotificationClient = registrationNotificationClient;
    }

    @PostMapping("/confirm-and-register")
    public Map<String, String> confirmAndRegister(@RequestBody UserDetails userDetails){
        String confirm = registrationServiceClient.someDetails(userDetails);
        String notification = registrationNotificationClient.someDetails(userDetails);
        Map<String, String> responseMessage = new HashMap<>();
        responseMessage.put("message",confirm);
        responseMessage.put("Notification", notification);
        return responseMessage;
    }

    @PostMapping("/register")
    public UserDetails register(@RequestBody UserDetails userDetails){
        return userDetails;
    }
}
