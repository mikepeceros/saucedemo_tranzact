package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutPersonalInfo {
    private String firstName;
    private String lastName;
    private String postalCode;
}
