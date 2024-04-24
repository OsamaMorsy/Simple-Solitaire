/*
 * Copyright (C) 2016  Tobias Bielefeld
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * If you want to contact me, send me an e-mail at tobias.bielefeld@gmail.com
 */

package de.tobiasbielefeld.solitaire.helper;

import de.tobiasbielefeld.solitaire.*;

/*
 *  I put the drawable arrays in a extra file so the Card.java remains more clearly.
 */

public class CardDrawables {
    // Keep abstract drawables as is
    public static final int[] sDrawablesAbstract = {
        R.drawable.abstract_clubs_1, R.drawable.abstract_clubs_2, R.drawable.abstract_clubs_3, R.drawable.abstract_clubs_4, R.drawable.abstract_clubs_5, R.drawable.abstract_clubs_6,
        R.drawable.abstract_clubs_7, R.drawable.abstract_clubs_8, R.drawable.abstract_clubs_9, R.drawable.abstract_clubs_10, R.drawable.abstract_clubs_11, R.drawable.abstract_clubs_12, R.drawable.abstract_clubs_13,

        R.drawable.abstract_hearts_1, R.drawable.abstract_hearts_2, R.drawable.abstract_hearts_3, R.drawable.abstract_hearts_4, R.drawable.abstract_hearts_5, R.drawable.abstract_hearts_6,
        R.drawable.abstract_hearts_7, R.drawable.abstract_hearts_8, R.drawable.abstract_hearts_9, R.drawable.abstract_hearts_10, R.drawable.abstract_hearts_11, R.drawable.abstract_hearts_12, R.drawable.abstract_hearts_13,

        R.drawable.abstract_spades_1, R.drawable.abstract_spades_2, R.drawable.abstract_spades_3, R.drawable.abstract_spades_4, R.drawable.abstract_spades_5, R.drawable.abstract_spades_6,
        R.drawable.abstract_spades_7, R.drawable.abstract_spades_8, R.drawable.abstract_spades_9, R.drawable.abstract_spades_10, R.drawable.abstract_spades_11, R.drawable.abstract_spades_12, R.drawable.abstract_spades_13,

        R.drawable.abstract_diamonds_1, R.drawable.abstract_diamonds_2, R.drawable.abstract_diamonds_3, R.drawable.abstract_diamonds_4, R.drawable.abstract_diamonds_5, R.drawable.abstract_diamonds_6,
        R.drawable.abstract_diamonds_7, R.drawable.abstract_diamonds_8, R.drawable.abstract_diamonds_9, R.drawable.abstract_diamonds_10, R.drawable.abstract_diamonds_11, R.drawable.abstract_diamonds_12, R.drawable.abstract_diamonds_13
    };

    // Refactored other drawable arrays
    public static final int[] sDrawablesClassic = createDrawableArray("classic");
    public static final int[] sDrawablesSimple = createDrawableArray("simple");
    public static final int[] sDrawablesModern = createDrawableArray("modern");
    public static final int[] sDrawablesDark = createDrawableArray("dark");
    public static final int[] sDrawablesBasic = createDrawableArray("basic");

    private static int[] createDrawableArray(String theme) {
        int[] drawables = new int[52];
        String[] suits = {"clubs", "hearts", "spades", "diamonds"};
        int index = 0;
        for (String suit : suits) {
            for (int i = 1; i <= 13; i++) {
                String drawableName = theme + "_" + suit + "_" + i;
                int drawableId = getResourceId(drawableName, "drawable", "your.package.name");
                drawables[index++] = drawableId;
            }
        }
        return drawables;
    }

    // Helper method to get the resource ID from a drawable name
    private static int getResourceId(String resourceName, String className, String packageName) {
        try {
            return Class.forName(packageName + ".R$" + className)
                    .getField(resourceName)
                    .getInt(null);
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Handle error case appropriately
        }
    }
}
