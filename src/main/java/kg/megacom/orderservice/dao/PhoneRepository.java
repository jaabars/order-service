package kg.megacom.orderservice.dao;

import kg.megacom.orderservice.models.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {

    boolean existsByMsisdn(String msisdn);
    List<Phone> findPhonesByClient_Id(Long id);
}
