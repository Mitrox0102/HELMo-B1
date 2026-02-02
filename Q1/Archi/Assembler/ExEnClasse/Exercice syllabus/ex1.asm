.data

N:		.word 10
M:		.word 3


.text
	
	lw $t0, N
	lw $t1, M
	move $t2, $t1
	
LOOP:	blez $t0, EXIT
	move $a0, $t1
	jal PR_INT
	add $t1, $t1, $t2
	subi $t0, $t0, 1
	j LOOP	
	


PR_INT:
	li $v0, 1		# appel systeme print integer => 1
	syscall
	li $a0, '\n'
	li $v0, 11		# appel systeme print character => 11
	syscall
	jr $ra


EXIT:	li $v0, 10		# appel systeme exit => 10
	syscall