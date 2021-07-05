package com.github.ivbaranov.mli.example;

import com.github.ivbaranov.mli.MaterialLetterIcon;
import ohos.agp.components.*;
import ohos.agp.utils.Color;
import ohos.app.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * ListAdapter.
 */
public class ListAdapter extends BaseItemProvider {

    private static final int CONTACTS = 1;
    private static final int COUNTRIES = 0;

    private int mType;
    private Context context;
    private List<Item> itemList;
    private ItemClickListener clickListener;

    private Color colors[] = {Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.YELLOW};

    /**
     * PeopleAdapter.
     *
     * @param context
     * @param type of list (CONTACTS, COUNTRIES)
     */
    public ListAdapter(Context context, int type) {
        this.context = context;
        this.itemList = new ArrayList<>();
        this.mType = type;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int index) {
        return itemList.get(index);
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
        } else {
            viewHolder = (ViewHolder) component.getTag();
        }


        switch (mType) {
            case COUNTRIES:
                viewHolder.placeIcon.setLettersNumber(3);
                break;
            case CONTACTS:
                viewHolder.placeIcon.setLettersNumber(1);
                break;
            default:
                viewHolder.placeIcon.setLettersNumber(1);
        }
        viewHolder.placeIcon.setShapeColor(colors[index % 5]);
        viewHolder.placeName.setText(itemList.get(index).getName());
        viewHolder.placeIcon.setLetter(itemList.get(index).getName());
        return component;
    }



    /**
     * PersonClickListener.
     *
     * @since 2020-08-25
     */
    public interface ItemClickListener {
        /**
         * onPersonClick.
         *
         * @param position position
         */
        void onItemClick(int position);
    }

    /**
     * setItem.
     *
     * @param itemList itemList
     */
    public void setItem(List<Item> itemList) {
        this.itemList = itemList;
        notifyDataChanged();
    }

    /**
     * gets person.
     *
     * @param position position
     * @return person
     */
    public Item getPerson(int position) {
        return itemList.get(position);
    }

    /**
     * ViewHolder.
     */
    public static class ViewHolder {
        Text placeName;
        MaterialLetterIcon placeIcon;

        public ViewHolder(Component component) {
            placeName = (Text) component.findComponentById(ResourceTable.Id_text);
            placeIcon = (MaterialLetterIcon) component.findComponentById(ResourceTable.Id_icon);
        }
    }
}


