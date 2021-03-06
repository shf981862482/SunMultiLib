package com.walking_men.sun.sunmultilibrary.bindingcollectionadapter;

/**
 * Unify {@link ItemView} and {@link ItemViewSelector} to simplify BindingAdapters.
 */
public class ItemViewArg<T> {
    public static <T> ItemViewArg<T> of(ItemView itemView) {
        return new ItemViewArg<>(itemView);
    }

    public static <T> ItemViewArg<T> of(ItemViewSelector<T> selector) {
        return new ItemViewArg<>(selector);
    }

    private final ItemView itemView;
    private final ItemViewSelector<T> selector;

    private ItemViewArg(ItemView itemView) {
        this.itemView = itemView;
        this.selector = BaseItemViewSelector.empty();
    }

    private ItemViewArg(ItemViewSelector<T> selector) {
        this.itemView = new ItemView();
        this.selector = selector;
    }

    public void select(int position, T item) {
        selector.select(itemView, position, item);
    }

    public int bindingVariable() {
        return itemView.bindingVariable();
    }

    public int layoutRes() {
        if(null!=itemView){
            return itemView.layoutRes();
        }
        return itemView.BINDING_VARIABLE_NONE;
    }

    public int viewTypeCount() {
        return selector.viewTypeCount();
    }
}
