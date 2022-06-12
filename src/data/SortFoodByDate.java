/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Comparator;

/**
 *
 * @author DuyLVL
 */
public class SortFoodByDate implements Comparator<Food> {

    @Override
    public int compare(Food food1, Food food2) {
        if (food1.getLongDate() < food2.getLongDate()) {
            return 1;
        } else {
            if (food1.getLongDate() == food2.getLongDate()) {
                return 0;
            } else {
                return -1;
            }
        }
    }

}
