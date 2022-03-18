package omc.training.api.exercise04;

import com.google.gson.Gson;
import lombok.var;
import vinid.api.rest.*;

import java.util.Scanner;

public class Exercise04 {
    static String hostname;
    static String token;

    public static void main(String[] args) {
        
//Cách thức để nhập giá trị truyền vào từ bàn phím        
        System.out.print("Nhập môi trường test: ");
        Scanner n = new Scanner(System.in);
        String env = n.nextLine();
        
        hostname = getEnvironmentTest(env);      
        
        RestResponse requestOTP = requestOTP("Device_0118000010", "+84118000010").send();    // vì mỗi phương thức đều đang để kết quả trả về là request nên hải gửi request đi để lấy respond
        System.out.println("Request OTP:");
        requestOTP.extract().body().prettyPrint();      // in thông tin respond trả về

        System.out.println("Verify OTP: ");
        RestResponse verifyOTP = verifyOTP("Device_0118000010", "+84118000010", "123456", false).send();
        int code = verifyOTP.extract().body().jsonPath().getInt("meta.code");    // lấy ra 1 thông tin có kiểu 'int' trong respond trả về bằng jsonPath

        if (code != 200000) {
            if (code == 400030) {

                System.out.println(">>>>>>>>>>>>>>>>>>> Wrong OTP");
                System.exit(0);   // dừng hẳn chương trình
            }
            if (code == 400038) {

                System.out.println(">>>>>>>>>>>>>>>>>>> header x-device-id not match");
                System.exit(0);
            } else {
                System.out.println(">>>>>>>>>>>>>>>>>>> hệ thống có vấn đề");
                System.exit(0);
            }
        }
        token = "Bearer " + verifyOTP.extract().body().jsonPath().getString("data.access_token");

        RestResponse getProfile = getProfile("+84118000010").send();
        getProfile.extract().body().prettyPrint();
        System.out.println("");
        System.out.println("Profile của khách hàng:");
        System.out.println("user_id: " + getProfile.extract().body().path("data.user_id"));
        System.out.println("full_name: " + getProfile.extract().body().path("data.full_name"));
        System.out.println("full_name_without_accents: " + getProfile.extract().body().path("data.full_name_without_accents"));
        System.out.println("phone_number: " + getProfile.extract().body().path("data.phone_number"));
        System.out.println("email: " + getProfile.extract().body().path("data.email"));
        System.out.println("dob: " + getProfile.extract().body().jsonPath().getInt("data.dob"));
        if (getProfile.extract().body().jsonPath().getInt("data.gender") == 0) {
            System.out.println("gender: nam");
        } else {
            System.out.println("gender: nữ");
        }
        System.out.println("wallet_status" + getProfile.extract().body().jsonPath().getInt("data.wallet_status"));
        System.out.println("wallet_level: " + getProfile.extract().body().path("data.wallet_level"));
        System.out.println("has_linked_bank: " + getProfile.extract().body().jsonPath().getBoolean("data.has_linked_bank"));
        System.out.println("csn: " + getProfile.extract().body().path("data.csn"));
        System.out.println("referral_code: " + getProfile.extract().body().path("data.referral_code"));
        System.out.println("have_vna_transaction: " + getProfile.extract().body().jsonPath().getBoolean("data.have_vna_transaction"));
        System.out.println("have_vingroup_transaction: " + getProfile.extract().body().jsonPath().getBoolean("data.have_vingroup_transaction"));
        System.out.println("dob: " + getProfile.extract().body().jsonPath().getInt("data.verify_status"));
        System.out.println("verified_fields: " + getProfile.extract().body().path("data.verified_fields"));
        System.out.println("nationality_1: " + getProfile.extract().body().path("data.nationality_1"));
        System.out.println("nationality_2: " + getProfile.extract().body().path("data.nationality_2"));
        System.out.println("occupation: " + getProfile.extract().body().path("data.occupation"));
        System.out.println("position: " + getProfile.extract().body().path("data.position"));
        System.out.println("address: " + getProfile.extract().body().jsonPath().getList("data.address"));
        System.out.println("account_status: " + getProfile.extract().body().path("data.account_status"));
        System.out.println("");
        System.out.println("-----------------------------***~The end~***---------------------------");

// get list object
        AddressInfo addressInfo = getProfile.extract().body().jsonPath().getObject("data.address[0]", AddressInfo.class); 
        // đối với 1 array, luôn luôn phải có index (chỉ số) đi kèm kể cả chỉ có 1 thành phần
        
        System.out.println(addressInfo.getUser_address_id());

        Data data = getProfile.extract().body().jsonPath().getObject("data", Data.class);
        System.out.println(data.getEmail());
        Data hasLinkedBank = getProfile.extract().body().jsonPath().getObject("data",Data.class);
        System.out.println(data.getHas_linked_bank());
    }

    //Request OTP
    /*curl --location --request POST 'https://api-uat.vinid.dev/iam/v1/otp/login/request' \
--header 'X-Device-ID: Device_0118000010' \
--header 'X-RF-Device-ID: Device_0118000010' \
--header 'Content-Type: application/json' \
--data-raw '{
    "phone_number": "+84118000010"
}'

     */
    public static String getEnvironmentTest(String env) {
        if (env.equals("uat")) {
            return "https://api-uat.vinid.dev";
        }
        if (env.equals("sit")) {
            return "https://api-sit.vinid.dev";
        }
        throw new RuntimeException("Env invalid! Must be sit or uat");
    }

    public static RestRequest requestOTP(String deviceID, String phoneNumber) {
        RestMethod method = RestMethod.POST;

        RestHeaders headers = new RestHeaders();
        headers.add("X-RF-Device-ID", "DD_-RtQcv1CP0v1B1zPC1EYQpclsdCWgDIV_PfA5qXAh3P");
        headers.add("Content-Type", "application/json");
        headers.add("X-Device-ID", deviceID);

        RestBody body = new RestBody();
        body.add("phone_number", phoneNumber);

        String path = "/iam/v1/otp/login/request";
        RestRequest request = new RestRequest(hostname, path, method);
        request.setHeader(headers);
        request.setBody(body);
        return request;
    }

    //Verify OTP
    public static RestRequest verifyOTP(String deviceID, String phoneNumber, String otp, Boolean isNewInstall) {
        RestMethod method = RestMethod.POST;

        RestHeaders headers = new RestHeaders();
        headers.add("X-RF-Device-ID", "Device_0118000010");
        headers.add("Content-Type", "application/json");
        headers.add("X-Device-ID", deviceID);

        RestBody body = new RestBody();
        body.add("phone_number", phoneNumber);
        body.add("otp", otp);// để tham số
        body.add("is_new_install", isNewInstall);// để tham số


        String path = "/iam/v1/otp/login/verify";
        RestRequest request = new RestRequest(hostname, path, method);
        request.setBody(body);
        request.setHeader(headers);
        return request;
    }

    //Get Profile
    public static RestRequest getProfile(String deviceID) {
        RestMethod method = RestMethod.GET;
        RestHeaders headers = new RestHeaders();
        headers.add("Authorization", token);
        headers.add("Content-Type", "application/json");
        headers.add("X-Device-ID", deviceID);

        String path = "/user-profile/v2/me/profile/basic";
        RestRequest request = new RestRequest(hostname, path, method);
        request.setHeader(headers);
        return request;
    }


}
