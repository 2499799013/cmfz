package com.baizhi.serviceImpl;

import com.baizhi.entity.User;
import com.baizhi.mapper.UserMapper;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(String[] id) {
        userMapper.delete(id);
    }

    @Override
    public Map<String, Object> findByPage(Integer page, Integer rows) {
        //总条数
        Integer count = userMapper.count();
        Integer total =count % rows == 0? count /rows : count / rows + 1;
        Integer start = (page - 1) * rows;
        List<User> byPage = userMapper.queryAll(start, rows);
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows", byPage);
        map.put("records", count);
        map.put("page", page);
        map.put("total", total);
        return map;
    }

    @Override
    public Integer count() {
        Integer count = userMapper.count();
        return count;
    }

    @Override
    public List<User> getCountByprovince() {
        List<User> countByprovince = userMapper.getCountByprovince();
        return countByprovince;
    }
}
