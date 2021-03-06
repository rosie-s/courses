# Lesson 4 - _Variability_

## Box Plots and The IQR

A box plot is a great way to show the 5 number summary of a data set. The 5 number summary consists of the minimum, first quartile, median, third quartile, and the maximum.

- **_Interquartile range:_** The distance between the 1st quartile and 3rd quartile, it gives us the range of the middle 50% of our data.
The IQR is found by computing: Q3 - Q1

<p align="center">
    <img align="center" alt="A simple boxplot" src=https://d2gne97vdumgn3.cloudfront.net/api/file/STem3CnrQSS47G6ePhZp><br/>
Figiure 4.1: A simple boxplot
</p>

### Finding outliers
-  **_How to identify outliers:_** You can use the IQR to identify outliers:
    1. Upper outliers: Q3 + 1.5 (IQR)
    2. Lower outliers: Q1 - 1.5 (IQR)

## Variance and Standard Deviation
- **_Variance:_** The average of the squared differences from the mean. 

- **_Standard Deviation:_** The square root of the variance, it is used to measure distance from the mean.
     -  _In a normal distribution 65% of the data lies within 1 standard deviation from the mean,
95% within 2 standard deviations, and 99.7% within 3 standard deviations._

### Bessel’s Correction
- **_Bessel’s Correction:_** Corrects the bias in the estimation of the population
variance, and some (but not all) of the bias in the estimation of the population standard
deviation. To apply Bessel’s correction we multiply the variance by n/n-1

     -  _Use Bessel’s correction primarily to estimate the population standard deviation._
