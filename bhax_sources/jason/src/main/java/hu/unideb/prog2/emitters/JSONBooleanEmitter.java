package hu.unideb.prog2.emitters;

public class JSONBooleanEmitter implements JSONEmitter<Boolean> {
    @Override
    public String emit(Boolean obj, JSONEmitter<Object> emitterEngine) {
        return obj ? "true" : "false";
    }

    @Override
    public Class<Boolean> getSourceClass() {
        return Boolean.class;
    }
}
