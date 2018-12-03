package org.rhino.rsps.bootstrap.autoconfigure;

import javax.annotation.meta.TypeQualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ApplicationContextAware.Excluded
public interface ApplicationContextAware {

    /**
     *
     * @param object
     */
    void setApplicationContext(ApplicationContext object);

    /**
     * Indicates the class should be excluded from context aware
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface Excluded {}

}
