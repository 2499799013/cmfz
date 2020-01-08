package com.baizhi;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.baizhi.mapper.UserMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    UserMapper userMapper;

    @org.junit.Test
    public void name() {
        Integer integer = userMapper.queryUserByTime("0", 1);
        System.out.println(integer);
    }
    @org.junit.Test
    public void testSms(){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4Ffms5EDRD19AAUQfDqy", "xKSRhKfScbqNMVM4FtEggXB8lNnnNd");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "15135277938");
        request.putQueryParameter("SignName", "图事故");
        request.putQueryParameter("TemplateCode", "SMS_181853729");
        request.putQueryParameter("TemplateParam", "{\"code\":\"2s2b\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
