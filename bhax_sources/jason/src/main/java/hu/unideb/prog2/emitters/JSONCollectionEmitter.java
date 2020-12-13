package hu.unideb.prog2.emitters;

import java.util.Collection;
import java.util.stream.Collectors;

public class JSONCollectionEmitter implements JSONEmitter<Collection> {
    @Override
    public String emit(Collection obj, JSONEmitter<Object> emitterEngine) {
        return (String) obj.stream()
                .map(o -> emitterEngine.emit(o, emitterEngine))
                .collect(Collectors.joining(",", "[", "]"));
    }

    @Override
    public Class<Collection> getSourceClass() {
        return Collection.class;
    }
}
