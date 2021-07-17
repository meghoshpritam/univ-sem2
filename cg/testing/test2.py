from test import dda_linedrawing
from tkinter import Tk, StringVar, Label, Entry, Button, Canvas

root = Tk()

root.geometry("600x400")

name_var = StringVar()
passw_var = StringVar()


def submit():
    name = name_var.get()
    password = passw_var.get()

    print("The name is : " + name)
    print("The password is : " + password)
    
    name_var.set("")
    passw_var.set("")
    
    canvas = Canvas(root, width=500,
                    height=500, background="red")

    canvas.create_oval(15,20,50,50, width=5,
                       fill="red", outline="black")
    canvas.pack()
    # root.destroy()


name_label = Label(root, text='Username', font=('calibre', 10, 'bold'))


name_entry = Entry(root, textvariable=name_var,
                      font=('calibre', 10, 'normal'))

passw_label = Label(root, text='Password', font=('calibre', 10, 'bold'))


passw_entry = Entry(root, textvariable=passw_var,
                       font=('calibre', 10, 'normal'), show='*')


sub_btn = Button(root, text='Submit', command=submit)
# sub_btn.pack(pady=20)

name_label.grid(row=0, column=0)
name_entry.grid(row=0, column=1)
passw_label.grid(row=1, column=0)
passw_entry.grid(row=1, column=1)
sub_btn.grid(row=2, column=1)


root.mainloop()
