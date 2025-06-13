package HappyProject.Rating_Service.Model.Entity;

import HappyProject.Rating_Service.Audit.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "rating")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Rating extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Id
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "rate")
    private Integer rate;

    @Column(name = "comment")
    private String comment;
}
