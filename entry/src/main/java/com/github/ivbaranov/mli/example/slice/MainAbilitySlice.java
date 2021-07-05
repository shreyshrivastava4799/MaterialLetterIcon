package com.github.ivbaranov.mli.example.slice;

import com.github.ivbaranov.mli.example.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.animation.Animator;
import ohos.agp.animation.AnimatorProperty;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Image;


/**
 * MainAbilitySlice.
 */
public class MainAbilitySlice extends AbilitySlice {
    Image image;
    Button buttonContacts;
    Button buttonCountries;
    AnimatorProperty animatorProperty;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        image = (Image) findComponentById(ResourceTable.Id_image_main);
        animatorProperty = image.createAnimatorProperty();
        animatorProperty.setDuration(5000).alpha(0).rotate(360).setCurveType(Animator.CurveType.ACCELERATE);
        image.setBindStateChangedListener(new Component.BindStateChangedListener() {
            @Override
            public void onComponentBoundToWindow(Component component) {
                animatorProperty.start();
            }

            @Override
            public void onComponentUnboundFromWindow(Component component) {
                animatorProperty.stop();
            }
        });

        buttonContacts = (Button) findComponentById(ResourceTable.Id_button_main_contacts);
        buttonContacts.setClickedListener(component -> present(new ContactAbilitySlice(), new Intent()));

        buttonCountries = (Button) findComponentById(ResourceTable.Id_button_main_countries);
        buttonCountries.setClickedListener(component -> present(new CountryAbilitySlice(), new Intent()));
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
