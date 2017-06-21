/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.skyguide.xmlindexer.query;

import ch.skyguide.xmlindexer.index.IndexAbstractNode;
import ch.skyguide.xmlindexer.index.SearchItem;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author cyann
 */
public abstract class AbstractQueryNode {
    
    private AbstractQueryNode next;

    AbstractQueryNode() {
    }
    
    public AbstractQueryNode getNext() {
        return next;
    }
    
    public boolean hasNext() {
        return next != null;
    }
    
    public AbstractQueryNode setNext(AbstractQueryNode next) {
        this.next = next;
        return this;
    }
    
    public abstract boolean match(String address);
    
    public abstract void find(Map<String, IndexAbstractNode> children, Stack<SearchItem> stack);

    @Override
    public String toString() {
        return "QueryNode[" + buildPath() + ']';
    }
    
    String buildPath() {
        String address = getAddressString();
        if (hasNext()) address += '.' + getNext().buildPath();
        return address;
    }
    
    public abstract String getAddressString();
    
}
