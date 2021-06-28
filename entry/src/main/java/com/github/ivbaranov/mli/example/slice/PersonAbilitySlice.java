package com.github.ivbaranov.mli.example.slice;

import com.github.ivbaranov.mli.MaterialLetterIcon;
import com.github.ivbaranov.mli.example.Person;
import com.github.ivbaranov.mli.example.PersonAdapter;
import com.github.ivbaranov.mli.example.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.*;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PersonAbilitySlice extends AbilitySlice {

    private static final String[] desuNoto = {
            "Alane Avey", "Belen Brewster", "Brandon Brochu", "Carli Carrol", "Della Delrio",
            "Esther Echavarria", "Etha Edinger", "Felipe Flecha", "Ilse Island", "Kecia Keltz",
            "Lourie Lucas", "Lucille Leachman", "Mandi Mcqueeney", "Murray Matchett", "Nadia Nero",
            "Nannie Nipp", "Ozella Otis", "Pauletta Poehler", "Roderick Rippy", "Sherril Sager",
            "Taneka Tenorio", "Treena Trentham", "Ulrike Uhlman", "Virgina Viau", " Willis Wysocki "
    };
    private static final String[] countries = {
            "Albania", "Australia", "Belgium", "Canada", "China", "Dominica", "Egypt", "Estonia",
            "Finland", "France", "Germany", "Honduras", "Italy", "Japan", "Madagascar", "Netherlands",
            "Norway", "Panama", "Portugal", "Romania", "Russia", "Slovakia", "Vatican", "Zimbabwe"
    };

    private static final int CONTACTS = 0;
    private static final int COUNTRIES = 1;
    private static final Random RANDOM = new Random();

    List<Person> personList;
    private PersonAdapter personAdapter;

    static final HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00201, "MY_TAG_A");

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_list_container);

        HiLog.debug(label, "Inside onStart.");
        initView();
    }

    private void initView() {
        ListContainer listContainer = (ListContainer) findComponentById(ResourceTable.Id_recyclerview);

        personList = new ArrayList<>();
        for (String personName : desuNoto) {
            Person person = new Person();
            person.setName(personName);
            personList.add(person);
        }

        personAdapter = new PersonAdapter(this);
        personAdapter.setPeople(personList);
        listContainer.setItemProvider(personAdapter);
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
