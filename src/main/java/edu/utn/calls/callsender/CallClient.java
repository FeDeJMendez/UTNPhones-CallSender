package edu.utn.calls.callsender;


import edu.utn.calls.callsender.dto.CallRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CallClient {

    String url;

    public CallClient(@Value("${remote-url}") String remoteUrl) {
        this.url = remoteUrl;
    }

    public void sendCall(String origin, String destination, String datetime, Long duration) {
        CallRequestDto callRequest = new CallRequestDto(origin, destination, datetime, duration);
        RestTemplate restTemplate = new RestTemplate();
        log.info("Sending to {} object {}", this.url, callRequest);
        restTemplate.postForEntity(this.url, callRequest, String.class);
    }


}
