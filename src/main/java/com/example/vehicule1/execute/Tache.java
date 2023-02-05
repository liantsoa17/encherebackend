package com.example.vehicule1.execute;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Tache {

    @Scheduled(fixedDelay = 1000)
    public void runTask() {
        // code de la tâche ici
    }

}
