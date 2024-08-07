package DW.PocatRush.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5500", "http://127.0.0.1:5501" , "http://localhost:3000")// 이 주소로 오는 것은 다 받아줌
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용하는 메소드
                .allowCredentials(true); // 인증정보 시도
        // 리액트 -> 서버로 요청 할 때
        // 1. const url = "http://localhost:8080/api/~~~" 로 시작
        // 2. @RequestMapping("api/~~~) Bean 등록
    }
}