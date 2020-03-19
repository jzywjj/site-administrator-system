package com.lft.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KaptchaConfig {

    @Bean
    public DefaultKaptcha getDefaultKaptcha(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        // 图片边框，合法值：yes[默认] , no
        properties.setProperty("kaptcha.border", "yes");
        // 边框颜色，合法值： r,g,b (and optional alpha) 或者 white,black,blue.默认black
        properties.setProperty("kaptcha.border.color", /*"105,179,90"*/"white");
        // 边框厚度，合法值：>0，默认1
//        properties.setProperty("kaptcha.border.thickness", "1");
        // 图片宽，默认200
        properties.setProperty("kaptcha.image.width", "110");
        // 图片高，默认50
        properties.setProperty("kaptcha.image.height", "40");
        // 字体大小，默认40px
        properties.setProperty("kaptcha.textproducer.font.size", "30");
        // 字体，默认Arial, Courier
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        // 字体颜色，合法值： r,g,b  或者 white,black,blue.默认black
        properties.setProperty("kaptcha.textproducer.font.color", "black");
        // session key，默认KAPTCHA_SESSION_KEY
        properties.setProperty("kaptcha.session.key", "code");
        // session date，默认KAPTCHA_SESSION_DATE
//        properties.setProperty("kaptcha.session.date", "KAPTCHA_SESSION_DATE");
        // 验证码长度，默认5
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        // 文字间隔，默认2
        properties.setProperty("kaptcha.textproducer.char.space", "3");
        // 干扰 颜色，合法值： r,g,b 或者 white,black,blue.默认black
        properties.setProperty("kaptcha.noise.color", "blue");
        // 更多可参考：https://blog.csdn.net/elephantboy/article/details/52795309

        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);

        return defaultKaptcha;
    }
}