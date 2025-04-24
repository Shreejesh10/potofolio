from operation import display
from operation import rent_land
from operation import return_land

def main():
    """
    Main function to manage land renting and returning operations.
    Displays available land, then ask
    """
    display() #Calling display function form operation 
    while True:
        #Taking user input
        choice = input("Do you want to rent, return, or exit (rent/return/exit): ")
        if choice == "rent":
            rent_land()
        elif choice == "return":
            return_land()
        elif choice == "exit":
            break #Breaking while loop 

        
main()
