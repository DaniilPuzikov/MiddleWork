id = 0

def write(path,record):
    data = open(path,'a')
    data.write(record)
    data.close()

def read(path):
    data = open(path,'r')
    for line in data:
        print(line)
    data.close

def recordBuider(title,body):
    import datetime
    global id
    dict = {}
    dict['title']=title
    dict['msg']=body
    dict['date']=str(datetime.datetime.now())
    record = str(id)+' '+str(dict)+'\n'
    id+=1
    return record

def delete(path,id):
    all_data = []
    res = ''
    with open(path,'r') as data:
        for line in data:
            if line[0]!=id:
                all_data.append(line)
    with open(path,'w') as data:
        for item in all_data:
            res+=item
        data.write(res)

def search(path,id):
    with open(path,'r') as data:
        for line in data:
            if line.split()[0]==id:
                print(line)
                break
    print('This record does not exist')

def change(path,change_id,new_title,new_body):
    global id
    temp = id
    id = int(change_id)
    all_data=[]
    res = ''
    with open(path,'r') as data:
        for line in data:
            if line[0]==change_id:
                all_data.append(recordBuider(new_title,new_body))
            else:
                all_data.append(line)
    with open(path,'w') as data:
        for item in all_data:
            res+=item
        data.write(res)
    id = temp
    
    


def menu():
    path = input('Enter file name: ')
    play = True
    while play:
        action = input('1. Add record\n'
                       '2. Read all\n'
                       '3. Search record\n'
                       '4. Change record\n'
                       '5. Delete record\n'
                       '6. Exit\n')
        match action:
            case '1':
                title = input('Enter record title: ')
                body = input('Enter record message: ')
                write(path,recordBuider(title,body))
            case '2':
                read(path)
            case '3':
                search_id = input('Enter id: ')
                search(path,search_id)
            case '4':
                change_id = input('Enter id: ')
                title = input('Enter new title: ')
                body = input('Enter new message: ')
                change(path,change_id,title,body)
            case '5':
                delete_id = input('Enter id: ')
                delete(path,delete_id)
            case '6':
                print('Bye')
                play = False
            case _:
                print('This operation does  not exist')


menu()