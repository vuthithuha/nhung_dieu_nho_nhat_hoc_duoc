package omc.training.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//CÁCH 1: với cách này, khi vào hàm main sẽ cần gán giá trị cho từng biến với hàm ~~~~~~~~~~<tên class>.set<tên biến>
//public class TitleInfos {
//    private String titleVi;
//    private String titleEn;
//}







//CÁCH 2: với cách này, chỉ cần truyền tham số vào trong hàm
public class TitleInfos{
    private String titleVi;
    private String titleEn;
    public TitleInfos (String titleVi,String titleEn){
        this.titleVi= titleVi;
        this.titleEn= titleEn;
    }
}
