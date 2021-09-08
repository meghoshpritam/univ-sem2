import time
from csv import reader
import time
from csv import reader
from itertools import chain, combinations
import matplotlib.pyplot as plt

from memory_profiler import profile


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
    def update_header_table(item, target_node, header_table):
        if header_table[item][1] is None:
            header_table[item][1] = target_node
        else:
            current_node = header_table[item][1]
            # Traverse to the last node then link it to the target
            while current_node.next is not None:
                current_node = current_node.next
            current_node.next = target_node

    @staticmethod
    def update_tree(item, tree_node, header_table, frequency):
        if item in tree_node.children:
            # If the item already exists, increment the count
            tree_node.children[item].increment(frequency)
        else:
            # Create a new branch
            new_item_node = FPTreeTest.Node(item, frequency, tree_node)
            tree_node.children[item] = new_item_node
            # Link the new branch to header table
            FPTreeTest.update_header_table(item, new_item_node, header_table)

        return tree_node.children[item]