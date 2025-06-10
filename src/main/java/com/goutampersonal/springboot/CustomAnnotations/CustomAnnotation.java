package com.goutampersonal.springboot.CustomAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface CustomAnnotation {

    int intKey() default 0;
    String stringJKey() default "defaultString";
    Class<?> classTypeKey() default String.class;
    String [] stringArrayKey() default {"default1","default2"};
    int [] intArrayKey() default{1,2};

}
