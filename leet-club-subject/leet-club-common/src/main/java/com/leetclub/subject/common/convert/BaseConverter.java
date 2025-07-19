package com.leetclub.subject.common.convert;

import java.util.List;

/**
 * @author sinker
 * @date 2025/7/18 11:19
 */
public interface BaseConverter<S, T>{
    T convert(S source);
    S convertBack(T source);

    List<T> convert(List<S> source);
    List<S> convertBack(List<T> source);
}
