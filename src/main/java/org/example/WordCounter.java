package org.example;


import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public static Map<String, Integer> calculatedWord() {
        String text = "When the offensive resumed, the Turks received their first victory when the Greeks encountered stiff resistance in the battles of First and Second İnönü,\" +\n" +
                "  \" due to İsmet Pasha's organization of an irregular militia into a regular army. \" +\n" +
                "  \" The two victories led to Allied proposals to amend the Treaty of Sèvres where both Ankara and Istanbul were represented, but Greece refused.\" +\n" +
                "  \" With the conclusion of the Southern and Eastern fronts, Ankara was able to concentrate more forces on the West against the Greeks.\" +\n" +
                "  \" They also began to receive support from Soviet Union, as well as France and Italy, who sought to check British influence in the Near East.\\n\" +\n" +
                "  \" June–July 1921 saw heavy fighting in the Battle of Kütahya-Eskişehir. While it was an eventual Greek victory, the Turkish army withdrew in good order to the Sakarya river, their last line of defence.\" +\n" +
                "  \" Mustafa Kemal Pasha replaced İsmet Pasha after the defeat as commander in chief as well as his political duties.\" +\n" +
                "  \" The decision was made in the Greek military command to march on the nationalist capital of Ankara to force Mustafa Kemal to the negotiating table.\" +\n" +
                "  \" For 21 days, the Turks and Greeks fought a pitched battle at the Sakarya river, which ended in Greek withdrawal.\" +\n" +
                "  \" Almost of year of stalemate without much fighting followed, during which Greek moral and discipline faltered while Turkish strength increased.\" +\n" +
                "  \" French and Italian forces evacuated from Anatolia. The Allies offered an armistice to the Turks, which Mustafa Kemal refused.";

        Map<String, Integer> wordCounts = new HashMap<>();

        String lower = text.toLowerCase();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (Character.isLetter(c)) {
                currentWord.append(c);
            } else {
                if (currentWord.length() > 0) {
                    String word = currentWord.toString();
                    Integer count = wordCounts.get(word);
                    if (count == null) {
                        wordCounts.put(word, 1);
                    } else {
                        wordCounts.put(word, count + 1);
                    }
                    currentWord.setLength(0);
                }
            }
        }

        if (currentWord.length() > 0) {
            String word = currentWord.toString();
            Integer count = wordCounts.get(word);
            if (count == null) {
                wordCounts.put(word, 1);
            } else {
                wordCounts.put(word, count + 1);
            }
        }

        return wordCounts;
    }
}
