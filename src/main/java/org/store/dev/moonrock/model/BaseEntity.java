package org.store.dev.moonrock.model;

import java.io.Serializable;

public interface BaseEntity<T extends Serializable> {

    T geId();

    void setId(T id);
}
