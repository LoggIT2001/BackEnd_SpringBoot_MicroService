package HappyProject.Rating_Service.Repository;

import HappyProject.Rating_Service.Model.Entity.Rating;
import HappyProject.Rating_Service.Model.Entity.RatingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, RatingId> {
}
