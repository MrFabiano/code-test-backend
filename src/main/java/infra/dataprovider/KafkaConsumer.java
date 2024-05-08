package infra.dataprovider;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;


@ApplicationScoped
public class KafkaConsumer {

    @Incoming("contractions-events")
    public void consume(String message) {
        // processar a mensagem consumida
        System.out.println("Consumed message: " + message);
    }
}