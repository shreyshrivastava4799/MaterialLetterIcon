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
 * AbilitySlice for Contacts.
 */
public class ContactAbilitySlice extends AbilitySlice {

    private static final int CONTACTS = 1;
    private static final String[] contacts = {
            "Alane Avey", "Belen Brewster", "Brandon Brochu", "Carli Carrol", "Della Delrio",
            "Esther Echavarria", "Etha Edinger", "Felipe Flecha", "Ilse Island", "Kecia Keltz",
            "Lourie Lucas", "Lucille Leachman", "Mandi Mcqueeney", "Murray Matchett", "Nadia Nero",
            "Nannie Nipp", "Ozella Otis", "Pauletta Poehler", "Roderick Rippy", "Sherril Sager",
            "Taneka Tenorio", "Treena Trentham", "Ulrike Uhlman", "Virgina Viau", " Willis Wysocki "
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
        for (String personName : contacts) {
            Item item = new Item();
            item.setName(personName);
            itemList.add(item);
        }
        listAdapter = new ListAdapter(this, CONTACTS);
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
