package pattern2_structural.struct4_adapter.code.example1_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Внешний API от которого мы не можем налседоваться и не можем
 * менять его реализацию.
 */
public final class SorterExternalProduct {
    /**
     * Сортировка Листа
     */
    List<Integer> sort(List<Integer> numberList) {
        List<Integer> resList = new ArrayList<>(numberList.size());
        resList.addAll(numberList);
        Collections.sort(resList);
        return resList;
    }
}
