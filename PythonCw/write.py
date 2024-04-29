import datetime

def write_files(land_data):
    with open("land.txt", "w") as file:
        for key, value in land_data.items():
            file.write(key + "," + value[0] + "," + value[1] + "," + value[2] + "," + value[3] + "," + value[4] + "\n")


    

    #Writing the bills
   
    
        
