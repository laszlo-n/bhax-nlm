package hu.unideb.prog2.emitters;

public class JSONStringEmitter implements JSONEmitter<String> {
    @Override
    public String emit(String obj, JSONEmitter<Object> emitterEngine) {
        return '"' + obj + '"';
    }

    @Override
    public Class<String> getSourceClass() {
        return String.class;
    }
}
