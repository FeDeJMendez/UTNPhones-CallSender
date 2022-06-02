package edu.utn.calls.callsender;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@Service
public class CallService {


    private final String callsFile;
    private final CallClient client;

    public CallService(@Value("${calls-file}") String callsFile, @Autowired CallClient client) {
        this.callsFile = callsFile;
        this.client = client;
    }


    public void sendCalls() {

        try {
            List<String> calls = FileUtils.readLines(new File(callsFile), Charset.defaultCharset());

            for (String line : calls) {
                String[] data = line.split(";");
                client.sendCall(data[0], data[1], data[2], Long.parseLong(data[3]));
            };


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
