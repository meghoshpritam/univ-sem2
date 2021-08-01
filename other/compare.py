from fileinput import filename
import time
from fp_growth import construct_tree, get_from_file
from fp_tree import create_tree, get_from_file as get_from_file2


def fp_tree1(file_name, min_sup_ratio):
    item_set_list, frequency = get_from_file(file_name)
    min_sup = len(item_set_list) * min_sup_ratio
    fp_tree, _ = construct_tree(item_set_list, frequency, min_sup)

    if fp_tree is not None:
        # fp_tree.display()
        pass
    else:
        print("No tree is empty")


def fp_tree2(file_name, min_sup_ratio, scaling_factor):
    item_set = get_from_file2(file_name)
    tree = create_tree(item_set, min_sup_ratio, scaling_factor)
    # tree.display()

if __name__ == '__main__':
    file_name = '/home/computer/work/univ/other/dataset/groceries.csv'
    min_sup_ratio = 0.01

    start = time.time()
    fp_tree1(file_name, min_sup_ratio)
    print('Time1: ', time.time() - start)

    start = time.time()
    fp_tree2(file_name, min_sup_ratio, 0.1)
    print('Time2: ', time.time() - start)
