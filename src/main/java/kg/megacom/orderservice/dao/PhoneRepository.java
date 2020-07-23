package kg.megacom.orderservice.dao;

import kg.megacom.orderservice.models.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {

    boolean existsByMsisdn(String msisdn);
}
