package com.baizhi.serviceImpl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.Banner;
import com.baizhi.mapper.BannerMapper;
import com.baizhi.service.BannerService;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper;
    //查询所有并导入exl
    @Override
    public List<Banner> queryAll(HttpServletResponse response) throws Exception {
        List<Banner> banners = bannerMapper.queryAll();
        for (Banner banner : banners) {
            banner.setImg_path("D:\\untitled\\cmfz\\cmfz\\src\\main\\webapp\\img\\"+banner.getImg_path());
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("轮播图", "轮播图"), Banner.class, banners);
        String encode = URLEncoder.encode("轮播图.xls", "UTF-8");
        response.setHeader("content-disposition", "attachment;filename=" + encode);
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        return null;
    }

    //添加
    @Override
    public void insert(Banner banner) {
        bannerMapper.insert(banner);
    }
    //修改
    @Override
    public void update(Banner banner) {
        bannerMapper.update(banner);
    }
    //批量删除
    @Override
    public void delete(String[] id) {
        bannerMapper.delete(id);
    }
    //总条数
    @Override
    public Integer count() {
        Integer count = bannerMapper.count();
        return count;
    }
    //分页查询
    @Override
    public Map<String, Object> findByPage(Integer page, Integer rows) {
        //总条数
        Integer count = bannerMapper.count();
        Integer total =count % rows == 0? count /rows : count / rows + 1;
        Integer start = (page - 1) * rows;
        List<Banner> byPage = bannerMapper.findByPage(start, rows);
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows", byPage);
        map.put("records", count);
        map.put("page", page);
        map.put("total", total);
        return map;
    }
}
