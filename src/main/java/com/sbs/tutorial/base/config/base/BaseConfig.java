package com.sbs.tutorial.base.config.base;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// spring의 설정 클래스임을 선언하는 어노테이션
// 이 클래스는 객체를 직접 사용하기 위한 클래스 x, 스프링 컨테이너에 어떤 bean을 어떻게 등록할지를 정의하는 설계도
@Configuration
public class BaseConfig {
    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }
}

// spring 컨테이너가 시작될 때, 쿼리dsl용 핵심 객체는 JPAQueryFactory 객체를 생성해서 스프링 컨테이너에 등록해준다.