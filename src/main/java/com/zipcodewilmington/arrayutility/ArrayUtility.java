package com.zipcodewilmington.arrayutility;

import org.junit.runners.Suite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {
    T[] inputArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer results = 0;
        Integer numOfOccurences = 0;
        for (T thing : inputArray) {
            if (thing == valueToEvaluate) {
                numOfOccurences++;
            }
        }
        return numOfOccurences;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T results = null;
        Integer mostCommon = 0;
        ArrayList<T> newInputArray = new ArrayList<>(Arrays.asList(inputArray));
        newInputArray.addAll(Arrays.asList(arrayToMerge));
        for (int i = 0; i < newInputArray.size() - 1; i++) {
            mostCommon = Collections.frequency(newInputArray, newInputArray.get(i));
            if (newInputArray.get(i + 1) == null) {
                results = newInputArray.get(i);
            } else if (Collections.frequency(newInputArray, newInputArray.get(i)) <
                    Collections.frequency(newInputArray, newInputArray.get(i + 1))) {
                mostCommon = Collections.frequency(newInputArray, newInputArray.get(i + 1));
                results = newInputArray.get(i + 1);
            }
        }

        return results;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        ArrayList<T> newInputArray = new ArrayList<>(Arrays.asList(inputArray));
        newInputArray.addAll(Arrays.asList(arrayToMerge));
        return Collections.frequency(newInputArray, valueToEvaluate);

    }

    public T[] removeValue(T valueToRemove) {
        List<T> holdingChamber = new ArrayList<>();
//        T[] newArray = new T[inputArray.length - getNumberOfOccurrences(valueToRemove)];
//        ArrayList genericArray = new ArrayList(inputArray.length - getNumberOfOccurrences(valueToRemove));
        for (int i = 0; i < inputArray.length; i++) {
            if (!inputArray[i].equals(valueToRemove)) {
                holdingChamber.add(valueToRemove);
            }
        }
        T[] newArray = Arrays.copyOf(inputArray, holdingChamber.size());
        for (int i = 0, j = 0; i < newArray.length; i++, j++) {
            if (newArray[i].equals(valueToRemove)) {
                newArray[i] = inputArray[j + 1];
                j++;
            } else if (inputArray[j].equals(valueToRemove)) {
                newArray[i] = inputArray[j + 1];
            } else {
                newArray[i] = inputArray[j];
            }


//        T[] arr2 = ;
//        int j = 0;
//        for (int i = 0; i < inputArray.length; i++){
//            if(inputArray[i] == valueToRemove){
//                arr2[i] = inputArray[i + 1];
//                j = i;
//            } if (j < i){
//                int k = i - j;
//                arr2[i-k] = inputArray[i];
//            }
//        }
//        return arr2;


//        T[] objArray = new T[holdingChamber.size()];
            //for each thing in the array, we could move that thing to an external
            //arrayList. then, the element that matches value to remove has to stay
            //in the old array. turn the arraylist back into an array and we are all
            //set...I think!
//        return (T[]) holdingChamber.toArray();
        }return newArray;
    }
}
