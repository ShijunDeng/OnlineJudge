#include <iostream>
#include<vector>
#include<string.h>
using namespace std;
class TrieNode {
public:
    // Initialize your data structure here.
    TrieNode(char aVar):var(aVar),sonNodesNum(0),isEnd(true) {
        memset(sonNodes,NULL,26*sizeof(TrieNode*));
    }
    TrieNode():var(NULL),sonNodesNum(0),isEnd(true) {
        memset(sonNodes,NULL,26*sizeof(TrieNode*));
    }
public:
    TrieNode*sonNodes[26];
    int sonNodesNum;
    char var;
    bool isEnd;//whether it's the last node
};

class Trie {
public:
    Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    void insert(string word) {
        TrieNode*p=root;
        int index=0;
        for(char c:word) {
            index=c-'a';
            if(p->sonNodes[index]==NULL) {
                p->sonNodes[index]=new TrieNode(c);

            }
            p->sonNodesNum++;
            p= p->sonNodes[index];
        }
        p->isEnd=false;
    }

    // Returns if the word is in the trie.
    bool search(string word) {
        TrieNode*p=root;
        int index=0;
        for(char c:word) {
            index=c-'a';
            if(p->sonNodes[index]==NULL) {
                return false;
            }
            p= p->sonNodes[index];
        }
        return  p->isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    bool startsWith(string prefix) {
        TrieNode*p = root;
        int index;

        for(char c:prefix) {
            index = c - 'a';
            if(p->sonNodes[index] == NULL)
                return false;
            p = p->sonNodes[index];
        }
        return true;
    }

private:
    TrieNode* root;
};

// Your Trie object will be instantiated and called as such:
// Trie trie;
// trie.insert("somestring");
// trie.search("key");
int main() {
    Solution u;

    cout<<"end!"<<endl;
    return 0;
}
