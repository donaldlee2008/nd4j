---
layout: page
title: "ND4J, Scala & Scientific Computing"
description: 
---
{% include JB/setup %}

Below you'll find illustrations of how ND4J's Scala API works. Notice how similar the syntax is to Python. (You can run the Scala examples using [this file](https://github.com/deeplearning4j/nd4j/blob/master/ScalaMain.scala).)

Before using Scala ND4J, please make sure you have: 

* The nd4j-scala-api Maven dependency
* The the Scala plugin (IntelliJ: Preferences -> Plugins)
* The Maven Scala plugin and plugin repository to your pom.xml file

        object ScalaMain {
             def main (args: Array[String]) {
             
             /** Creating arrays in multiple ways, all using numpy syntax */
             
             var arr = Nd4j.create(4)
             var arr2 = Nd4j.ones(4)
             val arr3 = Nd4j.linspace(1, 10, 10)
             val arr4 = Nd4j.linspace(1, 6, 6).reshape(2, 3)
             
            /** Array addition in place */

            arr += arr2
            arr += 2
            
            /** Array multiplication in place */
            
             arr2 *= 5
             
            /** Transpose matrix */
            
            val arrT = arr.T
            
            /** Row (0) and Column (1) Sums */
            
            println(Nd4j.sum(arr4, 0) + "Calculate the sum for each row")
            println(Nd4j.sum(arr4, 1) + "Calculate the sum for each column")
            
            /** Checking array shape */
            
            println(Arrays.toString(arr2.shape) + "Checking array shape")
            
            /** Converting array to a string */
            
            println(arr2.toString() + "Array converted to string")
            
            /** Filling the array with the value 5 (same as numpy's fill method) */
            
            println(arr2.assign(5) + "Array assigned value of 5 (equivalent to fill method in numpy)")
            
            /** Reshaping the array */
            
            println(arr2.reshape(2, 2) + "Reshaping array")
            
            /** Raveling the array (returns a flattened array) */
            
            println(arr2.ravel + "Raveling array")
            
            /** Flattening the array (same as numpy's flatten method) */
            
            println(Nd4j.toFlattened(arr2) + "Flattening array (equivalent to flatten in numpy)")
            
            /** Array sorting */
            
            println(Nd4j.sort(arr2, 0, true) + "Sorting array")
            println(Nd4j.sortWithIndices(arr2, 0, true) + "Sorting array and returning sorted indices")
            
            /** Cumulative sum */
            
            println(Nd4j.cumsum(arr2) + "Cumulative sum")
            
            /** Basic stats methods */
            
            println(Nd4j.mean(arr) + "Calculate mean of array")
            println(Nd4j.std(arr2) + "Calculate standard deviation of array")
            println(Nd4j.`var`(arr2), "Calculate variance")
            
            /** Find min and max values */
            
            println(Nd4j.max(arr3), "Find max value in array")
            println(Nd4j.min(arr3), "Find min value in array")
            
              }
             }