package com.almj.erqallogin.app;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

/**
 * ErqalLogin-MD -- Created by mac on 16/5/21.
 */
public final class FontsOverride {
  public static void  setDefaultFont(Context context, String staticTypefaceFieldName, String fontAssetName){
      final Typeface regular = Typeface.createFromAsset(context.getAssets(),
              fontAssetName);
      replaceFont(staticTypefaceFieldName, regular);
    }
    protected  static void replaceFont(String staticTypefaceFieldName,
                                 final Typeface newTypeface){
        try {
            final Field staticField = Typeface.class
                    .getDeclaredField(staticTypefaceFieldName);
            staticField.setAccessible(true);
            staticField.set(null, newTypeface);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
