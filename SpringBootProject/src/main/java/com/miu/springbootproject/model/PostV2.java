package com.miu.springbootproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Digits;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostV2 {
    private long id;
    private String title;
    private String content;
}
