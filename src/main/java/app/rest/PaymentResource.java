package app.rest;

import app.dto.PaymentRequest;
import domain.entity.EPayment;
import infra.db.repository.IPaymentRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/payment")
public class PaymentResource {

    @Inject
    IPaymentRepository paymentRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response processPayment(PaymentRequest paymentRequest) {
        if (paymentRequest != null) {
             //Aqui você implementaria a lógica real para processar o pagamento
            // Por exemplo, você pode chamar um serviço para processar o pagamento
             //PaymentService paymentService = new PaymentService();
            // paymentService.processPayment(paymentRequest);

            // Supondo que a operação seja bem-sucedida, você retornaria o código 201 (CREATED)
            return Response.status(Response.Status.CREATED).build();
        } else {
            // Se o pagamento for inválido ou não existir, você retornaria um código 400 (BAD REQUEST)
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public EPayment getPayment() {
        String device = "example_device_id";
        return paymentRepository.findByDevice(device);
    }
}
