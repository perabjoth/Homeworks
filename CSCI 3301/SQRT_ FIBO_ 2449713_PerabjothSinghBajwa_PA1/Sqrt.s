#Perabjoth Singh Bajwa ID:2449713 CSCI 3301
#The result is returned in $f12 and the variable is assigned in x in the .data section
.data
x: .float 69
divisor: .float 2
zero: .float 0
zero_answer: .asciiz "Square root of 0.0 is: 0.0.\n"
error_m: .asciiz "Square root not supported for given value.\n"
answer: .asciiz "The square root of "
answer2: .asciiz " is: "
answer3: .asciiz ".\n"
hundred: .float 100
.text
main:

SQRT:
	l.s $f14, zero
	l.s $f1, x #getting the value and this will be the lower index
	l.s $f10, zero#other index which is the higher index
	c.lt.s $f1, $f14
	bc1t WRONG #if value less than zero, then error message
	c.eq.s $f1, $f14
	bc1t ZERO#if zero that is the answer
DIVIDE:
	l.s $f2, divisor#getting 2
	div.s $f3, $f1, $f2#dividing number by 2
	addi $sp, $sp ,-4
	s.s $f3, 0($sp)
	add.s $f5, $f3, $f14#moving answer to another register
MULTIPLY:
	mul.s $f2, $f5, $f3#multiplying number by itself
	c.eq.s $f9, $f2#comparing value to last attained value(look at line 34)
	bc1t ANSWER#if last value was same then answer was found
	add.s $f9, $f2, $f14#saving number for later use for comparison two lines before this
	l.s $f4, x
	l.s $f18, hundred#loading hundred
	mul.s $f2, $f2, $f18
	cvt.s.w $f2, $f2
	cvt.w.s $f2, $f2
	div.s $f2, $f2, $f18#rounded the squared float to two places after point
	c.eq.s $f2, $f4
	bc1t ANSWER#answer found
	c.le.s $f2, $f4
	bc1f MARK1#answer greater 
	c.lt.s $f2, $f4
	bc1t MARK2#answer is less
MARK1:
	add.s $f1, $f3, $f14#storing number in f1
	add.s $f1, $f10, $f1
	l.s $f2, divisor
	div.s $f3, $f1, $f2#dividing number by 2 to get new midpoint
	addi $sp, $sp ,-4
	s.s $f3, 0($sp)
	add.s $f5, $f3, $f14#moving answer to another register
	j MULTIPLY
MARK2:
	add.s $f10, $f3, $f14
	l.s $f2, divisor
	add.s $f1, $f3, $f1
	div.s $f3, $f1, $f2#getting new midpoint
	addi $sp, $sp, -4
	s.s $f3, 0($sp)
	add.s $f5, $f3, $f14
	j MULTIPLY
	
	j DONE
ZERO:#if zero it is square root of itself
	la $a0, zero_answer 
	li $v0, 4
	syscall
	j DONE
WRONG: #if negative provide error message

	la $a0, error_m
	li $v0, 4
	syscall	
	j DONE
ANSWER:
	la $a0, answer
	li $v0, 4
	syscall
	li $v0, 2
	l.s $f12, x
	syscall
	la $a0, answer2
	li $v0, 4
	syscall
	li $v0, 2
	add.s $f12, $f3, $f14
	syscall
	la $a0, answer3
	li $v0, 4
	syscall
DONE:

