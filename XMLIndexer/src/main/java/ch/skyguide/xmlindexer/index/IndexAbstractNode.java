/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.skyguide.xmlindexer.index;

import ch.skyguide.xmlindexer.query.AbstractQueryNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author cyann
 */
public abstract class IndexAbstractNode {

    private IndexAbstractNode parent;
    private final String address;

    IndexAbstractNode(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public IndexAbstractNode getParent() {
        return parent;
    }

    public void setParent(IndexAbstractNode parent) {
        this.parent = parent;
    }

    public boolean hasParent() {
        return parent != null;
    }

    public List<IndexAbstractNode> preOrderDepthFirstSearch() {
        List<IndexAbstractNode> list = new LinkedList<>();
        preOrderDepthFirstSearch(list);
        return list;
    }

    public String getPath() {
        String path = null;
        if (hasParent()) {
            path = parent.getPath();
        }

        if (path == null) {
            path = address;
        } else {
            path += '.' + address;
        }

        return path;
    }

    public abstract void preOrderDepthFirstSearch(List<IndexAbstractNode> list);

    public List<IndexAbstractNode> search(AbstractQueryNode query) {
        List<IndexAbstractNode> result = new LinkedList<>();
        final Stack<SearchItem> stack = new Stack<>();

        if (query.match(address)) {
            stack.push(new SearchItem(query, this));
        }

        while (!stack.isEmpty()) {
            SearchItem item = stack.pop();

            if (item.getQuery().hasNext()) {
                item.getNode().search(item.getQuery().getNext(), stack);
            } else {
                result.add(item.getNode());
            }
        }

        return result;
    }

    protected abstract void search(AbstractQueryNode query, Stack<SearchItem> stack);

    @Override
    public abstract String toString();

}
