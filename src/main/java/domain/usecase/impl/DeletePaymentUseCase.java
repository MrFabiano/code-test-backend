package domain.usecase.impl;

import app.rest.ResourceInterceptor;
import domain.usecase.IDeletePaymentUseCase;
import infra.db.repository.IPaymentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.ForbiddenException;

@ApplicationScoped
public class DeletePaymentUseCase implements IDeletePaymentUseCase {

    IPaymentRepository paymentRepository;
    ResourceInterceptor resourceInterceptor;

    @Inject
    public DeletePaymentUseCase(IPaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void delete(String device, String token) {
        if (resourceInterceptor.usuarioTemPermissao(token)) {
            // Chama o método delete no repositório de pagamento
            paymentRepository.delete(token);
        } else {
            throw new ForbiddenException("Usuário não tem permissão para excluir o pagamento.");
        }
    }
}

