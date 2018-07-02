# Lesson 6 - _Normal Distribution_

## Probability Distribution Function

- **_Probability Distribution Function:_** A normal curve with an area of 1 beneath it, to represent the cumulative 
frequency of values.

<p align="center">
    <img align="center" alt="Curve" src=../Images/06Curve.PNG><br/>
Figure 6.1: The area beneath the curve is 1.
</p>

- **_Horizontal Asymptote:_** A y-value on a graph which a function approaches but does not actually reach.
- **_Vertical Asymptote:_** A x-value on a graph which a function approaches but does not actually reach.

<p align="center">
    <img align="center" alt="Horizontal and Vertical Asymptote" width=300 src=http://image.mathcaptain.com/cms/images/83/asymptote.PNG><br/>
Figure 6.2: Horizontal and Vertical Asymptote.
</p>

-  _Area = Probability of randomly selecting less than x = Proportion in sample/Population with scores less than x_

### Finding the probability
We can use the PDF to find the probability of specific measurements occurring. The following
examples illustrate how to find the area below, above, and between particular observations.

#### Example 6.1 
The average height of students at a private university is 1.85 meters with a
standard deviation of 0.15 meters. What percentage of students are shorter or as tall as Margie
who stands at 2.00 meters.

To solve this problem the first thing we need to find is our z-score:

 - _z=x-μ/sDev = 2.05 - 1.85 / 0.15= 1.3_
 
Now we need to use the z-score table to find the proportion below a z-score of 1.33.

-  _The z-table only shows the proportion below. In this instance we are trying to find the orange area._

<p align="center">
    <img align="center" width=400 alt="Shaded Area" src=../Images/06Shaded.PNG><br/>
Figure 6.3: 85% is the shaded area.
</p>

To use the z-table we start in the left most column and find the first two digits of our z-score
(in this case 1.3) then we find the third digit along the top of the table. Where this row and
column intersect is our proportion below that z-score.

#### Example 6.2
Margie also wants to know what percent of students are taller than her. Since
the area under the normal curve is 1 we can find that proportion:

- _1-0.9082= 0.0918 = 9.18%_

#### Example 6.3
Anne only measures 1.87 meters. What proportion of classmates are between Anne and Margies heights.
We already know that 90.82% of students are shorter that Margie. So lets first find the percent
of students that are shorter than Anne.

<p align="center">
    <img align="center" alt="ZTable" src=../Images/06ZTable.PNG><br/>
Figure 6.4: Using the z-table for 1.33. 
</p>

This means that Margie is taller than 90.82% of her classmates.

- _1.87-1.85/0.15 = 0.13_

If we use the z-table we see that this z-score corresponds with a proportion of 0.5517 or
55.17%. So to get the proportion in between the two we subtract the two proportions from each
other. That is the proportion of people who’s height’s are between Anne and Margies height is
90.82-55.17 = 35.65%.
