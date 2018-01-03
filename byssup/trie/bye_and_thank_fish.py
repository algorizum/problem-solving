
ALPHABET_SIZE = 26
START_ALPHABET_VAL = 97


class Trie():

    def __init__(self):
        self.final_id = -1
        self.first_id = -1
        self.children = [None for _ in range(ALPHABET_SIZE)]

    def create_trie(self, word, id):
        if self.first_id == -1:
            self.first_id = id

        if not word:
            self.first_id = id
        else:
            key = ord(word[0]) - START_ALPHABET_VAL
            if not self.children[key]:
                self.children[key] = Trie()
            self.children[key].create_trie(word[1:], id)

    def get_trie(self, word):
        if not word:
            return self
        key = ord(word[0]) - START_ALPHABET_VAL
        if not self.children[key]:
            return None
        return self.children[key].get_trie(word[1:])

    def type(self, word, id):
        if not word:
            return 0

        if self.first_id == id:
            return 1

        key = ord(word[0]) - START_ALPHABET_VAL
        return 1 + self.children(key).type(word[1:], id)

    def count(self, word):
        trie = self.get_trie(word)
        if not trie or trie.final_id == -1:
            return len(word)
        return self.type(word, trie.final_id)

class Solver():

    def __init__(self, words):
        self.words = words

    def solve(self):
        root = Trie()
        for i, word_tuple in enumerate(words):
            root.create_trie(word_tuple[0], i)

        count = 0
        for i, word_tuple in enumerate(words):
            count += root.type(word_tuple[0])
        return count

if __name__ == '__main__':
    for _ in range(int(raw_input())):
        arr = raw_input().split()
        words = []
        for _ in range(int(arr[0])):
            new_arr = raw_input().split()
            words.append((new_arr[0], int(new_arr[1])))
        solver = Solver()
        print solver.solve()