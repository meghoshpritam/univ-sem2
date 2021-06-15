from tkinter import Tk, Canvas, Label

root = Tk()
# w = Label(root, text='tet')
# w.pack()
root.title('test')
w = Canvas(root, width=500, height=500)
w.create_rectangle(0, 0, 100, 100, fill="#ff8975", outline='#256698')
w.create_rectangle(50, 50, 100, 100, fill="red", outline='blue')
w.pack()
root.mainloop()
