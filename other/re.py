!pip install memory_profiler
import time
from csv import reader
import time
from csv import reader
from itertools import chain, combinations
import matplotlib.pyplot as plt

% load_ext memory_profiler
from memory_profiler import profile

% cd '/content'
!git clone https://github.com/meghoshpritam/test_dataset.git


class FPTreeTest:
    @staticmethod
    class Node:
        def __init__(self, item_name, frequency, parent_node):
            self.itemName = item_name
            self.count = frequency
            self.parent = parent_node
            self.children = {}
            self.next = None

        def increment(self, frequency):
            self.count += frequency

        def display(self, ind=1):
            print('  ' * ind, self.itemName, ' ', self.count)
            for child in list(self.children.values()):
                child.display(ind + 1)

    @staticmethod
    def get_from_file(file_name):
        item_set_list = []

        with open(file_name, 'r') as file:
            csv_reader = reader(file)
            for line in csv_reader:
                line = list(filter(None, line))
                item_set_list.append(line)

        return item_set_list

    @staticmethod
    def construct_tree(item_sets, min_sup):
        header_table = {}
        frequent_pattern = {}

        # Counting frequency and create header table
        for idx, items in enumerate(item_sets):
            for item in items:
                if frequent_pattern.get(item) is None:
                    frequent_pattern[item] = 1
                else:
                    frequent_pattern[item] += 1

        # Deleting items below minSup
        for item in frequent_pattern.items():
            if item[1] >= min_sup:
                header_table[item[0]] = [item[1], None]
        del frequent_pattern
        if len(header_table) == 0:
            return None, None

        # Init Null head node
        fp_tree = FPTreeTest.Node('Null', 1, None)

        # Update FP tree for each cleaned and sorted itemSet
        for item_set in item_sets:
            item_set = [
                item for item in item_set if item in header_table.keys()]
            item_set.sort(key=lambda itm: header_table[itm][0], reverse=True)

            # Traverse from root to leaf, update tree with given item
            current_node = fp_tree
            for item in item_set:
                current_node = FPTreeTest.update_tree(
                    item, current_node, header_table, 1)
        return fp_tree, header_table

    @staticmethod
    def update_tree(item, tree_node, header_table, frequency):
        if item in tree_node.children:
            # If the item already exists, increment the count
            tree_node.children[item].increment(frequency)
        else:
            # Create a new branch
            new_item_node = FPTree.Node(item, frequency, tree_node)
            tree_node.children[item] = new_item_node
            # Link the new branch to header table
            FPTree.update_header_table(item, new_item_node, header_table)

        return tree_node.children[item]


class DynamicFPTreeTest:
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
                new_child = DynamicFPTreeTest.Node(item_name, frequency, self)
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
        avg_support = int((max_frequency - min_frequency) / total_item)

        frequent_patterns_nis = {}
        for key in supports.keys():
            nis = avg_support
            if supports[key] >= min_support:
                nis = int(supports[key] * (1 - scaling_factor))
            if max_frequency >= nis >= avg_support:
                frequent_patterns_nis[key] = [supports[key], nis]

        del supports
        return frequent_patterns_nis

    @staticmethod
    def create_tree(item_sets, min_support_ratio, scaling_factor):
        min_support = len(item_sets) * min_support_ratio
        supports = DynamicFPTreeTest.get_support_nic(
            item_sets, min_support, scaling_factor)

        tree = DynamicFPTreeTest.Node('Null', 1)
        for row in item_sets:
            item_set = [
                item for item in row if item in supports.keys()]
            item_set.sort(
                key=lambda itm: supports[itm][1], reverse=True)
            for item in item_set:
                tree.add_child(item, 1)
        return tree

    @staticmethod
    def prefix_trees(tree):
        prefix_tres = []
        if tree.children is not None:
            for idx in range(len(tree.children)):
                new_tree = DynamicFPTreeTest.Node('Null', 1)
                for index in range(0, idx + 1):
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


class Test1:
    @staticmethod
    def fp_tree(file_name, min_sup_ratio):
        item_set_list = FPTreeTest.get_from_file(file_name)
        min_sup = len(item_set_list) * min_sup_ratio
        fp_tree, _ = FPTreeTest.construct_tree(item_set_list, min_sup)

        if fp_tree is not None:
            # fp_tree.display()
            pass
        else:
            print("Tree is empty")

    @staticmethod
    def dynamic_fp_tree(file_name, min_sup_ratio, scaling_factor):
        item_set = DynamicFPTreeTest.get_from_file(file_name)
        tree = DynamicFPTreeTest.create_tree(item_set, min_sup_ratio, scaling_factor)
        # tree.display()


print("Avilavle datasates: ")
! ls -al test_dataset

configs = [
    {
        'file_name': '/content/test_dataset/kaggle.csv',
        'min_sup_ratio': 0.1
    },
    {
        'file_name': '/content/test_dataset/gd2.csv',
        'min_sup_ratio': 0.1
    },
    {
        'file_name': '/content/test_dataset/groceries.csv',
        'min_sup_ratio': 0.1
    }
]


print("\n\n---------------------------------------------------------------------\n\n")
# ploat_pie_file(file_name)

print("\n\n----------------------------- Test Start --------------------------------\n\n")
item_len = []
fp = []
dfp = []

for config in configs:
    file_name  = config['file_name']
    min_sup_ratio  = config['min_sup_ratio']

    total_item = len(DynamicFPTreeTest.get_from_file(file_name))
    item_len.append(total_item)

    start = time.time()
    print('\nfp')
    # %memit Test1.fp_tree(file_name, min_sup_ratio)
    time1 = time.time() - start
    fp.append(time1)
    print("fp tile: ", time1)

    start = time.time()
    print('dfp')
    # %memit Test1.dynamic_fp_tree(file_name, min_sup_ratio, 0.1)
    dfp.append(time.time() - start)
    time2 = time.time() - start
    fp.append(time2)
    print("dfp tile: ", time2)

result

print("\n")
plt.plot(item_len, fp, label='fp tree') 
plt.plot(item_len, dfp, label='dfp tree') 
plt.xlabel('Data Set Size')
plt.ylabel('Time')
plt.title("Fp tree and dynamic fp tree")
plt.legend()
plt.show()