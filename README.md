### Process console input:

 `mvn scala:compile scala:run`

 `gradle run`
 
 Run sbt, in console: `runMain HashCode2018`

### Process test1.in and test2.in files:

 `mvn scala:compile scala:run "-DaddArgs=test1|test2"`
 
 `gradle run -Dexec.args="test1|test2"`
 
 Run sbt, in console: `runMain HashCode2018 arg1 test1 test2`
 
### Process *.in files:
 
 `mvn scala:compile scala:run "-DaddArgs=*"`
 
 `gradle run -Dexec.args="*"`
 
 Run sbt, in console: `runMain HashCode2018 arg1 *`
