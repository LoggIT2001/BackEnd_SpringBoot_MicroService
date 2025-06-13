package HappyProject.User_Service.Model.Entity;

import HappyProject.User_Service.Audit.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
@EqualsAndHashCode(callSuper = true, exclude = {"user"})
@Builder
public class Address extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", unique = true, nullable = false, updatable = false)
    private Integer addressId;

    @Column(name = "full_address", unique = true)
    private String fullAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
