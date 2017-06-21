/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.skyguide.xmlindexer.index;

import ch.skyguide.xmlindexer.query.AbstractQueryNode;

/**
 *
 * @author cyann
 */
public class SearchItem {
    
    private final AbstractQueryNode query;
    private final IndexAbstractNode node;

    public AbstractQueryNode getQuery() {
        return query;
    }

    public IndexAbstractNode getNode() {
        return node;
    }

    public SearchItem(AbstractQueryNode query, IndexAbstractNode node) {
        this.query = query;
        this.node = node;
    }

    @Override
    public String toString() {
        return "SearchItem{" + "query=" + query + ", node=" + node + '}';
    }
    
}
