package org.library.catalog;

import org.library.model.LibraryItem;

import java.util.ArrayList;
import java.util.List;
 
public class LibraryCatalog<T extends LibraryItem> {

    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}