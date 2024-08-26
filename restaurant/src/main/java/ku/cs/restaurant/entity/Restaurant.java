package ku.cs.restaurant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
@Entity
@ToString
@Data
public class Restaurant {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private double rating;
    private String location;
}
