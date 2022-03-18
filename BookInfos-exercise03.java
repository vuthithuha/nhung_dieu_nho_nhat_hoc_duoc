package omc.training.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//public class BookInfos {
//    private String isbn;
//    private DetailsInfos details;
//}






//CÁCH 2:
public class BookInfos {
    private String isbn;
    private DetailsInfos details;
    public BookInfos (String isbn, DetailsInfos details){
        this.isbn = isbn;
        this.details = details;
    }

}
