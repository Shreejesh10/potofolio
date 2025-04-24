def read_files():
     """
    Read land data from a file and return as a dictionary.
    Opens the 'land.txt' file, reads each line, splits it by comma, and stores the values in a dictionary.
    Returns a dictionary containing land data with kitta number as keys and corresponding information as values.
    """
     with open("land.txt", "r") as file:#For Opening the file
        lines = file.readlines()#it reads all the line from the file
        land_data = {}#a empty dictionary

        for line in lines:
            values = line.split(',')#Splitting the line by/t
            value =[] #Creating an empty list for storing values
            #THe key is considered the first elements
            key = values[0]
            #Stripping white spaces and adding it to the list
            for i in range (1,len(values)):
                value.append(values[i].strip())
                #Assigning the key value pair to land data dictionary
            land_data[key]=value
     #For returning the land data dictionary
     return land_data


    
