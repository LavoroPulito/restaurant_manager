# Restaurant Manager

Restaurant Manager is a Java project that allow to manage an entire restaurant. It has a graphical interface and all the role in the restaurant have a personal window.

## 💡 Features

* Select the role in the menu
* `Waiter` put orders in the system selecting dish, quantity and table
* [Waiter] see orders that have to be delivered
* [Cooker] see the tables that have some order to be preparated
* [Cooker] see the order's informations and remove orders preparated
* [Chef] manage the menu, add and remove dish from menu
* [Chef] create new dishes for the menu
* [Casher] See all table's orders and generate receipts and save them in text file
* [Casher] Change restaurant name

<img src="/.github/screenshot.png">

## ⚠️ Requirements
For working appropriately Restaurant Manager needs Java 8+ to run jar file and be sure that the graphical interface will be load correctly

## 👷 Installation
The portable executable Restaurant_Manager.jar file can be found in the [releases page](https://github.com/LavoroPulito/restaurant_manager/releases) of this repository. You have only to download the last version and you are ready to use it.

## 💻 Usage

To use the program just click on the jar file or you can open it from line code:
```bash
java Restaurant_Manager.jar
```
or if you want to test the program you can add params -tests or -t


## 📚 Libs

* Gson: it's a Google library that allow to work with Json in java. It is imported and inclueded in the project in the [libs directory](https://github.com/LavoroPulito/restaurant_manager/tree/main/libs)


## 🚀 Roadmap
This program is executed in local, so for the whole restaurant there is only a computer. The idea is implementing a separated program for each role. It can be done with two improvements:
* Socket connection: the informations are trasmitted from one terminal and the other via internet connection(using TCP protocol for example), connecting to the Main terminal's socket (the cash register for example)

* Database: so the main terminal receives and sends informations but it has to save them, it can use Json files but using databases in the project makes it more maintainable and tidy, specially if it is used in connections
