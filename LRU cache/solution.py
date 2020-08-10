class LRUCache:

    def __init__(self, capacity: int):
        self.size = capacity
        self.data = OrderedDict()

    def get(self, key: int) -> int:
        if key not in self.data:
            return -1
        else:
            self.data.move_to_end(key)
            return self.data[key]

    def put(self, key: int, value: int) -> None:
        if key not in self.data and len(self.data) == self.size:
            self.data.popitem(last = False)
            self.data[key] = value
        else:
            self.data[key] = value
        self.data.move_to_end(key)