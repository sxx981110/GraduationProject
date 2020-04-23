package com.sxx.test;

import com.sxx.entity.Performer;
import com.sxx.util.EasyExcelUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author: sxx
 * @date: 2020/2/18 20:10
 */
@SpringBootTest
public class TestUtils {

    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void test(){
        String admintest12 = DigestUtils.md5Hex("admintest12");
        String admintest13 = DigestUtils.md5Hex("admintest12");
        System.out.println(admintest12);
        System.out.println(admintest13);
        System.out.println(admintest12.equals(admintest13));
    }
    @Test
    public void testExcel() throws FileNotFoundException {
        List<Performer> performers = EasyExcelUtil.readListFrom(new FileInputStream("演员批量导入模板.xlsx"), Performer.class);
        for (Performer performer : performers) {
            System.out.println(performer.toString());
        }
    }
    @Test
    public void testRedis(){
        redisTemplate.opsForValue().set("name","");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }
}
