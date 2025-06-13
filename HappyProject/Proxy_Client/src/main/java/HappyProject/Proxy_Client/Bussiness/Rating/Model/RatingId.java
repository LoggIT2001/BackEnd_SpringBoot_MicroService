package HappyProject.Proxy_Client.Bussiness.Rating.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingId implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer productId;
}
