#Perabjoth Singh Bajwa ID:2449713 CSCI 3301
#index of fibonacci is stored in variable index and result is returned in register $t2

.data
index: .word -5
message1: .asciiz "The fibonacci of "
message2: .asciiz " is: "
message3: .asciiz ".\n"
message4: .asciiz "Inavlid value.\n"
.text 
main:
	lw $t1, index
	ble $t1, $zero, ZERO
	jal FIBONACCI
	la $a0, message1#printing answer as a message
	li $v0, 4
	syscall
	lw $a0, index
	li $v0, 1
	syscall
	la $a0, message2
	li $v0, 4
	syscall
	add $a0, $t2, $zero
	li $v0, 1
	syscall
	la $a0, message3
	li $v0, 4
	syscall
	j DONE
FIBONACCI:
	addi $sp, $sp, -8 # adjust stack for 2 items
	sw $ra, 4($sp) # save return address
	add $t2, $zero, $t1 # making a copy of n
	ble $t1, 1, L1 # test for n < 2
	sw $t1, 0($sp) # save argument 
	addi $t1, $t1, -1# decrementing n
	jal FIBONACCI #calling fibonacci on n-1
	lw $t1, 0($sp) #getting n back
	sw $t2, 0($sp)	#storing fib(n-1)
	addi $t1, $t1, -2 #getting n-2
	jal FIBONACCI #calling fibonacci on n-2
	lw $t3, 0($sp) #getting fibonacci (n-2)
	add $t2, $t2, $t3 #adding fib(n-1) + fib(n-2)
L1: 
	lw $ra, 4($sp)#restoring the return address
	lw $t1, 0($sp)#restoring value of $t1
	addi $sp, $sp, 8 #incrementing stack to adjust back
	jr $ra #returning to place of call

	la $a0, message1
	li $v0, 4
	syscall
	lw $a0, index
	li $v0, 1
	syscall
	la $a0, message2
	li $v0, 4
	syscall
	li $a0, 0
	li $v0, 1
	syscall
	la $a0, message3
	li $v0, 4
	syscall
	j DONE
	ZERO:#if zero or less then, fibonacci gives you zero
	la $a0, message4
	li $v0, 4
	syscall
DONE:

