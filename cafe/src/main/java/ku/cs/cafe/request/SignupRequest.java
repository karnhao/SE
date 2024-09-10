package ku.cs.cafe.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class SignupRequest {

   @NotBlank
   @Size(min = 4)
   private String username;

   @NotBlank
   @Size(min = 8, max = 128)
   private String password;

   @NotBlank(message = "Name is required")
   @Pattern(regexp = "^[a-zA-Z]+$", message = "Name only contain letters")
   private String name;
}

