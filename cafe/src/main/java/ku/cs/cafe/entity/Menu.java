package ku.cs.cafe.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Menu {
   @Id
   @GeneratedValue
   private UUID id;


   private String name;
   private double price;

   @ManyToOne
   private Category category;
}

