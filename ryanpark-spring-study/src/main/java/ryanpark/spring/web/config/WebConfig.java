package ryanpark.spring.web.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
https://velog.io/@user1/CORS-springboot
@EnableWebMvc 가  아래 코드와 동일한 것 같다.

@Configuration
public class WebConfig implements WebMvcConfigurer {

CORS, 즉 Cross-Origin Resource Sharing,는 웹페이지가 다른 도메인의 리소스에 접근할 수 있도록 허용하는 메커니즘이다. 기본적으로, 웹 브라우저는 보안상의 이유로 "동일 출처 정책(Same-Origin Policy)"을 적용한다. 이 정책은 한 출처(origin)에서 로드된 문서나 스크립트가 다른 출처의 리소스와 상호작용하는 것을 제한한다.

CORS는 이러한 제한을 완화할 수 있는 방법을 제공한다. 웹 애플리케이션은 HTTP 헤더를 사용하여 다른 출처의 리소스에 대한 접근을 허용할 수 있다. 예를 들어, 웹 서버는 Access-Control-Allow-Origin이라는 HTTP 헤더를 사용하여 특정 출처의 요청을 수락하거나 모든 출처의 요청을 허용할 수 있다.


Spring Boot를 사용하여 백엔드 서버에서 CORS를 허용

@CrossOrigin 어노테이션 사용
이 방법은 특정 컨트롤러 또는 메소드에만 CORS를 적용할 때 유용하다.

전역 CORS

WebMvcConfigurer 인터페이스를 구현하여 addCorsMappings 메서드를 오버라이드함으로써 CORS 설정을 적용할 수 있다. 이 방법은 Spring Boot 애플리케이션에서 전역 CORS 설정을 적용하는 데 자주 사용되며, 모든 컨트롤러와 핸들러 메소드에 대한 CORS 정책을 중앙에서 관리할 수 있게 해준다.

CORS 필터 사용

Spring Boot에서 제공하는 CorsFilter를 사용하여 CORS 설정을 할 수 있다. 이 방법은 더 세밀한 설정이 필요할 때 유용하다.


https://diary-developer.tistory.com/31

2. CORS 설정하기
내 경우는 WebConfig에서 addCorsMappings 오버라이딩을 통해 CORS 설정을 했다.

그런데....
그래도 CORS 오류가 발생한다....😂

정보들을 찾아보니 addCorsMappings메소드는 Spring MVC에서 사용하는 메소드로

설정을 자동으로 하는 Spring Boot와는 설정 충돌이 일어날 수 있다고 한다!!!

3. CorsFilter 설정하기
CorsFilter를 추가하여 직접 설정을 하면 된다.
CorsFilter를 만들어도 되는데 내 경우는 WebConfig에 설정을 추가했다.


만약 여러 필터를 사용 중이라면 CorsFilter의 순서를 가장 빠르게 하면 된다.

테스트 용도라 CORS 헤더를 "*" 사용해서 모두 허용했지만,
필요에 맞게 값은 수정하면 된다.
출처: https://diary-developer.tistory.com/31 [일반인의 웹 개발일기:티스토리]


https://blog.naver.com/whdgml1996/221895840461


 */

@Configuration
@EnableWebMvc
public class WebConfig {

    private static final Long MAX_AGE = 3600L;
    private static final int CORS_FILTER_ORDER = -102;

    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
//        모든 Origin 에 대해 허용한다.
        config.addAllowedOrigin("*");
//        허용할 header type
        config.setAllowedHeaders(Arrays.asList(
                HttpHeaders.AUTHORIZATION,
                HttpHeaders.CONTENT_TYPE,
                HttpHeaders.ACCEPT));
//        허용한 method
        config.setAllowedMethods(Arrays.asList(
                HttpMethod.GET.name(),
                HttpMethod.POST.name(),
                HttpMethod.PUT.name(),
                HttpMethod.DELETE.name()));
        config.setMaxAge(MAX_AGE);
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));

        // should be set order to -100 because we need to CorsFilter before SpringSecurityFilter
        bean.setOrder(CORS_FILTER_ORDER);
        return bean;
    }
}
