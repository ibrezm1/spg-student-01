package com.example.demo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.Date; // Import the Date class

@Service
public class SchService {
    @Scheduled(fixedRate = 15000) // Runs every 5 seconds
    public void runScheduledTask() {
        // Put your scheduled task logic here
        System.out.println("Scheduled task executed at: " + new Date());
    }
}
