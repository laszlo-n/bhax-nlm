package hu.unideb.prog2.emitters;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JSONArrayEmitter implements JSONEmitter<Object[]> {
    @Override
    public String emit(Object[] obj, JSONEmitter<Object> emitterEngine) {
        return Arrays.stream(obj)
                .map(o -> emitterEngine.emit(o, emitterEngine))
                .collect(Collectors.joining(",", "[", "]"));
    }

    @Override
    public Class<Object[]> getSourceClass() {
        return Object[].class;
    }
}
