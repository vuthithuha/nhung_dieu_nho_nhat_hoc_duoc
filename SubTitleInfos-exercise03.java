package omc.training.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

//CÁCH 1: với cách này , khi chạy gọi đối tượng trong hàm main thì sẽ cần gán giá trị của từng biến với hàm ~~~~~~<tên class>.set<tên biến>~~~~~~
//public class SubTitleInfos {
//    private String subTitleVi;
//    private String subTitleEn;
//}






//CÁCH 2: với cách này, khi gọi trong hàm main thì chỉ cần truyền tham số vào trong 
public class SubTitleInfos {
    private String subTitleVi;
    private String subTitleEn;
    public SubTitleInfos(String subTitleVi, String subTitleEn){
        this.subTitleVi= subTitleVi;
        this.subTitleEn = subTitleEn;
    }
}
