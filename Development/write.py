import datetime
# Function to write updated land data to text file
def write_files(land_data):
    """
    Write the availability of the land to a text file.
    land_data (dict): A dictionary containing land data with kitta number as keys and corresponding information as values.
    """
    with open("land.txt", "w") as file:
        for key, value in land_data.items():
            # Updating the land status
            file.write(key + "," + value[0] + "," + value[1] + "," + value[2] + "," + value[3] + "," + value[4] + "\n")


# Function to generate invoice for renting land
def invoice_gen(name, address, phone_number,bills):
    """
    print invoice for renting land in a well structured manners.
    Writes the invoice in text file in a well structured manners
    
    """
    Total = 0 # Total rental amount
    for i in bills:
        Total+=int(i[6]) #Calculating the total amount of rent 
    
    date_time = datetime.datetime.now() # Current date and time
    #Setting the rented bills text file name 
    filename= ("rent") +str(date_time.year)+str(date_time.month)+str(date_time.day)+str(date_time.hour)+str(date_time.minute)+str(date_time.second)+".txt"
     # Writing invoice details to file
    with open(filename, "w") as file:
        file.write("_"*140+"\n")
        file.write('                                             Techno Property Nepal\n')
        file.write('                                     ph.no:01-7374939,Baneshwor,Kathmandu,Nepal\n')
        file.write("=="*70+"\n")
        file.write("Billed To:\n")
        file.write("--"*70+"\n")
        file.write("Client Name:"+name+"\n")
        file.write("Address:"+address+"\n")
        file.write("Contact Number:"+str(phone_number)+"\n")
        file.write("Date and time of purchase: "+str(date_time)+"\n" )
        file.write("__"*70+"\n")
        file.write("\n\n")
        file.write("Rented Land Details:\n")
        file.write("--"*70+"\n")
        file.write("Kitta.no \t City \t\tDirection \t Anna \t\tPrice  \t\tRented Time \t\tTotal Price\n")
        file.write("--"*70+"\n")

        print("_"*140)
        print('                                             Techno Property Nepal')
        print('                                     ph.no:01-7374939,Baneshwor,Kathmandu,Nepal')
        print("=="*70)
        print("--"*70)
        print("Billed To:")
        print("--"*70)
        print("Client Name:"+name)
        print("Address:"+address)
        print("Contact Number:"+str(phone_number))
        print("Date and time of purchase: "+str(date_time), )
        print("__"*70)
        print("\n")
        print("Rented Land Details:")
        print("--"*70)
        print("Kitta.no \t City \t\tDirection \t Anna \t\tPrice  \t\tRented Time \t\tTotal Price")
        print("--"*70)
        for each in bills:
            print(str(each[0])+"\t\t"+str(each[1])+"\t"+str(each[2])+"\t\t"+str(each[3])+"\t\t"+str(each[4])+"\t\t\t"+str(each[5])+"\t\t"+str(each[6]))
            file.write(str(each[0])+"\t\t"+str(each[1])+"\t"+str(each[2])+"\t\t"+str(each[3])+"\t\t"+str(each[4])+"\t\t\t"+str(each[5])+"\t\t"+str(each[6])+"\n")
        print("--"*70)
        print("Total Amount:\t\t\t\t\t\t\t\t\t\t\t\t\t"+str(Total))
        print("--"*70+"\n")
        file.write("--"*70+"\n")
        file.write("Total Amount:\t\t\t\t\t\t\t\t\t\t\t\t"+str(Total)+"\n")
        file.write("--"*70+"\n")
# Function to generate invoice for returning land
def return_invoice_gen(name,bills):
    """
    print invoice for returning land in a well structured manners.
    Writes the invoice in text file in a well structured manners
    
    """
     # Total amount to be paid
    Total = 0
    fine_total= 0
    for i in bills:
        Total=int(i[6])+int(i[7]) #Calculating teh fine amount

    date_time= datetime.datetime.now() # Current date and time
    #Setting the returned bills text file name
    filename=  ("land_return") + str(date_time.year)+str(date_time.month)+str(date_time.day)+str(date_time.hour)+str(date_time.minute)+str(date_time.second)+".txt"
    # Writing return invoice details to file
    with open(filename, "w") as file:
        file.write("_"*140+"\n")
        file.write('                                             Techno Property Nepal\n')
        file.write('                                     ph.no:01-7374939,Baneshwor,Kathmandu,Nepal\n')
        file.write("=="*70+"\n")
        file.write("Billed To:\n")
        file.write("--"*70+"\n")
        file.write("Client Name:"+name+"\n")
        file.write("Date and time of return: "+str(date_time)+"\n" )
        file.write("__"*70+"\n")
        file.write("\n\n")
        file.write("Returned Land Details:\n")
        file.write("--"*70+"\n")
        file.write("Kitta.no \t City \t\tDirection \t Anna \t\tPrice  \t\tRented Time \t\tFine Price \t\tTotal Price\n")
        file.write("--"*70+"\n")



        
        print("_"*140)
        print('                                             Techno Property Nepal')
        print('                                     ph.no:01-7374939,Baneshwor,Kathmandu,Nepal')
        print("=="*70)
        print("--"*70)
        print("Billed To:")
        print("--"*70)
        print("Client Name:"+name)
        print("Date and time of return: "+str(date_time), )
        print("__"*70)
        print("\n")
        print("Returned Land Details:")
        print("--"*70)
        print("Kitta.no \t City \t\tDirection \t Anna \t\tPrice  \t\tRented Time \t\tTotal Price \t\tFine Price")
        print("--"*70)
        for each in bills:
            print(str(each[0])+"\t\t"+str(each[1])+"\t"+str(each[2])+"\t\t"+str(each[3])+"\t\t"+str(each[4])+"\t\t\t"+str(each[5])+"\t\t"+str(each[6])+"\t\t\t"+str(each[7]))
            file.write(str(each[0])+"\t\t"+str(each[1])+"\t"+str(each[2])+"\t\t"+str(each[3])+"\t\t"+str(each[4])+"\t\t\t"+str(each[5])+"\t\t"+str(each[6])+"\t\t\t"+str(each[7])+"\n")
        print("--"*70)
        print("Total Amount:                                                                                                                  "+str(Total))
        print("--"*70)
        
        file.write("--"*70+"\n")
        file.write("Total Amount:                                                                                                                  "+str(Total)+"\n")
        file.write("--"*70+"\n")
        

    
   
    
        
