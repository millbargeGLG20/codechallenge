[![Build Status](https://travis-ci.com/millbargeGLG20/codechallenge.svg?branch=master)](https://travis-ci.com/millbargeGLG20/codechallenge)

codechallenge
=============

usage
-----

You must either create a new text file or use the text file, `file.txt`, that is included in the repository.  
This file should contain **numbers**, with **one number on each line**.  
Blank lines and lines containing non-numeric values will be ignored.  
Javadocs are included in the `doc` directory.

To compile, you will use either ```javac``` or ```javac.exe```, depending on your platform.

Compiling:
```bash
$ javac src/Sort.java 

$ echo $?
0

$ ls src/Sort.class 
src/Sort.class
```

To run, you will use ```java``` or ```java.exe```, depending on your platform.

Input parameters can:  
be entered at the prompt using: ```java Sort```   
**OR**  
be passed at runtime using: ```java Sort filename true```


Running (needs an input file):
```bash
$ cat file.txt 
1
2
3
5
4
5
1
1
1
2
4
4

$ CLASSPATH=src java Sort
Please enter the filename including file:
file.txt
Ascending order? Please use true/false:
true
1 1 1 1 2 2 3 4 4 4 5 5 
1 appears 4 times 
2 appears 2 times 
3 appears 1 times 
4 appears 3 times 
5 appears 2 times 
The number of unique values is 5
```
