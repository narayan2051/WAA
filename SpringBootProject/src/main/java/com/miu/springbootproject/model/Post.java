package com.miu.springbootproject.model;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private long id;
    private String title;
    private String content;
    private String author;
}
