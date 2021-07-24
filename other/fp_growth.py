from csv import reader
from itertools import chain, combinations


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


def get_from_file(file_name):
    item_set_list = []
    frequency = []

    with open(file_name, 'r') as file:
        csv_reader = reader(file)
        for line in csv_reader:
            line = list(filter(None, line))
            item_set_list.append(line)
            frequency.append(1)
    return item_set_list, frequency


def construct_tree(item_sets, frequency, min_sup):
    header_table = {}
    frequent_pattern = {}

    # Counting frequency and create header table
    for idx, items in enumerate(item_sets):
        for item in items:
            if frequent_pattern.get(item) is None:
                frequent_pattern[item] = 1
            else:
                frequent_pattern[item] += frequency[idx]

    # Deleting items below minSup
    for item in frequent_pattern.items():
        if item[1] >= min_sup:
            header_table[item[0]] = [item[1], None]
    del frequent_pattern
    if len(header_table) == 0:
        return None, None

    # Init Null head node
    fp_tree = Node('Null', 1, None)

    # Update FP tree for each cleaned and sorted itemSet
    for idx, item_set in enumerate(item_sets):
        item_set = [item for item in item_set if item in header_table.keys()]
        item_set.sort(key=lambda itm: header_table[itm][0], reverse=True)

        # Traverse from root to leaf, update tree with given item
        current_node = fp_tree
        for item in item_set:
            current_node = update_tree(
                item, current_node, header_table, frequency[idx])
    return fp_tree, header_table


def update_header_table(item, target_node, header_table):
    if header_table[item][1] is None:
        header_table[item][1] = target_node
    else:
        current_node = header_table[item][1]
        # Traverse to the last node then link it to the target
        while current_node.next is not None:
            current_node = current_node.next
        current_node.next = target_node


def update_tree(item, tree_node, header_table, frequency):
    if item in tree_node.children:
        # If the item already exists, increment the count
        tree_node.children[item].increment(frequency)
    else:
        # Create a new branch
        new_item_node = Node(item, frequency, tree_node)
        tree_node.children[item] = new_item_node
        # Link the new branch to header table
        update_header_table(item, new_item_node, header_table)

    return tree_node.children[item]


def ascend_fp_tree(node, prefix_path):
    if node.parent is not None:
        prefix_path.append(node.itemName)
        ascend_fp_tree(node.parent, prefix_path)


def find_prefix_path(base_pat, header_table):
    # First node in linked list
    tree_node = header_table[base_pat][1]
    cond_pats = []
    frequency = []
    while tree_node is not None:
        prefix_path = []
        # From leaf node all the way to root
        ascend_fp_tree(tree_node, prefix_path)
        if len(prefix_path) > 1:
            # Storing the prefix path and it's corresponding count
            cond_pats.append(prefix_path[1:])
            frequency.append(tree_node.count)

        # Go to next node
        tree_node = tree_node.next
    return cond_pats, frequency


def mine_tree(header_table, min_sup, pre_fix, freq_items):
    # Sort the items with frequency and create a list
    sorted_item_list = [item[0] for item in sorted(
        list(header_table.items()), key=lambda p: p[1][0])]
    # Start with the lowest frequency
    for item in sorted_item_list:
        # Pattern growth is achieved by the concatenation of suffix pattern with frequent patterns generated
        # from conditional FP-tree
        new_freq_set = pre_fix.copy()
        new_freq_set.add(item)
        freq_items.append(new_freq_set)
        # Find all prefix path, construct conditional pattern base
        conditional_patt_base, frequency = find_prefix_path(item, header_table)
        # Construct conditional FP Tree with conditional pattern base
        _, new_header_table = construct_tree(
            conditional_patt_base, frequency, min_sup)
        if new_header_table is not None:
            # Mining recursively on the tree
            mine_tree(new_header_table, min_sup,
                      new_freq_set, freq_items)


def power_set(s):
    return chain.from_iterable(combinations(s, r) for r in range(1, len(s)))


def get_support(test_set, item_set):
    count = 0
    for itemSet in item_set:
        if set(test_set).issubset(itemSet):
            count += 1
    return count


def association_rule(freq_item_set, item_set, min_conf):
    rules_new = []
    for itemSet in freq_item_set:
        subsets = power_set(itemSet)
        item_set_sup = get_support(itemSet, item_set)
        for s in subsets:
            confidence = float(item_set_sup / get_support(s, item_set))
            if confidence >= min_conf:
                rules_new.append(
                    [set(s), set(itemSet.difference(s)), confidence])
    return rules_new


def get_frequency_from_list(item_set):
    frequency = [1 for _ in range(len(item_set))]
    return frequency


def fp_growth(item_set, min_sup_ratio, min_conf):
    frequency = get_frequency_from_list(item_set)
    min_sup = len(item_set) * min_sup_ratio
    fp_tree, header_table = construct_tree(item_set, frequency, min_sup)
    if fp_tree is None:
        print('No frequent item set')
        return [], []
    else:
        freq_items = []
        mine_tree(header_table, min_sup, set(), freq_items)
        all_rules = association_rule(freq_items, item_set, min_conf)
        return freq_items, all_rules


def fp_growth_from_file(file_name, min_sup_ratio, min_conf):
    item_set_list, frequency = get_from_file(file_name)
    min_sup = len(item_set_list) * min_sup_ratio
    fp_tree, header_table = construct_tree(item_set_list, frequency, min_sup)
    if fp_tree is None:
        print('No frequent item set')
        return [], []
    else:
        freq_items = []
        mine_tree(header_table, min_sup, set(), freq_items)
        all_rules = association_rule(freq_items, item_set_list, min_conf)
        return freq_items, all_rules


def show_rules(rules):
    rules.sort(key=lambda _rule: _rule[2], reverse=True)
    for rule in rules:
        print(rule[0], '-->', rule[1], 'conf:', rule[2])


if __name__ == "__main__":
    freqItemSet, _rules = fp_growth_from_file(
        '/home/computer/work/univ/other/dataset/tdb.csv', 0.3, 0.95)

    print(freqItemSet)
    print("\n\nAssociation Rules: ")
    show_rules(_rules)
