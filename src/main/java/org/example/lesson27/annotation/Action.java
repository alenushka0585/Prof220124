package org.example.lesson27.annotation;

@FunctionalInterface // аннтотация, которая служит указанием,
// что в интерфейсе только один абстрактный метеод
//позволяет соблюсти контракт
public interface Action {
    void action();
}
