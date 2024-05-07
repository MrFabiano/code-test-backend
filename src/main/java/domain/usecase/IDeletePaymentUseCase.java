package domain.usecase;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface IDeletePaymentUseCase {

    void delete(String device, String token);
}


