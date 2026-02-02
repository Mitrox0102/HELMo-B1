.data
A:	.word	123456
B:	.word	987654

.text
	lw $s0, A
	lw $s1, B
	add $s2, $s0, $s1      # $s2 = $s0 + $s1
	
	move $a0, $s2
	jal PR_INT
	
	li $v0, 10		# appel systeù exit => 10
	syscall

PR_INT:
	li $v0, 1		# appel systeme print integer => 1
	syscall
	li $a0, '\n'
	li $v0, 11		# appel systeme print character => 11
	syscall
	jr $ra


