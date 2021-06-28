package com.github.ivbaranov.mli.example;

import com.github.ivbaranov.mli.MaterialLetterIcon;
import ohos.agp.components.*;
import ohos.agp.utils.Color;
import ohos.app.Context;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends BaseItemProvider {
    private static final int PERSON_ID = 99;

    private static final int TEXT_SIZE = 40;

    private Context context;

    private PersonClickListener clickListener;

    private TextField mName;
    private MaterialLetterIcon mIcon;

    private List<Person> personList;
    private Color colors[] = {Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.YELLOW};

    static final HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00201, "MY_TAG_PA");

    /**
     * PeopleAdapter
     *
     * @param context
     *
     */
    public PersonAdapter(Context context) {
        this.context = context;
        this.personList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int index) {
        return personList.get(index);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public Component getComponent(int index, Component component, ComponentContainer componentContainer) {
        ViewHolder viewHolder;
        if (component == null) {
            component = LayoutScatter.getInstance(context).parse(ResourceTable.Layout_list_item, null, false);
            viewHolder = new ViewHolder(component);
            component.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) component.getTag();
        }

        viewHolder.placeName.setText(personList.get(index).getName());
        viewHolder.placeIcon.setLetter(personList.get(index).getName());
        viewHolder.placeIcon.setLettersNumber(3);
        viewHolder.placeIcon.setShapeColor(colors[index%5]);

        return component;
    }



    /**
     * PersonClickListener
     *
     * @since 2020-08-25
     */
    public interface PersonClickListener {
        /**
         * onPersonClick
         *
         * @param position position
         */
        void onPersonClick(int position);
    }

    /**
     * setPeople
     *
     * @param people people
     */
    public void setPeople(List<Person> people) {
        personList = people;
        notifyDataChanged();
    }

    /**
     * gets person
     *
     * @param position position
     * @return person
     */
    public Person getPerson(int position) {
        return personList.get(position);
    }

    public static class ViewHolder {
        Text placeName;
        MaterialLetterIcon placeIcon;
        public ViewHolder(Component component) {
            placeName = (Text) component.findComponentById(ResourceTable.Id_text);
            placeIcon = (MaterialLetterIcon) component.findComponentById(ResourceTable.Id_icon);
        }
    }
}


