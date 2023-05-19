package com.the_mgi.wildapricot_wrapper.base.model;

public record Pair<A, B>(A first, B second) {
    public static <A, B> Pair<A, B> of(A obj0, B obj1) {
        return new Pair<>(obj0, obj1);
    }
}
