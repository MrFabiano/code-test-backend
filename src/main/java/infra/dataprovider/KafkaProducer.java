package infra.dataprovider;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;


@ApplicationScoped
public class KafkaProducer {

    @Inject
    @Channel("devices-events")
    Emitter<String> devicesEventsEmitter;

    @Inject
    @Channel("devices-events.retry")
    Emitter<String> retryEmitter;

    @Inject
    @Channel("devices-events.dlq")
    Emitter<String> dlqEmitter;

    public void sendDeviceReleasedEvent(String device) {
        // Monta o evento de dispositivo liberado
        String event = "{ \"data\": { \"device\": \"" + device + "\" } }";
        // Publica o evento no tópico Kafka
        devicesEventsEmitter.send(event);
        System.out.println("Sent device released event: " + event);
    }

    public void sendRetryEvent(String device, String errorEnum, String errorException) {
        // Monta o evento de retry
        String event = "{ \"data\": { \"device\": \"" + device + "\", \"errorEnum\": \"" + errorEnum + "\", \"errorException\": \"" + errorException + "\" } }";
        // Publica o evento no tópico de retry
        retryEmitter.send(event);
        System.out.println("Sent retry event: " + event);
    }

    public void sendDLQEvent(String device, String errorEnum, String errorException) {
        // Monta o evento da DLQ
        String event = "{ \"data\": { \"device\": \"" + device + "\", \"errorEnum\": \"" + errorEnum + "\", \"errorException\": \"" + errorException + "\" } }";
        // Publica o evento no tópico de DLQ
        dlqEmitter.send(event);
        System.out.println("Sent DLQ event: " + event);
    }
}