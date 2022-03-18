package omc.training.api.exercise04;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressInfo {
    private int user_address_id;
    private int type;
    private String district;
    private String city;
    private String commune;
    private String address;
}
