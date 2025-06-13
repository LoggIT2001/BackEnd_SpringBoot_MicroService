package HappyProject.User_Service.Model.Entity;

import HappyProject.User_Service.Audit.BaseEntity;
import HappyProject.User_Service.Constant.AppConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "verification_tokens")
@EqualsAndHashCode(callSuper = true, exclude = {"credential"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerificationToken extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "verification_token_id", unique = true, nullable = false, updatable = false)
    private Integer verificationTokenId;

    @Column(name = "verifi_token")
    private String token;

    @JsonFormat(pattern = AppConstant.LOCAL_DATE_FORMAT, shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = AppConstant.LOCAL_DATE_FORMAT)
    @Column(name = "expire_date")
    private LocalDate expireDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "credential_id")
    private Credential credential;
}
