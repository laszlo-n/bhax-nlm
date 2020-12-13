package hu.unideb.prog2.emitters;

import java.util.ArrayList;

public final class PrimitiveArrayWrapper {
    public static Object transformIfPrimitiveArray(Object obj) {
        // primitív típusokból álló tömbök nem minősülnek Object[]-nek,
        // így hacsak nem kerülnek átalakításra, akkor primitív típusú
        // tömböket nem tudunk szerializálni.. és természetesen az átalakításra
        // nincs egyszerű mód, szóval marad ez a módszer
        if (!(obj instanceof Object[])) {
            if (obj instanceof byte[]) {
                var out = new ArrayList<Byte>();
                for (int i = 0; i < ((byte[]) obj).length; i++) {
                    out.add(((byte[]) obj)[i]);
                };
                return (Object[]) out.toArray();
            }
            else if (obj instanceof short[]) {
                var out = new ArrayList<Short>();
                for (int i = 0; i < ((short[]) obj).length; i++) {
                    out.add(((short[]) obj)[i]);
                };
                return (Object[]) out.toArray();
            }
            else if (obj instanceof int[]) {
                var out = new ArrayList<Integer>();
                for (int i = 0; i < ((int[]) obj).length; i++) {
                    out.add(((int[]) obj)[i]);
                };
                return (Object[]) out.toArray();
            }
            else if (obj instanceof long[]) {
                var out = new ArrayList<Long>();
                for (int i = 0; i < ((long[]) obj).length; i++) {
                    out.add(((long[]) obj)[i]);
                };
                return (Object[]) out.toArray();
            }
            else if (obj instanceof float[]) {
                var out = new ArrayList<Float>();
                for (int i = 0; i < ((float[]) obj).length; i++) {
                    out.add(((float[]) obj)[i]);
                };
                return (Object[]) out.toArray();
            }
            else if (obj instanceof double[]) {
                var out = new ArrayList<Double>();
                for (int i = 0; i < ((double[]) obj).length; i++) {
                    out.add(((double[]) obj)[i]);
                };
                return (Object[]) out.toArray();
            }
            else if (obj instanceof char[]) {
                var out = new ArrayList<Character>();
                for (int i = 0; i < ((char[]) obj).length; i++) {
                    out.add(((char[]) obj)[i]);
                };
                return (Object[]) out.toArray();
            }
            else if (obj instanceof boolean[]) {
                var out = new ArrayList<Boolean>();
                for (int i = 0; i < ((boolean[]) obj).length; i++) {
                    out.add(((boolean[]) obj)[i]);
                };
                return (Object[]) out.toArray();
            }
        }
        return obj;
    }
}
