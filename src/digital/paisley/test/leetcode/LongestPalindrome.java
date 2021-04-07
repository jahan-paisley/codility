package digital.paisley.test.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int max_i = 0, max_j = -1;
        var chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (j - i < max_j - max_i)
                    continue;
                if (isPalindrome(chars, i, j)) {
                    if (j - i > max_j - max_i) {
                        max_i = i;
                        max_j = j;
                    }
                }
            }
        }
        return s.substring(max_i, max_j + 1);
    }

    private boolean isPalindrome(char[] s, int i, int j) {
        if (j - i < 1) return true;
        if (j - i == 1) return s[i] == s[j];
        int endExclusive = j - i % 2 == 0 ? (j - i) / 2 : ((j - i) / 2) + 1;
        for (int k = 0; k < endExclusive; k++) {
            if (s[i + k] != s[j - k]) {
                return false;
            }
        }
        return true;
    }

    @Test
    void test_isPalindrome() {
        Assertions.assertTrue(isPalindrome("aba".toCharArray(), 0, 2));
        Assertions.assertFalse(isPalindrome("abab".toCharArray(), 0, 3));
        Assertions.assertTrue(isPalindrome("abab".toCharArray(), 1, 3));
        Assertions.assertTrue(isPalindrome("baab".toCharArray(), 0, 3));
        Assertions.assertFalse(isPalindrome("babb".toCharArray(), 0, 3));
        Assertions.assertTrue(isPalindrome("a".toCharArray(), 0, 0));
        Assertions.assertTrue(isPalindrome("bb".toCharArray(), 0, 1));
    }

    @Test
    void test_longestPalindrome() throws Exception {
        String actual;
        actual = longestPalindrome("babad");
        Assertions.assertTrue(actual.equals("bab") || actual.equals("aba"));

        actual = longestPalindrome("cbbd");
        Assertions.assertEquals("bb", actual);

        actual = longestPalindrome("a");
        Assertions.assertEquals("a", actual);

        actual = longestPalindrome("ac");
        Assertions.assertEquals("a", actual);

        actual = longestPalindrome("bb");
        Assertions.assertEquals("bb", actual);


        actual = run(() -> longestPalindrome("lfzwymgfcaqlozazylwpafzwgjhxbibllvdgsaiadtpryangehchkwkprhzpbszkobjcfmhffqxdcvghqftqyxorllrrheptcrhhlhrytwkytqmqlnvgoogjdlejnslpehtndmounvrtxplzyzlvcyuviknxoyhomwjzigiufhwqmjnwqpuukcxxhatxrgqiayqkkuwbxxbyejvxjpiflbeqjqemvkzcayitimalelkqmvrydiknqeghabhfuogujutrnzkmqqphbnrbnxhlgotbyghsbgmxschmbuhkobwvwajkcghrmgvvfzmxmaihcenxerznbnkotjubqxhbfqrcwsyfeowixusgfdgreywudrxjbylrnydtpfawayptifhlbmvrklplxahkxqahqalwsivszwvblpnozfmabzmouaxxbvbsibbzirgiqurhoitzlmpsovcjnkbeeydtkpelxmaulsvozwomofyvcafcenaprlnfxhvvkwpuyycqokybyqrujpdgpnpqcfrmdunejkidxpkdipigmkqwasfdewnhumokvubzqxserhpsxoskmvhsflmtvootrhpnjguqmqhpuiosqpiwmmahvuimwcquktrfnniybyhuftrfzqpmvvklgoilbwvtvaprddkwiwiezxarnxnzgqzqxhseodyyleerusznmmyxxvlmokiyhpsghcububxzrglgskrkbagamwvxxrkplpjrcsxvvvcjmjzsemvjvfmesckkrfabzfxxzmwthxldyoyhbsdsqmrugnsyracggnsextkzjqyivpiiambvsulqjefbheakvwkffcvjnuvkgusnawxdtibaycabnzeobaljpfhlhbaismpplqckycavmhttyakpngcnuawxdwwfhswyllbbhbkmuvgdu"));
        Assertions.assertEquals("lzyzl", actual);

        actual = run(() -> longestPalindrome("lfzwymgfcaqlozazylwpafzwgjhxbibllvdgsaiadtpryangehchkwkprhzpbszkobjcfmhffqxdcvghqftqyxorllrrheptcrhhlhrytwkytqmqlnvgoogjdlejnslpehtndmounvrtxplzyzlvcyuviknxoyhomwjzigiufhwqmjnwqpuukcxxhatxrgqiayqkkuwbxxbyejvxjpiflbeqjqemvkzcayitimalelkqmvrydiknqeghabhfuogujutrnzkmqqphbnrbnxhlgotbyghsbgmxschmbuhkobwvwajkcghrmgvvfzmxmaihcenxerznbnkotjubqxhbfqrcwsyfeowixusgfdgreywudrxjbylrnydtpfawayptifhlbmvrklplxahkxqahqalwsivszwvblpnozfmabzmouaxxbvbsibbzirgiqurhoitzlmpsovcjnkbeeydtkpelxmaulsvozwomofyvcafcenaprlnfxhvvkwpuyycqokybyqrujpdgpnpqcfrmdunejkidxpkdipigmkqwasfdewnhumokvubzqxserhpsxoskmvhsflmtvootrhpnjguqmqhpuiosqpiwmmahvuimwcquktrfnniybyhuftrfzqpmvvklgoilbwvtvaprddkwiwiezxarnxnzgqzqxhseodyyleerusznmmyxxvlmokiyhpsghcububxzrglgskrkbagamwvxxrkplpjrcsxvvvcjmjzsemvjvfmesckkrfabzfxxzmwthxldyoyhbsdsqmrugnsyracggnsextkzjqyivpiiambvsulqjefbheakvwkffcvjnuvkgusnawxdtibaycabnzeobaljpfhlhbaismpplqckycavmhttyakpngcnuawxdwwfhswyllbbhbkmuvgdulfzwymgfcaqlozazylwpafzwgjhxbibllvdgsaiadtpryangehchkwkprhzpbszkobjcfmhffqxdcvghqftqyxorllrrheptcrhhlhrytwkytqmqlnvgoogjdlejnslpehtndmounvrtxplzyzlvcyuviknxoyhomwjzigiufhwqmjnwqpuukcxxhatxrgqiayqkkuwbxxbyejvxjpiflbeqjqemvkzcayitimalelkqmvrydiknqeghabhfuogujutrnzkmqqphbnrbnxhlgotbyghsbgmxschmbuhkobwvwajkcghrmgvvfzmxmaihcenxerznbnkotjubqxhbfqrcwsyfeowixusgfdgreywudrxjbylrnydtpfawayptifhlbmvrklplxahkxqahqalwsivszwvblpnozfmabzmouaxxbvbsibbzirgiqurhoitzlmpsovcjnkbeeydtkpelxmaulsvozwomofyvcafcenaprlnfxhvvkwpuyycqokybyqrujpdgpnpqcfrmdunejkidxpkdipigmkqwasfdewnhumokvubzqxserhpsxoskmvhsflmtvootrhpnjguqmqhpuiosqpiwmmahvuimwcquktrfnniybyhuftrfzqpmvvklgoilbwvtvaprddkwiwiezxarnxnzgqzqxhseodyyleerusznmmyxxvlmokiyhpsghcububxzrglgskrkbagamwvxxrkplpjrcsxvvvcjmjzsemvjvfmesckkrfabzfxxzmwthxldyoyhbsdsqmrugnsyracggnsextkzjqyivpiiambvsulqjefbheakvwkffcvjnuvkgusnawxdtibaycabnzeobaljpfhlhbaismpplqckycavmhttyakpngcnuawxdwwfhswyllbbhbkmuvgdulfzwymgfcaqlozazylwpafzwgjhxbibllvdgsaiadtpryangehchkwkprhzpbszkobjcfmhffqxdcvghqftqyxorllrrheptcrhhlhrytwkytqmqlnvgoogjdlejnslpehtndmounvrtxplzyzlvcyuviknxoyhomwjzigiufhwqmjnwqpuukcxxhatxrgqiayqkkuwbxxbyejvxjpiflbeqjqemvkzcayitimalelkqmvrydiknqeghabhfuogujutrnzkmqqphbnrbnxhlgotbyghsbgmxschmbuhkobwvwajkcghrmgvvfzmxmaihcenxerznbnkotjubqxhbfqrcwsyfeowixusgfdgreywudrxjbylrnydtpfawayptifhlbmvrklplxahkxqahqalwsivszwvblpnozfmabzmouaxxbvbsibbzirgiqurhoitzlmpsovcjnkbeeydtkpelxmaulsvozwomofyvcafcenaprlnfxhvvkwpuyycqokybyqrujpdgpnpqcfrmdunejkidxpkdipigmkqwasfdewnhumokvubzqxserhpsxoskmvhsflmtvootrhpnjguqmqhpuiosqpiwmmahvuimwcquktrfnniybyhuftrfzqpmvvklgoilbwvtvaprddkwiwiezxarnxnzgqzqxhseodyyleerusznmmyxxvlmokiyhpsghcububxzrglgskrkbagamwvxxrkplpjrcsxvvvcjmjzsemvjvfmesckkrfabzfxxzmwthxldyoyhbsdsqmrugnsyracggnsextkzjqyivpiiambvsulqjefbheakvwkffcvjnuvkgusnawxdtibaycabnzeobaljpfhlhbaismpplqckycavmhttyakpngcnuawxdwwfhswyllbbhbkmuvgdulfzwymgfcaqlozazylwpafzwgjhxbibllvdgsaiadtpryangehchkwkprhzpbszkobjcfmhffqxdcvghqftqyxorllrrheptcrhhlhrytwkytqmqlnvgoogjdlejnslpehtndmounvrtxplzyzlvcyuviknxoyhomwjzigiufhwqmjnwqpuukcxxhatxrgqiayqkkuwbxxbyejvxjpiflbeqjqemvkzcayitimalelkqmvrydiknqeghabhfuogujutrnzkmqqphbnrbnxhlgotbyghsbgmxschmbuhkobwvwajkcghrmgvvfzmxmaihcenxerznbnkotjubqxhbfqrcwsyfeowixusgfdgreywudrxjbylrnydtpfawayptifhlbmvrklplxahkxqahqalwsivszwvblpnozfmabzmouaxxbvbsibbzirgiqurhoitzlmpsovcjnkbeeydtkpelxmaulsvozwomofyvcafcenaprlnfxhvvkwpuyycqokybyqrujpdgpnpqcfrmdunejkidxpkdipigmkqwasfdewnhumokvubzqxserhpsxoskmvhsflmtvootrhpnjguqmqhpuiosqpiwmmahvuimwcquktrfnniybyhuftrfzqpmvvklgoilbwvtvaprddkwiwiezxarnxnzgqzqxhseodyyleerusznmmyxxvlmokiyhpsghcububxzrglgskrkbagamwvxxrkplpjrcsxvvvcjmjzsemvjvfmesckkrfabzfxxzmwthxldyoyhbsdsqmrugnsyracggnsextkzjqyivpiiambvsulqjefbheakvwkffcvjnuvkgusnawxdtibaycabnzeobaljpfhlhbaismpplqckycavmhttyakpngcnuawxdwwfhswyllbbhbkmuvgdulfzwymgfcaqlozazylwpafzwgjhxbibllvdgsaiadtpryangehchkwkprhzpbszkobjcfmhffqxdcvghqftqyxorllrrheptcrhhlhrytwkytqmqlnvgoogjdlejnslpehtndmounvrtxplzyzlvcyuviknxoyhomwjzigiufhwqmjnwqpuukcxxhatxrgqiayqkkuwbxxbyejvxjpiflbeqjqemvkzcayitimalelkqmvrydiknqeghabhfuogujutrnzkmqqphbnrbnxhlgotbyghsbgmxschmbuhkobwvwajkcghrmgvvfzmxmaihcenxerznbnkotjubqxhbfqrcwsyfeowixusgfdgreywudrxjbylrnydtpfawayptifhlbmvrklplxahkxqahqalwsivszwvblpnozfmabzmouaxxbvbsibbzirgiqurhoitzlmpsovcjnkbeeydtkpelxmaulsvozwomofyvcafcenaprlnfxhvvkwpuyycqokybyqrujpdgpnpqcfrmdunejkidxpkdipigmkqwasfdewnhumokvubzqxserhpsxoskmvhsflmtvootrhpnjguqmqhpuiosqpiwmmahvuimwcquktrfnniybyhuftrfzqpmvvklgoilbwvtvaprddkwiwiezxarnxnzgqzqxhseodyyleerusznmmyxxvlmokiyhpsghcububxzrglgskrkbagamwvxxrkplpjrcsxvvvcjmjzsemvjvfmesckkrfabzfxxzmwthxldyoyhbsdsqmrugnsyracggnsextkzjqyivpiiambvsulqjefbheakvwkffcvjnuvkgusnawxdtibaycabnzeobaljpfhlhbaismpplqckycavmhttyakpngcnuawxdwwfhswyllbbhbkmuvgdulfzwymgfcaqlozazylwpafzwgjhxbibllvdgsaiadtpryangehchkwkprhzpbszkobjcfmhffqxdcvghqftqyxorllrrheptcrhhlhrytwkytqmqlnvgoogjdlejnslpehtndmounvrtxplzyzlvcyuviknxoyhomwjzigiufhwqmjnwqpuukcxxhatxrgqiayqkkuwbxxbyejvxjpiflbeqjqemvkzcayitimalelkqmvrydiknqeghabhfuogujutrnzkmqqphbnrbnxhlgotbyghsbgmxschmbuhkobwvwajkcghrmgvvfzmxmaihcenxerznbnkotjubqxhbfqrcwsyfeowixusgfdgreywudrxjbylrnydtpfawayptifhlbmvrklplxahkxqahqalwsivszwvblpnozfmabzmouaxxbvbsibbzirgiqurhoitzlmpsovcjnkbeeydtkpelxmaulsvozwomofyvcafcenaprlnfxhvvkwpuyycqokybyqrujpdgpnpqcfrmdunejkidxpkdipigmkqwasfdewnhumokvubzqxserhpsxoskmvhsflmtvootrhpnjguqmqhpuiosqpiwmmahvuimwcquktrfnniybyhuftrfzqpmvvklgoilbwvtvaprddkwiwiezxarnxnzgqzqxhseodyyleerusznmmyxxvlmokiyhpsghcububxzrglgskrkbagamwvxxrkplpjrcsxvvvcjmjzsemvjvfmesckkrfabzfxxzmwthxldyoyhbsdsqmrugnsyracggnsextkzjqyivpiiambvsulqjefbheakvwkffcvjnuvkgusnawxdtibaycabnzeobaljpfhlhbaismpplqckycavmhttyakpngcnuawxdwwfhswyllbbhbkmuvgdu"));
        Assertions.assertEquals("lzyzl", actual);
    }

    public <T> T run(Callable<T> callable) throws Exception {
        Instant before = Instant.now();
        T call = callable.call();
        Instant after = Instant.now();
        System.out.println("duration: " + Duration.between(before, after).toMillis());
        return call;
    }
}
