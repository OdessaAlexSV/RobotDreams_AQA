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
    private static HashMap<Character, Integer> keyValue = new HashMap<Character, Integer>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Input a string array (either EN/RU), every string must be surrounded by quote and separated by comma: ");
        String str = s.nextLine();
        String[] arrayStr = str.replaceAll("[^a-zA-ZА-ЯЁа-яё/,]", "").split(",");
        System.out.println(analyzePhrase(arrayStr));
        s.close();
    }

    private static Set<Character> analyzePhrase(String[] arrayStr) {
        int numString = 0;

        for (String element : arrayStr) {
            boolean isThereEvenNumLetter = true;

            if (element.length() % 2 == 0 && numString < 2) {
                char[] charsOfWord = element.toUpperCase().toCharArray();
                char[] sortedCharsOfWord = Arrays.copyOf(charsOfWord, charsOfWord.length);
                Arrays.sort(sortedCharsOfWord);

                for (int i = 0; i < sortedCharsOfWord.length; i = i + 2) {
                    if (sortedCharsOfWord[i] != sortedCharsOfWord[i + 1]) {
                        isThereEvenNumLetter = false;
                        break;
                    }
                }

                if (isThereEvenNumLetter) {
                    finalStrArray.add(element);
                    numString++;
                }
            }
        }

        for (String element : finalStrArray) {
            char[] chars = element.toUpperCase().toCharArray();
            for (char ch : chars) {
                keyValue.put(ch, (keyValue.getOrDefault(ch, 0))+1);
            }
        }
        System.out.println(keyValue);
        return keyValue.keySet();
    }
}