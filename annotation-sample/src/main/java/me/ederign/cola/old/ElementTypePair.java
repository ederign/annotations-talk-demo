package me.ederign.cola.old;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;

class ElementTypePair {

    private final TypeElement element;
    private final DeclaredType type;

    public ElementTypePair(TypeElement element,
                           DeclaredType type) {
        this.element = element;
        this.type = type;
    }

    TypeElement getElement() {
        return element;
    }

    DeclaredType getType() {
        return type;
    }
}

