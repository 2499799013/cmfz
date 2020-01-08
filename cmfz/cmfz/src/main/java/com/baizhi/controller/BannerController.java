package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("banner")
public class BannerController {
    @Autowired
    BannerService bannerService;

    @RequestMapping("edit")
    public String edit(Banner banner,String oper,String[] id){
        if (oper.equals("add")){
            String s = UUID.randomUUID().toString();
            banner.setId(s);
           banner.setCreate_date(new Date());
            bannerService.insert(banner);
            return s;
        }else if (oper.equals("del")){
            bannerService.delete(id);
        }else {
            if (banner.getImg_path()==""){
                banner.setImg_path(null);
                bannerService.update(banner);
            }else {
                bannerService.update(banner);
                return banner.getId();
            }
        }
        return null;
    }

    @RequestMapping("upload")
    public void upload(MultipartFile img_path, String bannerId, HttpSession session){
        //获取图片存储路径
        String realPath = session.getServletContext().getRealPath("/img");
        //判断文件是否存在
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }

        String originalFilename = img_path.getOriginalFilename();
        String newFileName=new Date().getTime() +"_"+originalFilename;
        try {
            img_path.transferTo(new File(realPath,newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Banner banner = new Banner();
        banner.setId(bannerId);
        banner.setImg_path(newFileName);
        bannerService.update(banner);
    }

    //查询所有
    @RequestMapping("queryAll")
    public void queryAll(HttpServletResponse response) throws Exception {
        List<Banner> banners = bannerService.queryAll(response);
    }

    //分页查询d
    @RequestMapping("findAllByPage")
    public Map<String, Object> findByPage(Integer page, Integer rows) {
        Map<String, Object> byPage = bannerService.findByPage(page, rows);
        return byPage;
    }
}
