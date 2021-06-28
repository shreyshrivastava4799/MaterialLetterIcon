package com.github.ivbaranov.mli.example;

import com.github.ivbaranov.mli.MaterialLetterIcon;
import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import ohos.agp.components.Attr;
import ohos.agp.components.AttrSet;
import ohos.agp.utils.Color;
import ohos.app.Context;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static java.lang.Math.abs;
import static org.junit.Assert.*;

public class MaterialLetterIconTest {
    private Context context;
    private AttrSet attrSet;
    private MaterialLetterIcon materialLetterIcon;

    @Before
    public void setUp() throws Exception {
        context = AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
        attrSet = new AttrSet() {
            @Override
            public Optional<String> getStyle() {
                return Optional.empty();
            }

            @Override
            public int getLength() {
                return 0;
            }

            @Override
            public Optional<Attr> getAttr(int i) {
                return Optional.empty();
            }

            @Override
            public Optional<Attr> getAttr(String s) {
                return Optional.empty();
            }
        };

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testMaterialLetterIcon() {
        materialLetterIcon = new MaterialLetterIcon(context);
        assertNotNull(materialLetterIcon);
    }

    @Test
    public void testMaterialLetterIconAttrSet() {
        materialLetterIcon = new MaterialLetterIcon(context, attrSet);
        assertNotNull(materialLetterIcon);
    }

    @Test
    public void testMaterialLetterIconDefStyleAttr() {
        materialLetterIcon = new MaterialLetterIcon(context, attrSet, 0);
        assertNotNull(materialLetterIcon);
    }

    @Test
    public void testMaterialLetterIconDefStyleRes() {
        materialLetterIcon = new MaterialLetterIcon(context, attrSet, 0, 0);
        assertNotNull(materialLetterIcon);
    }

    @Test
    public void testShapeColor() {
        MaterialLetterIcon.Builder builder = new MaterialLetterIcon.Builder(context);
        builder.shapeColor(Color.GREEN);

        materialLetterIcon = builder.create();
        assertEquals(Color.GREEN, materialLetterIcon.getShapeColor());
    }

    @Test
    public void testShapeType() {
        MaterialLetterIcon.Builder builder = new MaterialLetterIcon.Builder(context);
        builder.shapeType(MaterialLetterIcon.Shape.CIRCLE);

        materialLetterIcon = builder.create();
        assertEquals(MaterialLetterIcon.Shape.CIRCLE, materialLetterIcon.getShapeType());
    }

    @Test
    public void testBorder() {
        MaterialLetterIcon.Builder builder = new MaterialLetterIcon.Builder(context);
        builder.border(true);

        materialLetterIcon = builder.create();
        assertTrue(materialLetterIcon.hasBorder());
    }

    @Test
    public void testBorderColor() {
        MaterialLetterIcon.Builder builder = new MaterialLetterIcon.Builder(context);
        builder.borderColor(Color.GREEN);

        materialLetterIcon = builder.create();
        assertEquals(Color.GREEN, materialLetterIcon.getBorderColor());
    }

    @Test
    public void testBorderSize() {
        MaterialLetterIcon.Builder builder = new MaterialLetterIcon.Builder(context);
        builder.borderSize(10);

        materialLetterIcon = builder.create();
        assertEquals(10, materialLetterIcon.getBorderSize());
    }

    @Test
    public void testLetter() {
        MaterialLetterIcon.Builder builder = new MaterialLetterIcon.Builder(context);
        builder.letter("Material Letter Icon");

        materialLetterIcon = builder.create();
        assertEquals("Material Letter Icon", materialLetterIcon.getLetter());
    }

    @Test
    public void testLetterColor() {
        MaterialLetterIcon.Builder builder = new MaterialLetterIcon.Builder(context);
        builder.letterColor(Color.GREEN);

        materialLetterIcon = builder.create();
        assertEquals(Color.GREEN, materialLetterIcon.getLetterColor());
    }

    @Test
    public void testLetterSize() {
        MaterialLetterIcon.Builder builder = new MaterialLetterIcon.Builder(context);
        builder.letterSize(10);

        materialLetterIcon = builder.create();
        assertEquals(10, materialLetterIcon.getLetterSize());
    }

    @Test
    public void testLettersNumber() {
        MaterialLetterIcon.Builder builder = new MaterialLetterIcon.Builder(context);
        builder.lettersNumber(3);

        materialLetterIcon = builder.create();
        assertEquals(3, materialLetterIcon.getLetterSize());
    }

    @Test
    public void testInitials() {
        MaterialLetterIcon.Builder builder = new MaterialLetterIcon.Builder(context);
        builder.initials(true);

        materialLetterIcon = builder.create();
        assertTrue(materialLetterIcon.isInitials());
    }

    @Test
    public void testInitialsNumber() {
        MaterialLetterIcon.Builder builder = new MaterialLetterIcon.Builder(context);
        builder.initialsNumber(3);

        materialLetterIcon = builder.create();
        assertEquals(3, materialLetterIcon.getInitialsNumber());
    }

    @Test
    public void testRoundRectRx() {
        MaterialLetterIcon.Builder builder = new MaterialLetterIcon.Builder(context);
        builder.roundRectRx(10);

        materialLetterIcon = builder.create();
        assertTrue(abs(10 - materialLetterIcon.getRoundRectRx()) < 0.1);
    }

    @Test
    public void testRoundRectRy() {
        MaterialLetterIcon.Builder builder = new MaterialLetterIcon.Builder(context);
        builder.roundRectRy(10);

        materialLetterIcon = builder.create();
        assertTrue(abs(10 - materialLetterIcon.getRoundRectRy()) < 0.1);
    }
}