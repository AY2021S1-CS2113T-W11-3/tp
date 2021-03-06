package sort;

import cheatsheet.CheatSheet;

import java.util.Comparator;

public class SortByNameRev implements Comparator<CheatSheet> {
    public int compare(CheatSheet a, CheatSheet b) {
        Boolean isAFavourited = a.getIsFavourite();
        Boolean isBFavourited = b.getIsFavourite();
        int favComparator = isBFavourited.compareTo(isAFavourited);
        if (favComparator != 0) {
            return favComparator;
        }
        return b.getName().compareTo(a.getName());
    }
}
