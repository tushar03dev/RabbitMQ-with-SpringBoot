package com.example.senderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/send")
public class MessageController {
    @Autowired
    private StreamBridge streamBridge;

    @PostMapping
    public String send(@RequestBody String msg) {
        streamBridge.send("send-out-0", msg);
        return "Message sent " + msg;
    }

}