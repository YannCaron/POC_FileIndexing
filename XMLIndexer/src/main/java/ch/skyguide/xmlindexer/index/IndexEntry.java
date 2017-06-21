/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.skyguide.xmlindexer.index;

import java.util.List;

public abstract class IndexEntry<T> extends IndexAbstractNode {
    
    private final T value;
    
    public IndexEntry(String address, T value) {
        super(address);
        this.value = value;
    }

    @Override
    public void preOrderDepthFirstSearch(List<IndexAbstractNode> list) {
        list.add(this);
    }

    @Override
    public String toString() {
        return "Entry[" + getPath() + "=\"" + value + "\"]";
    }

}
