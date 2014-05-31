AdvertisingDirectory
====================

OS : Ubuntu 13.04

Required Softwares:
===================
OpenJDK Java 7 Runtime
Apache Ant 1.7.1

SETUP
=====
1. Navigate to the path where the Project folder is present
   Eg: projectdemo@ubuntu:~/Downloads/AdvertisingDirectory-master/AddDirectory 
   
2. Command to execute the code:
   java -jar build/jar/addagency.jar

3. Command to execute unit tests:
   ant
   
NOTE:
=====
Before executing make sure that the files AddDirectory, conf.properties, xmldatafile.xml are in the same path or folder
ie. the three files must share the same path or folder.

COMMANDS USED:
==============
1. Load
   To load the conf.properties and the xmldatafile.xml file

2. adl show
   Displays all the categories and the no. of listings in each category and all the Home-Page Featured (HF) listings.

3. adl show --Category <category-name>
   Displays only the listings that are Category Featured (CF) under the specified category.
   And it also displays all the listings that belong to the specified category. 
   E.g.: adl show --Category medical

4. adl show --feature <feature-name>
   Displays all the listings that belong to the specified feature (CF/HF/R)
   E.g.: adl show --feature cf

5. adl add --Name <name> --Price <price> --startDate <start date> --endDate <end date> --Category <category> --feature <feature> --advInfo <advertiserInfo>
  Adds a new listing to the Directory.
  E.g.: adl add --Name L14-cf-medical --Price 1000 --startDate 01/01/2011 --endDate 01/01/2020 --Category medical --feature cf --advInfo L14-cf-medical

6. adl delete --Name <name>
   Deletes the specified listing from the directory.
   E.g.: adl delete --Name L1-hf-medical

7. adc show
   Displays all the categories in the directory.

8. adc add --Name <category-name>
   Adds a new category to the directory.
   E.g.: adc add --Name business

9. adc delete --Name <category-name>
   Deletes the specified category and all the listings that belong to the category.
   E.g.: adc delete --Name business

10. adc update --Name <category-name> --NewName <category-new-name>
    Updates the name of the specified category.
    E.g.: adc update --Name lawyers --NewName law

CONFIGURATION SETTINGS:
=======================
1.To display listings in the order of Price. 
  Remove “#” in front of displayType=price in conf.properties file and save it.

2.To display listings in the alphabetical order of name. 
  Remove “#” in front of displayType=name in conf.properties files and save it.

3.To display listings in the order of Date. 
  Remove “#” in front of displayType=date in conf.properties file and save it.

4.To display listings in random order.
  Remove “#” in front of displayType=random in conf.properties file and save it.
