package omc.training.api;

import lombok.Getter;
import lombok.Setter;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

@Getter
@Setter
public class UserInfos {
    private String userId;
    private String username;
    private BookInfos[] books;

}
