.text

	li $t0, 5
	li $t1, 0
	
	addi $t1, $t0, 10
	
	li $v0, 1
	move $a0, $t0
	syscall
	
	li $a0, '\n'
	li $v0, 11
	syscall
	
	li $v0, 1
	move $a0, $t1
	syscall
	
	li $v0, 10
	syscall