/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.skyguide.xmlindexer.index;

import ch.skyguide.xmlindexer.query.AbstractQueryNode;
import java.util.Stack;

/**
 *
 * @author cyann
 */
public class IndexStringEntry extends IndexEntry<String> {
    
    public IndexStringEntry(String address, String value) {
        super(address, value);
    }

    @Override
    protected void search(AbstractQueryNode query, Stack<SearchItem> stack) {
        
    }
    
}
