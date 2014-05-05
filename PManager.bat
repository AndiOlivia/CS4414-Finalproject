

:cp
set PMPath=C:\CS4414
set PMJarpath=%PMPath%\jar
set PMJrePath=%PMPath%\jre

set java_home=C:\Program Files\Java\jdk1.7.0_10
path=%path%;%java_home%\bin


e:
cd %PMPath%
java -Xms256m -Xmx512m -cp %PMJarpath%\PManager.jar;%PMJarpath%\jcalendar.jar;%PMJarpath%\mysql-connector-java-5.1.12-bin.jar;%PMJarpath%\datetimepicker2.7.7.jar;%PMJarpath%\poi-3.0.2-FINAL-20080204.jar;%PMJarpath%\poi-contrib-3.0.2-FINAL-20080204.jar;%PMJarpath%\poi-scratchpad-3.0.2-FINAL-0080204.jar;%PMJarpath%\swingx-0.9.2.jar;%PMJarpath%\JDSoftUtil.jar;%PMjarpath%\JDLabelSelection.jar;%PMJarpath%\log4j-1.2.16.jar;  com.jida.client.main.ProgramEntrance
