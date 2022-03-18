package omc.training.api;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//CÁCH 1:
//public class DetailsInfos {
//    private TitleInfos title;
//    private SubTitleInfos subTitle;
//    private String author;
//    private ArrayList<String> hashtag;
//}





//CÁCH 2:
public class DetailsInfos {
    private TitleInfos title;
    private SubTitleInfos subTitle;
    private String author;
    private List<String> hashtag;

    public DetailsInfos(TitleInfos title, SubTitleInfos subTitle, String author, ArrayList<String> hashtag){
        this.title = title;
        this.subTitle = subTitle;
        this.author = author;
        this.hashtag = hashtag;
    }
}
