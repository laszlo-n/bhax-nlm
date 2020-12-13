package hu.unideb.prog2.emitters;

public class JSONNullEmitter implements JSONEmitter<Object> {
    @Override
    public String emit(Object obj, JSONEmitter<Object> emitterEngine) {
        return "null";
    }

    @Override
    public Class<Object> getSourceClass() {
        return Object.class;
    }
}
