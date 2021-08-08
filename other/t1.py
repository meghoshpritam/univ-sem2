from csv import reader
import time


class DynamicFPTree:
    @staticmethod
    class Node:
        def __init__(self, item_name, frequency, parent=None):
            self.item_name = item_name
            self.count = frequency
            self.parent = parent
            self.children = [] if parent is None else None

        def add_child(self, item_name, frequency):
            if self.children is not None:
                for child in self.children:
                    if child.item_name == item_name:
                        child.count += frequency
                        return
                new_child = DynamicFPTree.Node(item_name, frequency, self)
                self.children.append(new_child)

        def display(self, ind=1):
            print('  ' * ind, self.item_name, ' ', self.count)
            if self.children is not None:
                for child in self.children:
                    child.display(ind + 1)

    @staticmethod
    def get_support_nic(item_sets, min_support, scaling_factor):
        supports = {}
        max_frequency = 1
        total_item = 0
        for row in item_sets:
            for item in row:
                if item in supports:
                    supports[item] += 1
                    if supports[item] > max_frequency:
                        max_frequency = supports[item]
                else:
                    supports[item] = 1
                    total_item += 1

        min_frequency = min(supports.values())

        # average support for new item support
        avg_support = (int)((max_frequency - min_frequency)/total_item)

        frequent_patterns_nis = {}
        for key in supports.keys():
            nis = avg_support
            if supports[key] >= min_support:
                nis = (int)(supports[key]*(1-scaling_factor))
            if max_frequency >= nis >= avg_support:
                frequent_patterns_nis[key] = [supports[key], nis]

        del supports
        return frequent_patterns_nis

    @staticmethod
    def create_tree(item_sets,  min_support_ratio, scaling_factor):
        min_support = len(item_sets)*min_support_ratio
        supports = DynamicFPTree.get_support_nic(
            item_sets,  min_support, scaling_factor)

        tree = DynamicFPTree.Node('Null', 1)
        for row in item_sets:
            item_set = [
                item for item in row if item in supports.keys()]
            item_set.sort(
                key=lambda itm: supports[itm][1], reverse=True)
            for item in item_set:
                tree.add_child(item, 1)
        # tree.display()
        # prefix_trees(tree)
        return tree

    @staticmethod
    def prefix_trees(tree):
        prefix_tres = []
        if tree.children is not None:
            for idx in range(len(tree.children)):
                new_tree = DynamicFPTree.Node('Null', 1)
                for index in range(0, idx+1):
                    new_tree.add_child(
                        tree.children[index].item_name, tree.children[index].count)
                prefix_tres.append(new_tree)
        for t in prefix_tres:
            t.display()

    @staticmethod
    def get_from_file(file_name):
        item_set_list = []

        with open(file_name, 'r') as file:
            csv_reader = reader(file)
            for line in csv_reader:
                line = list(filter(None, line))
                item_set_list.append(line)
        return item_set_list


if __name__ == '__main__':
    start = time.time()
    DynamicFPTree.create_tree(DynamicFPTree.get_from_file(
        '/home/computer/work/univ/other/dataset/testdb1.csv'), 0.4, 0.4)

    print('Time: ', time.time() - start)
