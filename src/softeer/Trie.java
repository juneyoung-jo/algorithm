package softeer;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	private TrieNode rootNode;

	Trie() {
		rootNode = new TrieNode();
	}

	void insert(String word) {
		TrieNode thisNode = this.rootNode;

		for (int i = 0; i < word.length(); i++) {
			thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
		}
		thisNode.setLastChar(true);
	}

	boolean contains(String word) {
		TrieNode thisNode = this.rootNode;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode node = thisNode.getChildNodes().get(c);
			if (node == null) {
				return false;
			}

			
			thisNode = node;
		}

		return thisNode.isLastChar();
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("PI");
		trie.insert("PIE");
		trie.insert("POW");
		trie.insert("POP");

		System.out.println(trie.contains("PI"));

	}

}

class TrieNode {

	private Map<Character, TrieNode> childNodes = new HashMap<>();

	private boolean isLastChar;

	public Map<Character, TrieNode> getChildNodes() {
		return childNodes;
	}

	public boolean isLastChar() {
		return isLastChar;
	}

	public void setLastChar(boolean isLastChar) {
		this.isLastChar = isLastChar;
	}

}
