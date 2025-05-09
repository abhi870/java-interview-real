package com.real.interview.converter;

public interface Converter<S, C> {
    C convert(S source);
}
