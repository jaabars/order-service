package kg.megacom.orderservice.models.entity;

import kg.megacom.orderservice.models.enums.ClientStatus;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(value = EnumType.STRING)
    private ClientStatus status;
}
