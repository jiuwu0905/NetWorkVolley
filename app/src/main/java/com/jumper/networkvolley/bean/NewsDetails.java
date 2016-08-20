package com.jumper.networkvolley.bean;

/**
 * Created by zhangjun on 16/8/20.
 */
public class NewsDetails {

//    {"addTime":"2015-08-28 09:27:00",
//            "chanelName":"食谱",
//            "collection":false,
//            "countComment":0,
//            "id":1187,
//            "imageUrl":"http://image.jumper-health.com/group1/M00/01/CE/CnQsP1XfuN-ACMWlAAFQBCH7h7c543.jpg",
//            "isFocusImage":0,
//            "isVideo":false,
//            "newsUrl":"http://mobile.jumper-health.com/news/page.do?id=1187",
//            "shareCount":0,
//            "title":"垃圾食品对孕妇及胎儿的影响"}


    public String addTime;
    public String chanelName;

    public boolean  collection;

    public int countComment;
    public String title;


    @Override
    public String toString() {
        return "NewsDetails{" +
                "addTime='" + addTime + '\'' +
                ", chanelName='" + chanelName + '\'' +
                ", collection=" + collection +
                ", countComment=" + countComment +
                ", title='" + title + '\'' +
                '}';
    }
}
