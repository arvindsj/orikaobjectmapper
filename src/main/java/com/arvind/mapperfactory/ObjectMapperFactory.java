package com.arvind.mapperfactory;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

import java.util.Map;
import java.util.Optional;

/**
 * Created by Jan on 12/17/16.
 */
public class ObjectMapperFactory {
    public static <S, T> MapperFacade getMapper(final S source, final T target, final Map<String, String> fieldMap) {
        final MapperFactory factory = new DefaultMapperFactory.Builder().build();
        ClassMapBuilder builder = factory.classMap(source.getClass(), target.getClass());
        Optional.ofNullable(fieldMap).ifPresent(m -> m.forEach((k, v) -> builder.field(k, v)));
        factory.registerClassMap(builder.toClassMap());
        return factory.getMapperFacade();
    }
}
