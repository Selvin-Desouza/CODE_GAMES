#discount based on user input.. 
#Take number of products from the user and give discount on the products 

#number of products: NOP
NOP = int(input("Enter number of products : "))
sum=0
for i  in range(NOP):
    price = int(input("Enter Price of product :"))
    sum = (sum + price)


discount = float(input("Enter the percentage for discount : "))

print("Total Cost Amount : ", sum)
discountamount = (discount*sum)/100
print("Total Payable Amount : ", sum-discountamount)
