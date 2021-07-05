package com.github.ivbaranov.mli.example.slice;

import com.github.ivbaranov.mli.example.Item;
import com.github.ivbaranov.mli.example.ListAdapter;
import com.github.ivbaranov.mli.example.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.ListContainer;
import java.util.ArrayList;
import java.util.List;

/**
 * AbilitySlice for Countries.
 */
public class CountryAbilitySlice extends AbilitySlice {

    private static final int COUNTRIES = 0;
    private static final String[] countries = {
            "Albania", "Australia", "Belgium", "Canada", "China", "Dominica", "Egypt", "Estonia",
            "Finland", "France", "Germany", "Honduras", "Italy", "Japan", "Madagascar", "Netherlands",
            "Norway", "Panama", "Portugal", "Romania", "Russia", "Slovakia", "Vatican", "Zimbabwe"
    };

    private List<Item> itemList;
    private ListAdapter listAdapter;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_list_container);

        initView();
    }

    private void initView() {
        itemList = new ArrayList<>();
        for (String personName : countries) {
            Item item = new Item();
            item.setName(personName);
            itemList.add(item);
        }

        listAdapter = new ListAdapter(this, COUNTRIES);
        listAdapter.setItem(itemList);
        ListContainer listContainer = (ListContainer) findComponentById(ResourceTable.Id_recyclerview);
        listContainer.setItemProvider(listAdapter);
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
