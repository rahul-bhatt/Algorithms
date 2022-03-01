package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Write a function that takes in a big string and an array of small strings,
 * all of which are smaller in length than the big string. The function should 
 * return an array of booleans, where each boolean represents whether the small 
 * string at index in the aray of small strings is contaianed in the big string.
 * 
 * Not you can't use language-built-in string-matching methods.
 * 
 * Example:
 * bigString = "this is a big string"
 * smallStrings = ["this", "yo", "is", "a", "bigger", "string", "kappa"]
 * output = [true, false, true, true, false, true, false]
 * 
 * @author rahulbhatt
 *
 */

public class MultiStringSearch {

	public static void main(String[] args) {
		String bigString = "this is a big string";
		String[] smallStrings = new String[] {"this", "yo", "is", "a", "bigger", "string", "kappa"};
		
		List<Boolean> solution = multiStringSearch(bigString, smallStrings);
		
		for(Boolean sol : solution) {
			System.out.print(sol + " ");
		}
	}

	//Time: O(ns + bs), Space: O(ns)
	//n - number of small strings
	//s - length of the longest small string
	//b - length of the big string
	public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
		Trie trie = new Trie();
		for(String smallString : smallStrings) {
			trie.insert(smallString);
		}

		Set<String> containedStrings = new HashSet<String>();
		for(int i = 0; i < bigString.length(); i++) {
			findSmallStringsIn(bigString, i, trie, containedStrings);
		}

		List<Boolean> solution = new ArrayList<Boolean>();
		
		for(String str : smallStrings) {
			solution.add(containedStrings.contains(str));
		}
		
		return solution;
	}

	public static void findSmallStringsIn(
			String str,
			int startIdx,
			Trie trie,
			Set<String> containedStrings) {
		
		TrieNode currentNode = trie.root;

		for(int i = startIdx; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			if(!currentNode.children.containsKey(currentChar)) {
				break;			
			}

			currentNode = currentNode.children.get(currentChar);
			
			if(currentNode.children.containsKey(trie.endSymbol)) {
				containedStrings.add(currentNode.word);
			}
		}
	}

	static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		String word;
	}

	static class Trie {
		TrieNode root = new TrieNode();
		char endSymbol = '*';

		public void insert(String str) {
			TrieNode node = root;
			for(int i = 0; i < str.length(); i++) {
				char letter = str.charAt(i);

				if(!node.children.containsKey(letter)) {
					TrieNode newNode = new TrieNode();
					node.children.put(letter, newNode);
				}

				node = node.children.get(letter);
			}

			node.children.put(endSymbol, null);
			node.word = str;
		}
	}
}
