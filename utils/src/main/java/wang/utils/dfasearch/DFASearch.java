package wang.utils.dfasearch;

import cn.hutool.dfa.WordTree;

import java.util.List;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/20 15:17
 * @description DFA查找工具类
 */
public class DFASearch {
    public static void main(String[] args) {
        WordTree tree = new WordTree();
        tree.addWord("大");
        tree.addWord("大土豆");
        tree.addWord("土豆");
        tree.addWord("刚出锅");
        tree.addWord("出锅");
        String text = "我有一颗大土豆，刚出锅的";
        // 标准匹配，匹配到最短关键词，并跳过已经匹配的关键词
        List<String> matchAll = tree.matchAll(text, -1, false, false);
        System.out.println("matchAll1 = " + matchAll);
        // 匹配到最短关键词，不跳过已经匹配的关键词
        matchAll = tree.matchAll(text, -1, true, false);
        System.out.println("matchAll2 = " + matchAll);
        // 匹配到最长关键词，跳过已经匹配的关键词
        matchAll = tree.matchAll(text, -1, false, true);
        System.out.println("matchAll3 = " + matchAll);
        // 匹配到最长关键词，不跳过已经匹配的关键词（最全关键词）
        matchAll = tree.matchAll(text, -1, true, true);
        System.out.println("matchAll4 = " + matchAll);
    }
}
