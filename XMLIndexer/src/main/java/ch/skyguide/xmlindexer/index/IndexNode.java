/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.skyguide.xmlindexer.index;

import ch.skyguide.xmlindexer.query.AbstractQueryNode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author cyann
 */
public class IndexNode extends IndexAbstractNode {

    private final Map<String, IndexAbstractNode> children;

    public IndexNode(String address) {
        super(address);
        this.children = new HashMap<>();
    }

    public void appendChild(IndexAbstractNode node) {
        children.put(node.getAddress(), node);
        node.setParent(this);
    }

    @Override
    public void preOrderDepthFirstSearch(List<IndexAbstractNode> list) {
        list.add(this);
        children.values().stream().forEach((node) -> {
            node.preOrderDepthFirstSearch(list);
        });
    }

    @Override
    protected void search(AbstractQueryNode query, Stack<SearchItem> stack) {
        query.find(children, stack);
    }

    @Override
    public String toString() {
        return "Node[" + getPath() + ']';
    }

}
