package org.library.interfaces;

public interface Borrowable {

    void borrow();

    void returnItem();

    boolean isAvailable();
}