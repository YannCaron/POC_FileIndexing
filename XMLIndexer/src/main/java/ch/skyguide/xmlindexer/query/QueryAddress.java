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
public class QueryAddress extends AbstractQueryNode {
    
    private final String address;
    
    public QueryAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddressString() {
        return address;
    }
    
    @Override
    public boolean match(String address) {
        return this.address.equals(address);
    }
    
    @Override
    public void find(Map<String, IndexAbstractNode> children, Stack<SearchItem> stack) {
        if (children.containsKey(address)) {
            stack.push(new SearchItem(this, children.get(address)));
        }
    }
    
}
