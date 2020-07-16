import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.StaticResourceLocation;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
 
 
   	//web root가 아닌 외부 경로에 있는 리소스를 url로 불러올 수 있도록 설정
    //현재 localhost:8090/customer/qna//1234.jpg
    //로 접속하면 C:/ssss/1234.jpg 파일을 불러온다.
 @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/customer/qna/**")  
                .addResourceLocations("file:///C:ssss/"); 
    }
}


     //pom.xml

       <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.6</version>
        </dependency>
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
        </dependency>
        
    // application.properties
        
        #spring json 기본 컨버터가 jackson 이므로 gson 으로 컨버터시 오류가 발생해서 기본을 gson으로 변경
       spring.mvc.converters.preferred-json-mapper=gson

         # 이건 부트 2.3.0 릴리즈 미만일때 spring.http.converters.preferred-json-mapper=gson
