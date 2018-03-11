package com.shepard.oauth.util;

import javax.validation.constraints.NotNull;
import java.util.Collection;

public interface CollectionExt {
    default <T> T single(@NotNull Collection<T> collection) throws IllegalArgumentException {
        if (collection.isEmpty()) throw new IllegalArgumentException("Collection is empty");
        if (collection.size() > 1) throw new IllegalArgumentException("Collection size is " + collection.size());
        return collection.iterator().next();
    }
}
