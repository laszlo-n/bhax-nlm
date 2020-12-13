package hu.unideb.prog2;

import hu.unideb.prog2.emitters.*;

import java.util.List;

import static hu.unideb.prog2.emitters.PrimitiveArrayWrapper.transformIfPrimitiveArray;

public class JSONCore implements JSONEmitter<Object> {

    private static final JSONEmitter<?> nullEmitter = new JSONNullEmitter();

    // fontos a sorrend, az Object-nek a legaljára KELL kerülnie!!
    private static final List<JSONEmitter<?>> nonNullEmitters = List.of(
            new JSONBooleanEmitter(),
            new JSONNumberEmitter(),
            new JSONStringEmitter(),
            new JSONMapEmitter(),
            new JSONCollectionEmitter(),
            new JSONArrayEmitter(),
            new JSONObjectEmitter()
    );

    public String toJson(Object obj) {
        return emit(transformIfPrimitiveArray(obj), this);
    }

    @Override
    public String emit(Object obj, JSONEmitter<Object> emitterEngine) {
        JSONEmitter<Object> selectedEmitter = (JSONEmitter<Object>) selectEmitter(obj);
        return selectedEmitter.emit(obj, this);
    }

    @Override
    public Class<Object> getSourceClass() {
        return Object.class;
    }

    private JSONEmitter<?> selectEmitter(Object obj) {
        return nonNullEmitters.stream()
                .filter(emitter -> emitter.getSourceClass().isInstance(obj))
                .findFirst()
                .orElse(nullEmitter); // a `null instanceof Object` hamist ad, így a null speciális
    }
}
