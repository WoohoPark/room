package com.example.room.common.config.mapper;

import com.example.room.common.config.mapper.annotation.ToEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

//@Slf4j
//@Component
public class ModelMapperHandler{
//        implements HandlerMethodArgumentResolver {
//
////    private static final ModelMapper modelMapper = new ModelMapper();
////
//     @Override
//    public boolean supportsParameter(MethodParameter parameter) {
//        // Custom 어노테이션이 파라미터에 사용되었는지 확인합니다.
//         log.info("PLEase");
//        return parameter.hasParameterAnnotation(ToEntity.class);
//    }
//
//    @Override
//    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
//                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//        // Custom 어노테이션의 값을 파라미터로 반환합니다.
//
//        log.info("PLEase##########");
//        ToEntity entityClassName = parameter.getParameterAnnotation(ToEntity.class);
//
//        if(entityClassName != null ){
//            return getEntity(parameter.getParameterType(),entityClassName.value());
//        }
//
//        return parameter;
//    }
//
//    private Object getEntity(Class<?> dtoClass, Class<?> entityClass) {
////        return modelMapper.map(dtoClass , entityClass);
//        return null;
//    }

}