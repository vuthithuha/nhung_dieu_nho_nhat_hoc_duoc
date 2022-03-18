package omc.training.api.exercise04;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Data {
    private String user_id;
    private String full_name;
    private String full_name_without_accents;
    private String phone_number;
    private String email;
    private String dob;
    private String gender;
    private int wallet_status;
    private String wallet_level;
    private Boolean has_linked_bank;
    private String csn;
    private String referral_code;
    private Boolean have_vna_transaction;
    private Boolean have_vingroup_transaction;
    private int verify_status;
    private ArrayList<String> verified_fields;
    private int full_name_edit_counter;
    private int wallet_ref_code;
    private int identity_documents;
    private String nationality_1;
    private int nationality_2;
    private String occupation;
    private int position;
    private AddressInfo[] address;
    private String account_status;
}
