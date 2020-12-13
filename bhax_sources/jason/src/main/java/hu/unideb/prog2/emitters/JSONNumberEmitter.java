package hu.unideb.prog2.emitters;

public class JSONNumberEmitter implements JSONEmitter<Number> {
    @Override
    public String emit(Number obj, JSONEmitter<Object> emitterEngine) {
        return obj.toString();
    }

    @Override
    public Class<Number> getSourceClass() {
        return Number.class;
    }
}
