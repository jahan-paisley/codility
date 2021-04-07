package digital.paisley.test.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/determine-color-of-a-chessboard-square/
 */
public class AreSentencesSimilar {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        var sen1 = new ArrayList<>(Arrays.asList(sentence1.split(" ")));
        var sen2 = new ArrayList<>(Arrays.asList(sentence2.split(" ")));
        return sen1.size() > sen2.size() ? isSimilar(sentence1, sen1, sen2) : isSimilar(sentence2, sen2, sen1);
    }

    private boolean isSimilar(String longSenStr, List<String> longWordList, List<String> shortWordList) {
        for (String s : shortWordList) {
            var found = longWordList.contains(s);
            if (!found)
                return false;
            else
                longWordList.remove(s);
        }
        String remainedStr = String.join(" ", longWordList);
        return longSenStr.contains(remainedStr);
    }

    @Test
    void test() {
        Assertions.assertTrue(true);
        boolean b;

        b = areSentencesSimilar("My name is Haley", "My Haley");
        Assertions.assertTrue(b);

        b = areSentencesSimilar("Eating right now", "Eating");
        Assertions.assertTrue(b);

        b = areSentencesSimilar("of", "My Haley of true");
        Assertions.assertFalse(b);

        b = areSentencesSimilar("pp ZM ZJ lE B", "ZM");
        Assertions.assertFalse(b);

        b = areSentencesSimilar("qbaVXO Msgr aEWD v ekcb", "Msgr aEWD ekcb");
        Assertions.assertFalse(b);

        b = areSentencesSimilar("of", "A lot of words");
        Assertions.assertFalse(b);

        b = areSentencesSimilar("Luky", "Lucccky");
        Assertions.assertFalse(b);

        b = areSentencesSimilar("Game is ON", "Game are ON");
        Assertions.assertFalse(b);
    }
}
