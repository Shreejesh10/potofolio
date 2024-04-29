def read_files():
    with open("land.txt", "r") as file:#For Opening the file
        lines = file.readlines()#it reads all the line from the file
        land_data = {}#a empty dictionery

        for line in lines:
            values = line.split(',')#Splitting the line by/t
            value =[]
            key = values[0]
            for i in range (1,len(values)):
                value.append(values[i].strip())
            land_data[key]=value
    return land_data


    
