package Quick;

import java.util.*;

import static Console.Colors.*;
import static Quick.PrintMethods.*;

public class DebugMethods {
    private static final String indent = "               "; //15 spaces
    private static final String indent_Class = "                    "; //20 spaces

    public static Integer[] intAToIntegerA(int[] object) {
        return Arrays.stream(object).boxed().toArray(Integer[]::new);
    }

    //arraylist debugger
    public static <Type> void dL(List<Type> obj, boolean quick) {

        String rawList = "";
        for (Type x : obj) {
            if (!x.getClass().toString().equals(obj.get(0).getClass().toString())) {
                rawList = RED_UNDERLINED + "RAW" + RESET + " ";
                break;
            }
        }

        pl(PURPLE_BOLD_BRIGHT + "\n**** Debugging " + rawList  + PURPLE_BOLD_BRIGHT + "List of "+ obj.getClass().toString()
                    + " ****" + RESET);

        if (!quick)
            pl();

        String[] classTypeArray = obj.getClass().toString().split(" ")[1].split("\\.");
        int longestClassString = 0;

        for (Type o : obj) {
            int curr = o.getClass().toString().split(" ")[1].length();
            if (curr > longestClassString)
                longestClassString = curr;
        }

        String currClass = "";
        String classString = "";

        if (obj.isEmpty()) {
            pl(CYAN_BOLD_BRIGHT + "List is Empty" + RESET);
        } else if (!quick){

            for (int i = 0; i < obj.size(); i++) {
                classString = obj.get(i).getClass().toString().split(" ")[1];
                if (rawList.length() > 0)
                    currClass = YELLOW_BOLD_BRIGHT + "Class: " + WHITE_BOLD_BRIGHT + classString + "     " +
                     indent_Class.substring(0, longestClassString - classString.length()) + RESET;
                pl(BLUE_BOLD_BRIGHT + "Index: " + WHITE_BOLD_BRIGHT + i + " " + RESET +
                        indent.substring(0, 5 - String.valueOf(i).length()) + currClass + GREEN_BOLD_BRIGHT + "Value:   >>" +
                        WHITE_BOLD_BRIGHT + obj.get(i).toString() + GREEN_BOLD_BRIGHT + "<<" + RESET);
            }

        } else {
            for (int i = 0; i < obj.size(); i++) {
                classString = obj.get(i).getClass().toString().split(" ")[1];
                if (rawList.length() > 0)
                    currClass = YELLOW_BOLD_BRIGHT + classString + "  " + RESET;
                p(currClass + GREEN_BOLD_BRIGHT + ">>" + WHITE_BOLD_BRIGHT + obj.get(i).toString() + GREEN_BOLD_BRIGHT + "<<  " + RESET);
            }
        }

        pl();
        pl(PURPLE_BOLD_BRIGHT + "**** List Debugged *****\n" + RESET);

    }

    // array debugger
    public static <Type> void dA(Type[] obj, boolean printDebug, boolean quick) {

        if (printDebug)
            p(PURPLE_BOLD_BRIGHT + "\n**** Debugging Array of type " +
                    obj.getClass().getComponentType().toString().split(" ")[1] + " ****\n" + RESET);
        pl();

        if (obj.length == 0) {
            pl(CYAN_BOLD_BRIGHT + "Array is Empty" + RESET);
        } else if (!quick){
            for (int i = 0; i < obj.length; i++) {
                pl(BLUE_BOLD_BRIGHT + "Index: " + WHITE_BOLD_BRIGHT + i + RESET + " " +
                        indent.substring(0, 5 - String.valueOf(i).length()) + GREEN_BOLD_BRIGHT + "Value:   >>" +
                        WHITE_BOLD_BRIGHT + obj[i].toString() + GREEN_BOLD_BRIGHT + "<<" + RESET);
            }
        } else {
            for (int i = 0; i < obj.length; i++) {
                p(GREEN_BOLD_BRIGHT + ">>" + WHITE_BOLD_BRIGHT + obj[i].toString() + GREEN_BOLD_BRIGHT + "<<  " + RESET);
            }
            pl();
        }

        if (printDebug) {
            pl();
            pl(PURPLE_BOLD_BRIGHT + "**** Array Debugged *****\n" + RESET);
        } else {
            pl();
        }
    }
}