package omc.training.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//CÁCH 1:
//public class TitleInfos {
//    private String titleVi;
//    private String titleEn;
//}







//CÁCH 2:
public class TitleInfos{
    private String titleVi;
    private String titleEn;
    public TitleInfos (String titleVi,String titleEn){
        this.titleVi= titleVi;
        this.titleEn= titleEn;
    }
}
