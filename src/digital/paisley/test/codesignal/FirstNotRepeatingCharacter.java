package digital.paisley.test.codeSignal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class FirstNotRepeatingCharacter {
    public char firstNotRepeatingCharacter(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int inc = map.get(s.charAt(i)) + 1;
                map.put(s.charAt(i), inc);
            } else
                map.put(s.charAt(i), 1);
        }
        Optional<Map.Entry<Character, Integer>> min = map.entrySet().stream().filter(kv -> kv.getValue() == 1).findFirst();
        return min.isPresent() ? min.get().getKey() : '_';
    }

    @Test
    public void test_solution() {
        Assertions.assertEquals('c', firstNotRepeatingCharacter("abacabad"));
        Assertions.assertEquals('_', firstNotRepeatingCharacter("abacabaabacaba"));
        Assertions.assertEquals('g', firstNotRepeatingCharacter("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof"));
    }
}
