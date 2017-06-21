/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.skyguide.xmlindexer.query;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

/**
 *
 * @author cyann
 */
public class QueryAddressBuilder {
    
    private final Queue<AbstractQueryNode> queue;
    
    private QueryAddressBuilder() {
        queue = new LinkedList<>();
    }
    
    public static QueryAddressBuilder createBuilder() {
        return new QueryAddressBuilder();
    }
    
    public QueryAddressBuilder then(String address) {
        queue.add(new QueryAddress(address));
        return this;
    }
    
    public QueryAddressBuilder thenPattern(String pattern) {
        queue.add(new QueryPattern(Pattern.compile(pattern)));
        return this;
    }
    
    public AbstractQueryNode build() {
        AbstractQueryNode root = queue.poll();
        AbstractQueryNode current = root;
        
        while (!queue.isEmpty()) {
            AbstractQueryNode next = queue.poll();
            current.setNext(next);
            current = next;            
        }
        
        return root;
    }    
    
}
