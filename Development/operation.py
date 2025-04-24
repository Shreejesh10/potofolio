#Importing neccessary function
import read
from write import write_files
from write import invoice_gen
from write import return_invoice_gen
# For reading land data form file
land_data = read.read_files()

#Function to display land data
def display():
    """
    Displays the available land data.
    Prints data in a managed way which is seprated by tab.
    """
    print("--" * 60)
    print("\t\t\t\t\t\tLand Data")
    print("--" * 60)
    print("Kitta.no \t City\t\t     Direction        Anna\t       Price\t\tAvailability")
    print("__" * 60)
    #printing each land information while itterating through land data
    for key, value in land_data.items():
        print(key, end="\t\t")

        for v in value:
            print(v, end="\t\t")
        print("\n")
    print("__" * 60)

#Function for renting land
def rent_land():
    """
    Manage the process of renting land.
    Asks user information, validates input, rents the selected land,
    generates rent invoice, and updates land availability status.
    """
    #Getting user information
    name = input("Enter your Name: ")
    #Asking the phone number until it contains exactly 10 digits
    while True:
        phone_number = input("Enter your Phone Number: ")
        if len(phone_number) == 10 and phone_number.isdigit():
            break
        else:
            print("phone number must be of 10 digits. Please try again")
    address = input("Enter your Address: ")
    target = True  # For asking the user to rent the land again or not
    bills = [] #List to store rent invoice
    while target == True:
        try:
            kitta_number = int(input("Enter the land kitta number you want to rent: "))
        
            kitta_number = str(kitta_number)
            if kitta_number in land_data.keys():
                # if the land status is available then the land cannot be rented
                if land_data[kitta_number][4] == "Not Available":
                    print("The land is already rented")
                else:
                    while True:
                        #Renting the land
                        rent_time = int(input("For how many months are you willing to rent the land: "))
                        if rent_time <= 0:
                            print("The land must be rented for atleast one month")
                        else:
                            break
                        
                    land_data[kitta_number][4] = "Not Available"
                    selected_item = land_data[kitta_number]
                    #Storing value in the rent bill
                    bills_items = [kitta_number, selected_item[0], selected_item[1], selected_item[2], selected_item[3],rent_time, int(selected_item[3]) * int(rent_time)]
                    bills.append(bills_items)
                    print("Land rented succesfully")
                    #For asking the user to rent more land or not
                    yes_target= True
                    while yes_target== True:
                        yes_no = input("Do you want to rent more land (yes/no)?").lower()
                        if yes_no == "yes":
                            display()#Display land data for selecting another land
                            yes_target =False
                        elif yes_no == "no":
                            target = False #Stop the renting process
                            #Calling the invoice gen function 
                            invoice_gen(name, address, phone_number, bills)
                            write_files(land_data)#Writing the status of the land from available to not available
                            yes_target = False
                        else:
                            print("Enter valid input")
            else:
                print("Enter a valid kitta number")
        except ValueError:
            print("Only numbers")

# Function for returning land
def return_land():
    """
    Manage the process of returning rented land.
    Asks user information, validates input, returns the selected rented land,
    generates return invoice, and updates land availability status.
    """
    
    # Getting returner's information
    name = input("Enter your name: ")
    return_target = True  # For asking the user to return the land again or not
    bills = [] #List to store return invoice
    while return_target == True:
        try:
            kitta_number = int(input("Enter the land kitta number you want to return: "))
            kitta_number = str(kitta_number)
            if kitta_number in land_data.keys():
                # if the land status is available then the land cannot be returned
                if land_data[kitta_number][4] == "Available":
                    print("The land is not rented")
                else:
                    #The land status will be set to available
                    land_data[kitta_number][4] = "Available"
                    # For the rent time
                    while True:
                        stored_month= int(input("For How much month have you rented the land for:"))
                        if stored_month <= 0:
                            print("The land must be rented atleast 1 month")
                        else:
                            break
                    #For calculating the fine
                    fine = int(input("For How many months did you use the land: "))
                    if stored_month >= fine:
                        fine_price = 0
                    else:
                        #Calculating the the fine 
                        fine_price = int((fine - stored_month) * 1.2 * int(land_data[kitta_number][3]))
                    ret_selected_item = land_data[kitta_number]
                        # Generating return bill
                    bills_items = [kitta_number, ret_selected_item[0], ret_selected_item[1], ret_selected_item[2],ret_selected_item[3], str(fine), int(ret_selected_item[3]) * int(stored_month),str(fine_price)]
                    bills.append(bills_items)
                    print("Land is returned successfully")
                    yes_target = True
                    while yes_target:
                        return_yes_no = input("Do you want to return the land again(yes/no)?").lower()
                        if return_yes_no == "yes":
                            yes_target= False
                            display()# Display land data for selecting another land to return
                        elif return_yes_no == "no":
                            return_target = False # Stop returning process
                            yes_target = False
                            print("\n")
                                # Generating return invoice and updating land data file
                            return_invoice_gen(name, bills)
                            write_files(land_data)
                        else:
                            print("Enter Valid input")
            else:
                print("Enter a valid kitta number")
        except ValueError:
            print("Only Numbers")
