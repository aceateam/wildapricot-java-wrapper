package com.the_mgi.wildapricot_wrapper.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldValue {
    /**
     * @return identifier key for the object
     */
    String key();

    /**
     * @return nested key for object in case if you want to plain out the object
     */
    String nestedValueKey() default "";
}
