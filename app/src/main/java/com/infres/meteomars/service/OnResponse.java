package com.infres.meteomars.service;

public interface OnResponse<T> {

    void execute(T t);
}
