ALPHABET_SIZE = 26
ALPHABET_START_VAL = 97


class Trie(object):
    def __init__(self):
        self.is_finished = False
        self.children = [None for _ in range(ALPHABET_SIZE)]

    def add(self, word):
        if not word:
            self.is_finished = True
        else:
            key = ord(word[0]) - ALPHABET_START_VAL
            if not self.children[key]:
                self.children[key] = Trie()
            self.children[key].add(word[1:])

    def is_possible(self, word):
        if not word:
            return True

        key = ord(word[0]) - ALPHABET_START_VAL
        if self.children[key] and self.children[key].is_finished:
            return self.children[key].is_possible(word[1:])
        return False


class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        words.sort()
        root = Trie()
        for word in words:
            root.add(word)

        answer = ''
        for word in words:
            if root.is_possible(word) and len(word) > len(answer):
                answer = word
        return answer


if __name__ == '__main__':
    solution = Solution()
    print solution.longestWord(["a", "banana", "app", "appl", "ap", "apply", "apple"])
    # print solution.longestWord(["w", "wo"])

