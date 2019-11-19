package com.gisinfo.sand;

import com.gisinfo.sand.core.web.SandContext;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ServletComponentScan("com.gisinfo.sand")
@EnableAspectJAutoProxy(exposeProxy=true,proxyTargetClass=true)
@EnableAsync
@EnableCaching
public class SandApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SandContext.isRunOnJar = true;
        SpringApplication application=new SpringApplication(SandApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        SandContext.isRunOnJar = false;
        application.application().setBannerMode(Banner.Mode.OFF);
        return application.sources(SandApplication.class);
    }
}