package cn.pppobear.datastructure.stack;

/**
 * 栈数据结构的接口
 *
 * @author pppobear
 * @version 1.0
 * @date 2019-03-20
 **/
public interface IStack<Item> extends Iterable<Item> {

    boolean isEmpty();

    void push(Item item);

    Item pop();

    Item top();

    int size();

}
