package com.spring.chboard.Naver;

import java.util.Date;

import lombok.Data;

@Data
public class BooksResponseDto {
    private int display;
    private Item[] items;

    @Data
    static class Item{
        private String title;	
        private String author;  
        private String image;   
        private Integer price;
        private Integer discount;
        private String publisher;
        private String description;
        private Date pubdate;
        
    }

}