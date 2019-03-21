package cn.pppobear.datastructure.symboltable;

/**
 * <p> Description: TODO </p>
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-20
 **/
public interface UnorderedSymbolTable<Key, Value> {
    /**
     * 获取表中的键值对的数量
     * @return 表中的键值对的数量
     */
    int size();

    /**
     * 根据键获取其对应的值
     * @param key 键
     * @return 传入的键对应的值
     */
    Value get(Key key);


    /**
     * 向表中添加键值对
     * @param key 键
     * @param value 键对应的值
     */
    void put(Key key, Value value);

    /**
     * 根据键删去表中其对应的键值对
     * @param key 键
     */
    void delete(Key key);
}
