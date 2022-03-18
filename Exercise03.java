package omc.training.api;

import vinid.api.rest.*;
import vinid.api.rest.auth.RestPreemptiveBasicAuth;

import java.util.ArrayList;
import java.util.List;

public class Exercise03 {

    public static void main(String[] args) {
        /*
        {
    "userId": "fe6bbcb0-e9d4-4e65-9a01-3807bc3262ee",
    "username": "ngocnguyen18006",
    "books": [
        {
            "isbn": "9781449325862",
            "details":{
                    "title":{
                            "titleVi":"Git Pocket Guide (VI)",
                            "titleEn":"Git Pocket Guide (EN)"
                        }
                    "subTitle":{
                            "subTitleVi":"A Working Introduction (VI)",
                            "subTitleEn":"A Working Introduction (EN)"
                        }
                    "author": "Richard E. Silverman",
                    "hashtag": ["Git Guide", "Git Pocket Guide"]
            }
        },
        {
            "isbn": "9781449331818",
            "details":{
                    "title": {
                        "titleVi":"Learning JavaScript Design Patterns (VI)",
                        "titleEn":"Learning JavaScript Design Patterns (EN)"
                    }
                    "subTitle": {
                        "subTitleVi":"A JavaScript and jQuery Developer's Guide (VI)",
                        "subTitleEn":"A JavaScript and jQuery Developer's Guide (EN)"
                    }
                    "author": "Addy Osmani",
                    "hashtag": ["JavaScript", "jQuery Developer", "JavaScript Design Patterns"]
            }
        }
    ]
}
         */

        //exercise1: Hãy tạo ra các class tương ứng để match tương ứng với các thuộc tính trong json.
        //tạo các đối tượng tương ứng với các lớp (lớp UserInfos--> BookInfos -->DetailsInfos-->{TitleInfos và SubTitleInfos}

// CÁCH 1:--------------------------------------------------------------------------------------------------------------

//        UserInfos userInfos = new UserInfos();
//        BookInfos[] bookInfos = new BookInfos[2];
//        DetailsInfos detailsInfos0 = new DetailsInfos();
//
//        TitleInfos titleInfos0 = new TitleInfos();
//        titleInfos0.setTitleVi("Git Pocket Guide (VI)");
//        titleInfos0.setTitleEn("Git Pocket Guide (EN)");
//        detailsInfos0.setTitle(titleInfos0);
//
//        SubTitleInfos subTitleInfos0 = new SubTitleInfos();
//        subTitleInfos0.setSubTitleVi("A Working Introduction (VI)");
//        subTitleInfos0.setSubTitleEn("A Working Introduction (EN)");
//        detailsInfos0.setSubTitle(subTitleInfos0);
//
//        detailsInfos0.setAuthor("Richard E. Silverman");
//
//        ArrayList<String> hashtags0 = new ArrayList<String>();
//        hashtags0.add("Git Guide");
//        hashtags0.add("Git Pocket Guide");
//        detailsInfos0.setHashtag(hashtags0);
//
//        bookInfos[0] = new BookInfos();
//        bookInfos[0].setIsbn("9781449325862");
//        bookInfos[0].setDetails(detailsInfos0);
//
//        DetailsInfos detailsInfos1 = new DetailsInfos();
//
//        TitleInfos titleInfos1 = new TitleInfos();
//        titleInfos1.setTitleVi("Learning JavaScript Design Patterns (VI)");
//        titleInfos1.setTitleEn("Learning JavaScript Design Patterns (EN)");
//        detailsInfos1.setTitle(titleInfos1);
//
//        SubTitleInfos subTitleInfos1 = new SubTitleInfos();
//        subTitleInfos1.setSubTitleVi("A JavaScript and jQuery Developer's Guide (VI)");
//        subTitleInfos1.setSubTitleEn("A JavaScript and jQuery Developer's Guide (EN)");
//        detailsInfos1.setSubTitle(subTitleInfos1); // cái này để ngay trên lệnh gán giá trị cũng được, không ảnh hưởng
//
//        detailsInfos1.setAuthor("Addy Osmani");
//
//        ArrayList<String> hashtags1 = new ArrayList<String>();
//        hashtags1.add("JavaScript");
//        hashtags1.add("jQuery Developer");
//        hashtags1.add("JavaScript Design Patterns");
//        detailsInfos1.setHashtag(hashtags1);
//
//        bookInfos[1] = new BookInfos();
//        bookInfos[1].setDetails(detailsInfos1);
//        bookInfos[1].setIsbn("9781449331818");
//
//        userInfos.setBooks(bookInfos);
//        userInfos.setUserId("fe6bbcb0-e9d4-4e65-9a01-3807bc3262ee");
//        userInfos.setUsername("ngocnguyen18006");




//CÁCH 2:---------------------------------------------------------------------------------------------------------------

        UserInfos userInfos = new UserInfos();
        BookInfos[] bookInfos = new BookInfos[2];

        TitleInfos titleInfos0 = new TitleInfos("Git Pocket Guide (VI)","Git Pocket Guide (EN)");

        SubTitleInfos subTitleInfos0 = new SubTitleInfos("A Working Introduction (VI)","A Working Introduction (EN)");

        ArrayList<String> hashtags0 = new ArrayList<String>();
        hashtags0.add("Git Guide");
        hashtags0.add("Git Pocket Guide");

        DetailsInfos detailsInfos0 = new DetailsInfos(titleInfos0,subTitleInfos0,"Richard E. Silverman", hashtags0);

        bookInfos[0] = new BookInfos("9781449325862",detailsInfos0);

        ArrayList<String> hashtags1 = new ArrayList<String>();
        hashtags1.add("JavaScript");
        hashtags1.add("jQuery Developer");
        hashtags1.add("JavaScript Design Patterns");

        TitleInfos titleInfos1 = new TitleInfos("Learning JavaScript Design Patterns (VI)","Learning JavaScript Design Patterns (EN)");

        SubTitleInfos subTitleInfos1 = new SubTitleInfos("A JavaScript and jQuery Developer's Guide (VI)","A JavaScript and jQuery Developer's Guide (EN)");


        DetailsInfos detailsInfos1 = new DetailsInfos(titleInfos1, subTitleInfos1,"Addy Osmani",hashtags1);

        bookInfos[1] = new BookInfos("9781449331818",detailsInfos1);

        userInfos.setBooks(bookInfos);
        userInfos.setUserId("fe6bbcb0-e9d4-4e65-9a01-3807bc3262ee");
        userInfos.setUsername("ngocnguyen18006");


//Exercise2: Hãy tạo 1 đối tượng RestBody thông qua 1 đối tượng của UserInfo và in ra kết quả là một json string như trên.
        RestBody body = new RestBody(userInfos);
        System.out.println(body.prettyPrint());

//exercise3: Sử dụng đối tượng RestBody ở trên, hãy thay đổi giá trị của key titleVI của quyển sách đầu tiên trong danh sách books (từ "Git Pocket Guide (VI)" thành "Git Pocket Guide (VI) - Updated")
    ////(Ghi chú bài 2 để chạy được bài 3)
// exercise3- cách 1: Thay đổi trực tiếp bằng method của RestBody
//        RestBody body = new RestBody(userInfos);
        body.addMapWithJsonPath("book[0].details.title","titleVi","Git Pocket Guide (VI) - Updated");
//        System.out.println(body.prettyPrint());

// exercise3- cách 2:Thay đổi thông qua đối tượng userInfos
//        titleInfos0.setTitleVi("Git Pocket Guide (VI) - Updated");
//        RestBody body = new RestBody(userInfos);
//        System.out.println(body.prettyPrint());



    }


}
