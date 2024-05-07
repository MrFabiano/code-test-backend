package infra.db.repository;

import domain.entity.EPayment;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class PaymentRepository  implements IPaymentRepository{

    private final List<EPayment> payments = new ArrayList<>();

    @Override
    public void save(EPayment payment) {
        payments.add(payment);
    }

    @Override
    public EPayment findByDevice(String device) {
        for (EPayment payment : payments) {
            if (payment.getDevice().equals(device)) {
                return payment;
            }
        }
        return null; // Retornar null se nenhum pagamento for encontrado com o dispositivo correspondente
    }

    @Override
    public void update(EPayment payment) {
        for (int i = 0; i < payments.size(); i++) {
            if (payments.get(i).getDevice().equals(payment.getDevice())) {
                payments.set(i, payment);
                break; // Parar após a atualização
            }
        }
    }

    @Override
    public void delete(String device) {
        payments.removeIf(payment -> payment.getDevice().equals(device));
    }
}

