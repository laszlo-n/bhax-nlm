package hu.unideb.prog2.emitters;

public interface JSONEmitter<T> {
    String emit(T obj, JSONEmitter<Object> emitterEngine);

    Class<T> getSourceClass();
}
