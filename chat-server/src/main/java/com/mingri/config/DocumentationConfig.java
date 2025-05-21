package com.mingri.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 *配置启动链接接口地址
 */
@Component
@Slf4j
public class DocumentationConfig  implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Environment env = event.getApplicationContext().getEnvironment();

        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path", "");
        String docPath = contextPath + "/doc.html";

        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }

        log.info("""
                        \t
                        ----------------------------------------------------------\t
                        应用程序“ {} ”正在运行中......\t
                        配置文件: \t{}
                        接口文档访问 URL:\t
                        本地: \t{}://localhost:{}{}\t
                        外部: \t{}://{}:{}{}
                        ----------------------------------------------------------""",
                env.getProperty("spring.application.name"),
                String.join(",", env.getActiveProfiles()),
                protocol,
                serverPort,
                docPath,
                protocol,
                hostAddress,
                serverPort,
                docPath
                );
    }
}
