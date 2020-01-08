package com.baizhi.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    private String id;
    private String title;
    private Integer score;
    private String author;
    private String beam;
    private Integer count;
    private String brief;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date publishDate;
    private String cover;
}
