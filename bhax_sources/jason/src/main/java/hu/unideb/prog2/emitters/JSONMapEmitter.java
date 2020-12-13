package hu.unideb.prog2.emitters;

import java.util.Map;
import java.util.stream.Collectors;

public class JSONMapEmitter implements JSONEmitter<Map> {
    @Override
    public String emit(Map obj, JSONEmitter<Object> emitterEngine) {
        return (String) obj.entrySet().stream()
                .map(entry -> generateKVRepresentation((Map.Entry) entry, emitterEngine))
                .collect(Collectors.joining(",", "{", "}"));
    }

    private String generateKVRepresentation(Map.Entry entry, JSONEmitter<Object> emitterEngine) {
        return String.format("\"%s\":%s",
                (Object) entry.getKey(), // az (Object) cast a null értékek miatt igenis fontos!
                emitterEngine.emit(entry.getValue(), emitterEngine));
    }

    @Override
    public Class<Map> getSourceClass() {
        return Map.class;
    }
}
