# avaj_launcher

Frankfurt airport faces landing track bottlenecks due to weather changes and seeks a solution through a simulator.

The chief designer, opting for Java in a diverse OS environment, provides a UML class diagram and emphasizes key design patterns: Observer, Singleton, and Factory. 

To join the team, expertise in interpreting UML class diagrams, knowledge of Java syntax, and familiarity with core features are essential. 

The aim is to develop a flexible simulator, that anticipates future needs. The focus is on a clean, easily understandable design, reflecting the high standards of the top software shop.

![image](https://github.com/Saxsori/avaj_launcher/assets/92129820/6ad2f8ec-0ada-4c20-ae7c-e2ea75c43a07)


## General instructions
- Allowed to use language features up to the latest Java LTS version.
- Allowed to use any external libraries, build tools, or code generators.
- Do not use the default package.
- Create relevant packages following the Java package naming conventions.
- Do not commit .class files.
- Get Javac and Java available as commands in your terminal.
- Compile the project running the commands below in the root of your project folder.

```ruby
$find * -name "*.java" > sources.txt
$javac @sources.txt
```

> [!IMPORTANT]
> I have created two versions with different ways of compiling the program, for learning purposes. I used Maven "a building tool and a dependency manager" in this branch. In the [submission version](https://github.com/Saxsori/avaj_launcher/tree/submit_version), I created a [script](https://github.com/Saxsori/avaj_launcher/blob/submit_version/simulator/launch.sh) that aligns with the project's instructions, achieving the same outcomes.

## Program behavior
- Accept a single command-line argument representing a scenario file name.
- Utilize the provided example file in the subject.
- Upon execution, generate a simulation.txt file detailing the simulation outcome.

## Scenario file
- The file's initial line holds a positive integer indicating the simulation's run count, representing weather change occurrences.
- Subsequent lines specify aircraft details for simulation, formatted as **TYPE NAME LONGITUDE LATITUDE HEIGHT**.

```
25
Helicopter H88 654 33 20   
Baloon B1 2 3 20
Baloon B2 1 8 66
JetPlane J1 23 44 0
Helicopter H2 22 33 44
Helicopter H3 98 68 99
Baloon B3 102 22 34
JetPlane J2 11 99 768
Helicopter H4 223 23 54
```
## Weather generation
There are 4 types of weather:
- RAIN
- FOG
- SUN
- SNOW

Each 3-dimensional point has its own weather.

Use whatever generation algorithm, as long as it takes into account the point’s coordinates.

## Aircrafts 

- JetPlane:
  - SUN - Latitude increases with 10, Height increases with 2
  - RAIN - Latitude increases with 5
  - FOG - Latitude increases with 1
  - SNOW - Height decreases with 7

- Helicopter:
  - SUN - Longitude increases with 10, Height increases with 2
  - RAIN - Longitude increases with 5
  - FOG - Longitude increases with 1
  - SNOW - Height decreases with 12

- Baloon:
  - SUN - Longitude increases with 2, Height increases with 4
  - RAIN - Height decreases with 5
  - FOG - Height decreases with 3
  - SNOW - Height decreases with 15

## Simulation
- Coordinates are positive numbers.
- The height is in the 0-100 range.
- If an aircraft needs to pass the upper limit height it remains at 100.
- Each time an aircraft is created, it receives a unique ID. There can’t be 2 aircraft with the same ID.
- If an aircraft reaches height 0 or needs to go below it, the aircraft lands, unregisters from the weather tower, and logs a message.
- When a weather change occurs, each aircraft type needs to log a message, as seen in the example. The message format is **TYPE#NAME(UNIQUE_ID): SPECIFIC_MESSAGE**.
- A funny message will be appreciated during the correction.
- Each time an aircraft registers or unregisters to/from the weather tower, a message will be logged.

## Validation
The input file needs to be validated. Any abnormal behavior due to invalid input data is not acceptable. If the input file data is not correct the program stops execution. Any error messages will be printed to the standard output.

## Bonus part
- Create custom exceptions for treating abnormal behavior.

## Launch the Program
> [!NOTE]
> I have used Docker Container to install the Java Development Kit (OpenJDK11) that I need to compile the Program.

### Master Version

- First start the container, then compile and run the program using the script.
``` ruby
make all
sh launch.sh
```

- To check the output file, u can find it in this path
```
cat ./src/output/simulation.txt
```
### Submission version

- First start the container, then compile and run the program using the script.
``` ruby
make all
sh launch.sh
java -jar simulation.jar 
```

- To check the output file, u can find it in this path
```
cat ./simulation.txt
```


