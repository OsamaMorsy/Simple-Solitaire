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

    public static final int[] sDrawablesClassic = createDrawableArray("classic");
    public static final int[] sDrawablesAbstract = createDrawableArray("abstract");
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
