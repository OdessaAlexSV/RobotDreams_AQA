package asv.collections;

import java.util.*;

/**
 * из заданного списка строк необходимо найти первые две в которых каждая буква встречается четное количество раз
 * (например "мама", "папа", "ел еж желе")
 * далее необходимо найти набор не повторяющихся букв из которых состоят найденые слова
 * (для приведенного примера "мама", "папа" это будет [м а п]) а "ел еж желе" не учитывается так как в условии сказано
 * учитывать только первые 2 подходящих слова.
 * Все задание оформляется в виде функции которая принимает в качестве входного параметра массив строк и
 * возвращает набор букв в виде массива или любого типа коллекции, порядок букв при этом значения не имеет
 */

public class Main {
    private static List<String> finalStrArray = new ArrayList<String>();
    private static List<Character> finalCharArray = new ArrayList<Character>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Input a string array (either EN/RU), every string must be surrounded by quote and separated by comma: ");
        String str = s.nextLine();
        String[] arrayStr = str.replaceAll("[^a-zA-ZА-ЯЁа-яё/,]", "").split(",");
        analyzePhrase(arrayStr);
        s.close();
    }

    private static void analyzePhrase(String[] arrayStr) {
        int numString = 0;

        for (String element : arrayStr) {
            int lastPosition;
            int countChar;
            boolean isThereEvenNumLetter = true;

            if (element.length() % 2 == 0 & numString < 2) {
                char[] chars = element.toUpperCase().toCharArray();
                Arrays.sort(chars);
                String sortedElement = String.copyValueOf(chars);

                for (int i = 0; i < sortedElement.length(); i++) {
                    lastPosition = sortedElement.lastIndexOf(chars[i]);
                    countChar = lastPosition - i + 1;
                    if ((countChar % 2) == 0) {
                        i = lastPosition;
                    } else {
                        i = sortedElement.length();
                        isThereEvenNumLetter = false;
                    }
                }
                if (isThereEvenNumLetter) {
                    finalStrArray.add(element);
                    numString++;
                }
            }
        }

        for (String element : finalStrArray) {
            char[] chars = element.toCharArray();
            for (char ch : chars) {
                if (!finalCharArray.contains(ch)){
                    finalCharArray.add(ch);
                }
            }
        }
        System.out.println(finalCharArray);
    }
}
