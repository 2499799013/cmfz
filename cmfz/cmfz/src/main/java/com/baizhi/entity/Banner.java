package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banner {
    /*@ExcelIgnore*/
    @Excel(name = "ID" ,width = 20)
    private String id;
    @Excel(name = "图片", type = 2)
    private String img_path;
    @Excel(name = "标签")
    private String title;
    @Excel(name = "状态")
    private String status;
    @Excel(name = "描述信息")
    private String esc;
    @Excel(name = "创建时间", format = "yyyy-MM-dd", width = 20)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date create_date;

}