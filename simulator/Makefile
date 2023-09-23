# **************************************************************************** #
#                                                                              #
#                          MAKE FILE FOR JAVA PROGRAM                          #
#                                                                              #
# **************************************************************************** #

# Path: src/Makefile

JAVAC = javac

JAVA = java

JAR = jar

# SRC_DIR = ./App

SRC_DIR := src/main/java


OUT_DIR = ./bin

# SOURCES = $(wildcard $(SRC_DIR)/*.java)

SOURCES := $(shell find $(SRC_DIR) -name '*.java')

# pattern substitution to generate a list of class files from the list of Java sources files
# modifying each dource file from the SOURCES list by replacing the .java extension with .class
CLASSES = $(SOURCES:$(SRC_DIR)/%.java=$(OUT_DIR)/%.class)

JAR_FILE = simulator:1.0.jar

MANIFEST_FILE = Manifest.txt

# **************************************************************************** #
#                                MAKE RULES                                    #
# **************************************************************************** #

all: $(JAR_FILE)

$(MANIFEST_FILE):
	echo "Main-Class: ae.fortytwo.App" > $(MANIFEST_FILE)

$(OUT_DIR):
	mkdir -p $(OUT_DIR)

$(JAR_FILE): $(MANIFEST_FILE) $(CLASSES)
	$(JAR) cfm $(JAR_FILE) $(MANIFEST_FILE) -C $(OUT_DIR) .


# ? Changing the default behavior of the implicit rule for compiling Java source files to class files
# ? and Redefine it to customize it to achive this desired behavior:
# ? 1- Placing the class files in a different directory
# ? 2- Creating the necessary directory structure
# ? 3- Creating the target directory ($(OUT_DIR)) if it doesn't exist
# * @D ->>> is the directory part of the target pattren, It helps in creating the necessary directory structure
# * although in this case it's the same as OUTPUT_DIR but it's a good practice to use it.
# * $< ->>> refer to the first prerequisite, in this case the Java source file.
# * javac -d ->>> means to put the generated class files in the directory specified by the -d option
# * so it's equivalent to javac -d bin App/Menu.java.
$(OUT_DIR)/%.class: $(SRC_DIR)/%.java
	mkdir -p $(@D)
	$(JAVAC) -d $(OUT_DIR) $(SOURCES)

run: $(JAR_FILE)
	$(JAVA) -jar $(JAR_FILE)

clean:
	rm -rf $(OUT_DIR) $(JAR_FILE) $(MANIFEST_FILE)
