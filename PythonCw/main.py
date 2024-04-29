import read
from write import write_files
from operation import invoice_gen
from operation import return_invoice_gen

land_data= read.read_files()
success= True
name=""
phone_number=""
address=""
bills=[]
total_price_month ={}#Empty dictionary for fine





def display():
    print("__"*60)
    print("Kitta.no \t City\t\t     Direction        Anna\t       Price\t\tAvailability")
    print("__"*60)
    for key, value in land_data.items():
        print(key,end = "\t\t")
        
        for v in value:
            print(v,end="\t\t")
        print("\n")
    print("__"*60)

display()


def choice():
    global name,phone_number,address
    choice = input("Do you want to return the land or rent(rent/return/exit):")
    

    if choice == "rent":
        name= input("Enter your Name: ")
        phone_number= input("Enter your Phone Number: ")
        address = input("Enter your Address: ")
        target= True # For asking the user to rent the land again or not
        bills=[]
        while target== True:
            kitta_number = input("Enter the land kitta number you want to rent: ")
            if kitta_number in land_data.keys():
                 if land_data[kitta_number][4]=="Not Available":
                     print("The land is already rented")
                 else:
                    
                    rent_time = input("For how many months are you willing to rent the land: ")
                    
                    land_data[kitta_number][4]="Not Available"
                    selected_item = land_data[kitta_number]
                    
                    bills_items = [kitta_number,selected_item[0],selected_item[1],selected_item[2],selected_item[3],rent_time,int(selected_item[3])*int(rent_time)]
                    bills.append(bills_items)
                    total_price_month [kitta_number]=[selected_item[3],rent_time]
                    print("Land rented succesfully")
                    yes_no = input("Do you want to rent the land again(yes/no)?")
                    if yes_no =="Yes":
                        
                        display()
                        
                    elif yes_no == "no":
                        target= False
                        invoice_gen(name, address, phone_number,bills)
        else:
            print("Enter a valid kitta number: ")
                

                
    elif choice == "return":
        name = input("Enter your name: ")
        return_target= True #For asking the user to return the land again or not
        bills = []
        while return_target == True:
            kitta_number = input("Enter the land kitta number you want to return: ")
            if kitta_number in land_data.keys():
                if land_data [kitta_number][4]=="Available":
                    print("The land is not rented")
                else:
                    land_data[kitta_number][4]="Available"
                    fine= input("How much month ago the land was rented")
                    if int(total_price_month[kitta_number][1]) >= int(fine):
                        fine_price= 0
                    else:
                        fine_price = (int(fine) - int(total_price_month[kitta_number][1]))*(1.2* int(total_price_month[kitta_number][0]))
                        print(fine_price)
                        ret_selected_item=land_data[kitta_number]
                        bills_items=[kitta_number,ret_selected_item[0],ret_selected_item[1],ret_selected_item[2],ret_selected_item[3],fine,fine_price]
                        bills.append(bills_items)
                        
                    print("Land is return successfully")
                    return_yes_no = input("Do you want to return the land again(yes/no)?")
                    if return_yes_no =="Yes":
                            display()
                            
                    elif return_yes_no == "no":
                        return_target= False
                        print("\n")
                        return_invoice_gen(name,bills)
            else:
                print("Enter a valid kitta number")
    elif choice =="exit":
        return False
        
                
    else:
        print("Invalid entry")
    return True

while success:
    
    success = choice()
    write_files(land_data)
   
    
    
    
    
    
