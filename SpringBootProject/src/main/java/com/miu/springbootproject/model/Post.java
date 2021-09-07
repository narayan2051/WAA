package com.miu.springbootproject.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="POST")
public class Post {
    @Id
    private long id;
    private String title;
    private String content;
    private String author;

}
