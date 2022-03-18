package omc.training.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

//CÁCH 1:
//public class SubTitleInfos {
//    private String subTitleVi;
//    private String subTitleEn;
//}






//CÁCH 2:
public class SubTitleInfos {
    private String subTitleVi;
    private String subTitleEn;
    public SubTitleInfos(String subTitleVi, String subTitleEn){
        this.subTitleVi= subTitleVi;
        this.subTitleEn = subTitleEn;
    }
}
