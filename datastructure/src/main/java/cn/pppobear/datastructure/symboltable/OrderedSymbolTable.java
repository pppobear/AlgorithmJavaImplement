package cn.pppobear.datastructure.symboltable;

import java.util.List;

/**
 * <p> Description: TODO </p>
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-20
 **/
public interface OrderedSymbolTable<Key extends Comparable<Key>, Value> extends UnorderedSymbolTable {
    Key min();

    Key max();

    int rank(Key key);

    List<Key> keys(Key l, Key r);
}
