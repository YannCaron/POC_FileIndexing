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
import java.util.regex.Pattern;

/**
 *
 * @author cyann
 */
public class QueryPattern extends AbstractQueryNode {

    private final Pattern pattern;

    public QueryPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getAddressString() {
        return pattern.pattern();
    }

    @Override
    public boolean match(String address) {
        return pattern.matcher(address).matches();
    }

    @Override
    public void find(Map<String, IndexAbstractNode> children, Stack<SearchItem> stack) {
        children.values().stream().filter((node) -> (match(node.getAddress()))).forEach((node) -> {
            stack.push(new SearchItem(this, node));
        });

    }

}
