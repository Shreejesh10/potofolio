import datetime
#Bill for renting 
def invoice_gen(name, address, phone_number,bills):
    Total = 0
    for i in bills:
        Total+=int(i[6])
    
    date_time = datetime.datetime.now()
    filename= str(date_time.year)+str(date_time.month)+str(date_time.day)+str(date_time.hour)+str(date_time.minute)+str(date_time.second)+".txt"
    with open(filename, "w") as file:
        file.write("\n\n")
        file.write("\t \t \t \t Techno Property Nepal \n")
        file.write("\n\n")
        file.write("\t \t Balaju, Kathmandu | Phone No: 9841220410 \n")
        file.write("\n\n")
        file.write("__"*70+"\n")
        file.write("Billed To:\n")
        file.write("__"*70+"\n")
        file.write("Client Name:"+name+"\n")
        file.write("Address:"+address)
        file.write("Contact Number:"+str(phone_number)+"\n")
        file.write("Date and time of purchase: "+str(date_time)+"\n" )
        file.write("__"*70+"\n")
        file.write("\n\n")
        file.write("Rented Land Details:\n")
        file.write("--"*70+"\n")
        file.write("Kitta.no \t City \t\tDirection \t Anna \t\tPrice  \t\tRented Time \t\tTotal Price\n")
        file.write("--"*70+"\n")
        
        print("\n")
        print("\t \t \t \t Techno Property Nepal ")
        print("\n")
        print("\t \t Balaju, Kathmandu | Phone No: 9841220410 ")
        print("\n")
        print("__"*70)
        print("Billed To:")
        print("__"*70)
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
# Bill for returning
def return_invoice_gen(name,bills):
    Total = 0
    fine_total= 0
    for i in bills:
        Total+=int(i[6])

    date_time= datetime.datetime.now()
    filename= str(date_time.year)+str(date_time.month)+str(date_time.day)+str(date_time.hour)+str(date_time.minute)+str(date_time.second)+".txt"
    with open(filename, "w") as file:
        file.write("\t \t \t \t Techno Property Nepal \n")
        file.write("\n\n")
        file.write("\t \t Balaju, Kathmandu | Phone No: 9841220410 \n")
        file.write("\n\n")
        file.write("__"*70+"\n")
        file.write("Billed To:\n")
        file.write("__"*70+"\n")
        file.write("Client Name:"+name+"\n")
        file.write("Date and time of return: "+str(date_time)+"\n" )
        file.write("__"*70+"\n")
        file.write("\n\n")
        file.write("Returned Land Details:\n")
        file.write("--"*70+"\n")
        file.write("Kitta.no \t City \t\tDirection \t Anna \t\tPrice  \t\tRented Time \t\tFine Price \t\tTotal Price\n")
        file.write("--"*70+"\n")



        
        print("\n")
        print("\t \t \t \t Techno Property Nepal ")
        print("\n")
        print("\t \t Balaju, Kathmandu | Phone No: 9841220410 ")
        print("\n")
        print("__"*70)
        print("Billed To:")
        print("__"*70)
        print("Client Name:"+name)
        print("Date and time of return: "+str(date_time), )
        print("__"*70)
        print("\n")
        print("Returned Land Details:")
        print("--"*70)
        print("Kitta.no \t City \t\tDirection \t Anna \t\tPrice  \t\tRented Time \t\tFine Price \t\tTotal Price")
        print("--"*70)
        for each in bills:
                print(str(each[0])+"\t\t"+str(each[1])+"\t"+str(each[2])+"\t\t"+str(each[3])+"\t\t"+str(each[4])+"\t\t\t"+str(each[5])+"\t\t"+str(each[6]))
                file.write(str(each[0])+"\t\t"+str(each[1])+"\t"+str(each[2])+"\t\t"+str(each[3])+"\t\t"+str(each[4])+"\t\t\t"+str(each[5])+"\t\t"+str(each[6])+"\n")
        print("--"*70)
        print("Total Amount:                                                                                                                  "+str(Total))
        print("--"*70)
        
        file.write("--"*70+"\n")
        file.write("Total Amount:                                                                                                                  "+str(Total)+"\n")
        file.write("--"*70+"\n")
        

    
