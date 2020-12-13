package hu.unideb.prog2.emitters;

import java.util.Arrays;
import java.util.stream.Collectors;

import static hu.unideb.prog2.emitters.PrimitiveArrayWrapper.transformIfPrimitiveArray;

public class JSONObjectEmitter implements JSONEmitter<Object> {
    @Override
    public String emit(Object obj, JSONEmitter<Object> emitterEngine) {
        return Arrays.stream(obj.getClass().getDeclaredFields())
                .map(field -> {
                    try {
                        String fieldName = field.getName();
                        field.trySetAccessible();
                        Object fieldContent = transformIfPrimitiveArray(field.get(obj));
                        String fieldValue = emitterEngine.emit(fieldContent, emitterEngine);
                        return String.format("\"%s\":%s", fieldName, fieldValue);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return "";
                })
                .filter(out -> !out.equals("")) // elkerüli a delimiter duplázást
                .collect(Collectors.joining(",", "{", "}"));
    }

    @Override
    public Class<Object> getSourceClass() {
        return Object.class;
    }
}
