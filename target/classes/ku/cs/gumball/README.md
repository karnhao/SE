# SE
6510451000 Sittipat Tepsutar

Respository นี้ใช้ประกอบการเรียนในรายวิชา 01418471-65 Software Design and Development


## Week 3
แปลง state machine diagram เป็นโค้ด

![](../../../../../../src/main/resources/ku/cs/state_machine_diagram.png)

## Week 4
ปรับปรุงโค๊ดให้เป็นไปตาม Design Patterns

ตัวอย่างผลลัพท์จากการรันโปรแกรม

```
Mighty Gumball, Inc.
Java-enabled Standing Gumball Model #2004
Inventory: 0 Gumball(s)
Machine is sold out
Gumball added +5, Invetory: 5


=== Day 1 ===

You inserted a quarter.
You have chosen the flavor orange
You turned...
A orange gumball comes rolling out the slot
Mighty Gumball, Inc.
Java-enabled Standing Gumball Model #2004
Inventory: 4 Gumball(s)
Machine is waiting for quarter
End of Day 1


=== Day 2 ===

You inserted a quarter.
You request to eject a quarter.
Quarter returned
Mighty Gumball, Inc.
Java-enabled Standing Gumball Model #2004
Inventory: 4 Gumball(s)
Machine is waiting for quarter
You turned...
ERROR: java.lang.IllegalStateException - null
End of Day 2


=== Day 3 ===

You inserted a quarter.
You turned...
YOU ARE THE WINNER! You get two gumballs for your quarter.
A random gumball comes rolling out the slot
A random gumball comes rolling out the slot
Mighty Gumball, Inc.
Java-enabled Standing Gumball Model #2004
Inventory: 2 Gumball(s)
Machine is waiting for quarter
You inserted a quarter.
You turned...
YOU ARE THE WINNER! You get two gumballs for your quarter.
A random gumball comes rolling out the slot
A random gumball comes rolling out the slot
Oops, out of gumballs!
Mighty Gumball, Inc.
Java-enabled Standing Gumball Model #2004
Machine is sold out
You turned...
Nothing happened
End of Day 3


=== Day 4 ===

You inserted a quarter.
Quarter returned. And Nothing happened.
You turned...
Nothing happened
Nothing happened
You inserted a quarter.
Quarter returned. And Nothing happened.
You turned...
Nothing happened
Nothing happened
You inserted a quarter.
Quarter returned. And Nothing happened.
You turned...
Nothing happened
Nothing happened
End of Day 4


=== Day 5 ===

You inserted a quarter.
Quarter returned. And Nothing happened.
You turned...
Nothing happened
You request to eject a quarter.
Nothing happened
End of Day 5
```
